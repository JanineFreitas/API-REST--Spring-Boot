package com.demojanine.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/")
public class HomeController {
	
	@GetMapping
	public String getHelloWord() {
		return "Opa, to no ar!";
	}

}
