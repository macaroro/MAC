package com.mac.demo.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.view.RedirectView;

import com.mac.demo.model.User;


@RequestMapping("/login")
@Controller
public class LoginController {
	
	
	@GetMapping("/loginForm")
	public String login() {
		
		return "thymeleaf/login/loginForm";
	}
	
//	세션에 uid저장
	@PostMapping("/loginForm")
	public String login(@RequestParam("uid")String uidMac, @RequestParam("upw")String upwMac, HttpSession session,Model model,User user){
         
		if(uidMac!=null) {
		session.setAttribute("uidMac", uidMac);
//		Map<String, Object>map=new HashMap<String,Object>();
//		map.put("login", true);
//		map.put("uidMac",uidMac);
//		map.put("upwMac",upwMac);
//		map.put("user", user);
		model.addAttribute("uidMac",session.getAttribute("uidMac").toString());
		model.addAttribute("msg", session.getAttribute("uidMac").toString()+"님 환영합니다");
		//return map;
		
		return "thymeleaf/home/home";
		}
		return null ;
	
	}
	
//	로그아웃메소드
	@GetMapping("/logout")
	@ResponseBody
	public Map<String,Object> logout(HttpSession session) 
	{ 
	
		 session.invalidate();

		Map<String,Object> map = new HashMap<>();
		map.put("logout", true);
		return map;
	}

	
}
