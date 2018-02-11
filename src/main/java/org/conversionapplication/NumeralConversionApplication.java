package org.conversionapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NumeralConversionApplication {
    public static void main(String[] args) {
        System.out.println("numeralConversion main 1");
        SpringApplication.run(NumeralConversionApplication.class, args);
        System.out.println("numeralConversion main 2");
    }
}
