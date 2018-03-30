package com.microservice.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
@EnableEurekaServer
public class EurekaSpringBootMainEntry {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(EurekaSpringBootMainEntry.class, args);
	}

}
