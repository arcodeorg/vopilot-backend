package com.arcode.vopilot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class VopilotBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(VopilotBackendApplication.class, args);

        String urlSwagger = "http://localhost:8080/swagger-ui.html";
        System.out.println("Swagger: " + urlSwagger);
    }
}