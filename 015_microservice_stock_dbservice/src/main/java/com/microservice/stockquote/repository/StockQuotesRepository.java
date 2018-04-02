package com.microservice.stockquote.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.stockquote.entity.StockQuote;

public interface StockQuotesRepository extends JpaRepository<StockQuote, Integer>{

	List<StockQuote> findByUsername(String username);

	

}
