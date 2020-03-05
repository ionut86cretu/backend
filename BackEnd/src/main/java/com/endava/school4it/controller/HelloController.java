package com.endava.school4it.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.endava.school4it.service.HelloService;

@RestController
public class HelloController {

	@Autowired
	private HelloService helloService;

	@Value("${nume}")
	private String nume;

	@RequestMapping("/")
	public String index() {
		return "Greetings from Endava School 2020. Numele este: " + nume;
	}


}
