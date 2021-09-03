package com.mattvbv.testapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jdk")
public class JdkController {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	/**
	 * Call a new feature of the JDK version that is used
	 */
	@GetMapping("/test")
	public void testJdk() {
		logger.info("Calling a new Java feature (added in this JDK version)");
		" ".isBlank();
	}

}
