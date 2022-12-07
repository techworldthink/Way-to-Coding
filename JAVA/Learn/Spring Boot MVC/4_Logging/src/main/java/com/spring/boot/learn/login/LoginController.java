package com.spring.boot.learn.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@RequestMapping("login")
	public String gotoLoginPage(@RequestParam String name, ModelMap model) {
		model.put("name", name);
		// Logging
		logger.debug("DEBUG LOG EXAMPLE");
		logger.info("INFO LOG EXAMPLE");
		logger.warn("WARNING LOG EXAMPLE");
		return "login";
	}
}
