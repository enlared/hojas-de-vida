package com.udea.entidad_generica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication 
public class Application { 	
	
	// para correc con maven: mvn spring-boot:run
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args); 
	}
}
