package com.example.ecommerce;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*********************************************************
 * Main class of the Spring Boot application.
 * The @SpringBootApplication annotation enables:
 * - Component scanning
 * - Auto-configuration
 * - Spring Boot configuration
 ********************************************************/

@SpringBootApplication
public class EcommerceApplication {
	// Static initializer block to load .env variables before the Spring application context is created.
	static {
		Dotenv dotenv = Dotenv.configure()
				.ignoreIfMissing()
				.load();
		// Set all required secrets as system properties so Spring can read them in application.properties.
		System.setProperty("MONGODB_URI", dotenv.get("MONGODB_URI"));
	}

	/**
	 * Main method – entry point of the Java application.
	 * Boots the Spring application using SpringApplication.run().
	 *
	 * @param args Command-line arguments passed to the app
	 */
	public static void main(String[] args) {

		SpringApplication.run(EcommerceApplication.class, args);
	}

}
