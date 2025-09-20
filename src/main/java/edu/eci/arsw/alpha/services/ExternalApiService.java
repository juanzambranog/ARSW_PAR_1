package edu.eci.arsw.alpha.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.eci.arsw.alpha.models.Alpha;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExternalApiService {

    @Value("${external.api.key}")
    private String apiKey;

    @Value("${external.api.url}")
    private String apiUrl;

    private final WebClient webClient;
    private final ObjectMapper objectMapper;

    public ExternalApiService(WebClient.Builder webClientBuilder, ObjectMapper objectMapper) {
        this.webClient = webClientBuilder.baseUrl("https://www.alphavantage.co").build();
        this.objectMapper = objectMapper;
    }

    public List<Alpha> getStockData() {
        try {
            String response = webClient.get()
                    .uri("/query?function=TIME_SERIES_INTRADAY&symbol=IBM&interval=5min&apikey=" + apiKey)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            return parseStockData(response);
        } catch (Exception e) {
            throw new RuntimeException("Error fetching data from external API: " + e.getMessage());
        }
    }

    private List<Alpha> parseStockData(String jsonResponse) {
        List<Alpha> alphas = new ArrayList<>();

        try {
            JsonNode rootNode = objectMapper.readTree(jsonResponse);
            JsonNode timeSeries = rootNode.path("Time Series (5min)");

            if (timeSeries.isMissingNode()) {
                throw new RuntimeException("No time series data found in API response");
            }

            int count = 0;
            for (JsonNode entry : timeSeries) {
                if (count >= 10) break; 

                String timestamp = entry.fieldNames().next();
                JsonNode data = entry.get(timestamp);

                Alpha alpha = new Alpha();
                alpha.setName("IBM Stock Data - " + timestamp);
                alpha.setDescription(String.format(
                    "Open: %s, High: %s, Low: %s, Close: %s, Volume: %s",
                    data.get("1. open").asText(),
                    data.get("2. high").asText(),
                    data.get("3. low").asText(),
                    data.get("4. close").asText(),
                    data.get("5. volume").asText()
                ));

                alphas.add(alpha);
                count++;
            }

        } catch (Exception e) {
            throw new RuntimeException("Error parsing API response: " + e.getMessage());
        }

        return alphas;
    }
}
