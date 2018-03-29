package com.microservice.stockservice.entry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"com.microservice.stockservice"})
public class SpringBootMainEntryYahooFinance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(SpringBootMainEntryYahooFinance.class, args);
	}

}
