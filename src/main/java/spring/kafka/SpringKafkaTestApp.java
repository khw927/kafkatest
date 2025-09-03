package spring.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author hyewon
 * @version 1.0
 */
@SpringBootApplication
@ConfigurationProperties(
        prefix = "spring.kafka"
)
public class SpringKafkaTestApp {

    public static void main(String[] args) {
        SpringApplication.run(SpringKafkaTestApp.class, args);
    }

}
