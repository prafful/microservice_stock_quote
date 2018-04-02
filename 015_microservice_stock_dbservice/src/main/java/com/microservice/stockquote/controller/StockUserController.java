package com.microservice.stockquote.controller;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.stockquote.entity.StockQuote;
import com.microservice.stockquote.entity.StockQuoteList;
import com.microservice.stockquote.repository.StockQuotesRepository;

@RestController
@RequestMapping("/stocks")
public class StockUserController {
	
	@Autowired
	private StockQuotesRepository stockQuotesRepository;
	
	@RequestMapping("/get/quotes/{username}")
	public List<String> getQuotes(@PathVariable("username") final String username) {
		
		List<StockQuote> list  = stockQuotesRepository.findByUsername(username);
		
		return list.stream().map(StockQuote::getQuote).collect(Collectors.toList());
	}
	
	@RequestMapping(value = "/add", method=RequestMethod.POST)
	public List<StockQuote> addQuote(@RequestBody StockQuoteList stockQuoteList){
		
		stockQuoteList.getQuotes().stream()
							.map(stockQuote -> new StockQuote(stockQuoteList.getUsername(),stockQuote))
							.forEach(stockQuote -> stockQuotesRepository.save(stockQuote));
		return stockQuotesRepository.findByUsername(stockQuoteList.getUsername());
		
		
	}
	

}
