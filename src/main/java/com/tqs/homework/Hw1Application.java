package com.tqs.homework;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Hw1Application {

	private static final Logger log = LoggerFactory.getLogger(Hw1Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Hw1Application.class);
	}
}
