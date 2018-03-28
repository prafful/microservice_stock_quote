package com.microservice.stockquote.mainentry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.annotation.DirtiesContext;

@SpringBootApplication
@ComponentScan(basePackages= {"com.microservice.stockquote.controller"})
@EnableJpaRepositories(basePackages= {"com.microservice.stockquote.repository"})
@EntityScan(basePackages= {"com.microservice.stockquote.entity"})
@DirtiesContext
public class StockQuoteMainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(StockQuoteMainApp.class, args);

	}

}
