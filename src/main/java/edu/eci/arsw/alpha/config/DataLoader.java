package edu.eci.arsw.alpha.config;

import edu.eci.arsw.alpha.models.Alpha;
import edu.eci.arsw.alpha.services.AlphaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("!test")
public class DataLoader implements CommandLineRunner {

    @Autowired
    private AlphaServices alphaServices;

    @Override
    public void run(String... args) throws Exception {
        // Create some test data
        if (alphaServices.getAll().isEmpty()) {
            Alpha alpha1 = new Alpha();
            alpha1.setName("Test Alpha 1");
            alpha1.setDescription("This is a test alpha entity for testing purposes");
            alphaServices.save(alpha1);

            Alpha alpha2 = new Alpha();
            alpha2.setName("Test Alpha 2");
            alpha2.setDescription("Another test alpha entity");
            alphaServices.save(alpha2);

            Alpha alpha3 = new Alpha();
            alpha3.setName("Test Alpha 3");
            alpha3.setDescription("Third test alpha entity with more detailed description");
            alphaServices.save(alpha3);

            System.out.println("Test data loaded successfully!");
        }
    }
}
