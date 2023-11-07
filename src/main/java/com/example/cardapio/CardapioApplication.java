package com.example.cardapio;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Cardapio OpenApi", version = "1", description = "API desenvolvida para testes do OpenApi"))
public class CardapioApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardapioApplication.class, args);
	}
}
