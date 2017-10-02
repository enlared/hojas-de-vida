package com.nova.MsHv;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	static final Logger log = Logger.getLogger(Application.class);

	public static void main(String[] args) {
		PropertyConfigurator.configure("log4j.properties");

		log.info("Log4j socket appender test run successfully!!");

		SpringApplication.run(Application.class, args);

	}
}
