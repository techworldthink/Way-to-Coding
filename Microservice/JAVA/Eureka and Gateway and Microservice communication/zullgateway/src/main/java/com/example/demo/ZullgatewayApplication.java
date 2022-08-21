package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@SpringBootApplication
public class ZullgatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZullgatewayApplication.class, args);
	}

	@Bean
	  public SimpleFilter simpleFilter() {
	    return new SimpleFilter();
	  }
}
