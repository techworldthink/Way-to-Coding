package com.spring.boot.learn.msge;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	// http://localhost:8080/hello
	@RequestMapping("hello")
	@ResponseBody
	public String sayHello() {
		return "Hello! What are you learning today?";
	}

}