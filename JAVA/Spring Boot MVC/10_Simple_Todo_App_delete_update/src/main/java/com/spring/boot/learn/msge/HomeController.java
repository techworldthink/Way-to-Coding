package com.spring.boot.learn.msge;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	@RequestMapping("welcome")
	public String home() {
		return "welcom";
	}

}