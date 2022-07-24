package com.mac.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mac.demo.model.User;



@RequestMapping("/home")
@Controller
public class HomeController {

//	홈화면
	@GetMapping("")
	public String home(Model model) {
		
		return "thymeleaf/home/home";
	}
	
//	데이터 출처
	@GetMapping("/dataSource")
	public String dataSorce() {
		
		return "thymeleaf/home/dataSource";
	}
	
//	사이트소개
	@GetMapping("/siteIntroduction")
	public String siteIntroduction() {
		
		return "thymeleaf/home/siteIntroduction";
	}
}
