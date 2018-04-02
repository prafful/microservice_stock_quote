package com.microservice.stockquote.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="stockquotes")
public class StockQuote {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@Column(name="username")
	private String username;
	@Column(name="quote")
	private String quote;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getQuote() {
		return quote;
	}
	public void setQuote(String quote) {
		this.quote = quote;
	}
	public StockQuote(Integer id, String username, String quote) {
		super();
		this.id = id;
		this.username = username;
		this.quote = quote;
	}
	public StockQuote() {
		
	}
	public StockQuote(String username, String quote) {
		// TODO Auto-generated constructor stub
		super();
		this.username = username;
		this.quote = quote;
	}
	
	
	

}
