package com.mac.demo.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mac.demo.model.Board;
import com.mac.demo.model.User;
import com.mac.demo.service.HomeService;



@RequestMapping("/home")
@Controller
public class HomeController {
	
	@Autowired 
	private HomeService svc;

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
	
	@GetMapping("/myPage/{nickNameMac}")
	public String myPage(@PathVariable("nickNameMac") String nickNameMac, Model model) {

		model.addAttribute("user",svc.getMyPageInUser(nickNameMac));
		List<Board> freeBoard = svc.getMyPageInFreeBoard(nickNameMac);
		model.addAttribute("freeBoard", freeBoard);
		List<Board> adsBoard = svc.getMyPageInAdsBoard(nickNameMac);
		model.addAttribute("adsBoard", adsBoard);
		return "thymeleaf/home/myPage";
	}
	
	
}