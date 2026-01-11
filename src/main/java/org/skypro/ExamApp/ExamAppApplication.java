package org.skypro.ExamApp;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition
public class ExamAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExamAppApplication.class, args);
    }

}
