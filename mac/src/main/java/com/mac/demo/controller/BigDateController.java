package com.mac.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/data")
public class BigDateController {

	@GetMapping("")
	public String map(){
		return "thymeleaf/mac/bigdate/bigdate";
	}
}
