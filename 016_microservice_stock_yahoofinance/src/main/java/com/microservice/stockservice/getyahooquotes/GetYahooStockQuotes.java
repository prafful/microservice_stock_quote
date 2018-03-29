package com.microservice.stockservice.getyahooquotes;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;

@RestController
@RequestMapping("/rest/getyahoo")
public class GetYahooStockQuotes {

	@Autowired
	private RestTemplate restTemplate;	
	
	@RequestMapping("/hello")
	public String welcome() {
		return "Hello from Yahoo!!!";
	}
	
	@RequestMapping("/{username}")
	public List<Stock> getStockQuote(@PathVariable("username") String username) {
		
		ResponseEntity<List<String>> yahooQuoteResponse = restTemplate
				.exchange("http://localhost:8181/stocks/get/quotes/" + username, 
						HttpMethod.GET, 
						null, 
						new ParameterizedTypeReference<List<String>>() {
		});
		
		List<String> yahooQuotes = yahooQuoteResponse.getBody();
		return yahooQuotes.stream().map(this::getQuotePrice).collect(Collectors.toList());
		 
		
				
				
	}
	
	private Stock getQuotePrice(String quote) {
		try {
			return YahooFinance.get(quote);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Stock(quote);
	}
	
}
