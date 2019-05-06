package com.TQS.homework;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class Hw1Application {

	private static final Logger log = LoggerFactory.getLogger(Hw1Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Hw1Application.class);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate, ForecastRepository forecastRepo, DailyRepository dailyRepo, DataRepository dataRepo) throws Exception {
		return args -> {
			Forecast forecast = restTemplate.getForObject(
					"https://api.darksky.net/forecast/21555dff0ae2af8abca7aa189973ef7a/40.15621,8.85894", Forecast.class);
			for (Data d : forecast.getDaily().getData())
				dataRepo.save(d);
			dailyRepo.save(forecast.getDaily());
			forecastRepo.save(forecast);
			log.info(forecast.toString());
		};
	}

}
