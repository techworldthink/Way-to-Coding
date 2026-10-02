package com.learn.microservices.limitsservice.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.microservices.limitsservice.bean.Limits;
import com.learn.microservices.limitsservice.config.Configuration;

@RestController
public class LimitsController {
	
	@Autowired
	private Configuration config;
	
	@GetMapping("/limits")
	// http://localhost:8080/limits
	public Limits retrieveLimits() {
		//return new Limits(1, 1000);
		return new Limits(config.getMinimum(),config.getMaximum());

	}
}
