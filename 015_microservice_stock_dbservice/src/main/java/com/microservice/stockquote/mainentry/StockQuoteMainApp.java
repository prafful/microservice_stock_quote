package com.microservice.stockquote.mainentry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@SpringBootApplication
@ComponentScan(basePackages= {"com.microservice.stockquote.controller"})
@EnableJpaRepositories(basePackages= {"com.microservice.stockquote.repository"})
@EntityScan(basePackages= {"com.microservice.stockquote.entity"})
@DirtiesContext
@EnableEurekaClient
public class StockQuoteMainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(StockQuoteMainApp.class, args);

	}

}
