package com.example.jingyesspringbootcaffeine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class JingYesSpringbootCaffeineApplication {

	public static void main(String[] args) {
		SpringApplication.run(JingYesSpringbootCaffeineApplication.class, args);
	}

}
