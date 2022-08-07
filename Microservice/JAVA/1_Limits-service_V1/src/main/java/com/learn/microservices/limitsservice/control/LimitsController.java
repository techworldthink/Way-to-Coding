package com.learn.microservices.limitsservice.control;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.microservices.limitsservice.bean.Limits;

@RestController
public class LimitsController {

	@GetMapping("/limits")
	// http://localhost:8080/limits
	public Limits retrieveLimits() {
		return new Limits(1, 1000);

	}
}
