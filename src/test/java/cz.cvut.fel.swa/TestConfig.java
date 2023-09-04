package cz.cvut.fel.swa;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.PropertySource;

@TestConfiguration
@PropertySource("classpath:application.yml")
public class TestConfig {
}