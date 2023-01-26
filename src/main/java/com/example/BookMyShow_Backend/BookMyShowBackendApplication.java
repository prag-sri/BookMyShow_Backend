package com.example.BookMyShow_Backend;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition
public class BookMyShowBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookMyShowBackendApplication.class, args);
	}

}

//old sql dependency
//<dependency>
//<groupId>com.mysql</groupId>
//<artifactId>mysql-connector-j</artifactId>
//<scope>runtime</scope>
//</dependency>

//url for swagger-
//http://localhost:8080/swagger-ui/index.html
