package cz.cvut.fel.swa;

import java.util.logging.Logger;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
public class SwaApplication {

    private static final Logger LOGGER = Logger.getLogger(SwaApplication.class.getName());

    public static void main(String[] args) {
        SpringApplication.run(SwaApplication.class, args);
    }

}
