package org.conversionapplication;

import org.springframework.context.annotation.Bean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

/**
 * Spring boot main class to run the application
 */


@SpringBootApplication
public class NumeralConversionApplication {
    public static void main(String[] args) {
        SpringApplication.run(NumeralConversionApplication.class, args);
    }

    @Bean
    public OpenAPI springShOpenAPI() {
        return new OpenAPI()
            .info(
                new Info()
                    .title("Numeral conversion REST API")
                    .description("An API for converting numbers between different numeral systems.")
                    .version("0.0.1")
                    .license(
                        new License()
                            .name("Apache 2.0")
                    )
                    .contact(
                        new Contact()
                            .name("Joe Doe")
                            .email("example@example.com")
                            .url("www.example.com")
                    )
            );
    }
}
