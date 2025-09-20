package edu.eci.arsw.alpha.services;

import edu.eci.arsw.alpha.models.Alpha;
import edu.eci.arsw.alpha.repository.AlphaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlphaServices {

    @Autowired
    private AlphaRepository alphaRepository;

    @Autowired
    private ExternalApiService externalApiService;

    public List<Alpha> getAll() {
        try {
            // Try to get data from external API first
            return externalApiService.getStockData();
        } catch (Exception e) {
            // Fallback to database if external API fails
            System.err.println("External API failed, falling back to database: " + e.getMessage());
            return alphaRepository.findAll();
        }
    }

    public Alpha getById(Long id) {
        try {
            // Try external API first
            List<Alpha> allData = externalApiService.getStockData();
            if (id >= 0 && id < allData.size()) {
                return allData.get(id.intValue());
            }
        } catch (Exception e) {
            System.err.println("External API failed for getById, falling back to database: " + e.getMessage());
        }

        // Fallback to database
        return alphaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Alpha not found with id: " + id));
    }

    public Alpha save(Alpha alpha) {
        if (alpha == null) {
            throw new IllegalArgumentException("Alpha cannot be null");
        }
        return alphaRepository.save(alpha);
    }

    public void delete(Long id) {
        if (!alphaRepository.existsById(id)) {
            throw new RuntimeException("Alpha not found with id: " + id);
        }
        alphaRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return alphaRepository.existsById(id);
    }
}

