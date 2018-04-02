package com.microservice.stockservice.getyahooquotes;
import java.io.IOException;
import java.math.BigDecimal;
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
	public List<Quote> getStockQuote(@PathVariable("username") String username) {
		ResponseEntity<List<String>> yahooQuoteResponse = restTemplate
				.exchange("http://db-service/stocks/get/quotes/" + username, 
						HttpMethod.GET, 
						null, 
						new ParameterizedTypeReference<List<String>>() {
		});
		List<String> yahooQuotes = yahooQuoteResponse.getBody();
		return yahooQuotes.stream().map(quote ->{
			Stock stock  = getQuotePrice(quote);
			return new Quote(quote, stock.getQuote().getPrice());
					})
				.collect(Collectors.toList());
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
	
	private class Quote {
        private String quote;
        private BigDecimal price;

        public Quote(String quote, BigDecimal price) {
            this.quote = quote;
            this.price = price;
        }

        public String getQuote() {
            return quote;
        }

        public void setQuote(String quote) {
            this.quote = quote;
        }

        public BigDecimal getPrice() {
            return price;
        }

        public void setPrice(BigDecimal price) {
            this.price = price;
        }
    }
	
	
}
