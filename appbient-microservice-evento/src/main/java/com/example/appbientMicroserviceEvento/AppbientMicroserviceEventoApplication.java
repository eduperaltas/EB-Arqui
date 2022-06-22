package com.example.appbientMicroserviceEvento;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@OpenAPIDefinition
@EnableJpaAuditing
@SpringBootApplication
@EnableEurekaClient
public class AppbientMicroserviceEventoApplication {
	public static void main(String[] args) {
		SpringApplication.run(AppbientMicroserviceEventoApplication.class, args);
	}

}
