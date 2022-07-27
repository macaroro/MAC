package com.mac.demo.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.view.RedirectView;

import com.mac.demo.mappers.UserMapper;
import com.mac.demo.model.User;


@RequestMapping("/login")
@Controller
public class LoginController {
	
	@Autowired
	private UserMapper dao;
	
	@GetMapping("/loginForm")
	public String login() {
		
		return "thymeleaf/login/loginForm";
	}
	
//	세션에 uid저장및 db 확인
	@PostMapping("/loginForm")
	public String login(@RequestParam("uid")String uidMac, @RequestParam("upw")String pwMac, HttpSession session,Model model){
		
	     String id = dao.getId(uidMac,pwMac);//dao부분은 서비스로 넘겨주세요
		if(uidMac.equals(id)) {//dao.getId(uidMac,pwMac).equals(uidMac)
			session.setAttribute("uidMac", uidMac);
			String uid = session.getAttribute("uidMac").toString();
			model.addAttribute("uidMac",uid);
			model.addAttribute("nickNameMac",dao.getNickNameMac(uidMac));//dao부분은 서비스로 넘겨주세요
			model.addAttribute("msg",uid+"님 환영합니다");
		
			return "thymeleaf/home/home";
		}else if(id==null) {
			model.addAttribute("msg","잘못된 아이디나 비밀번호 입니다");
			
			return "thymeleaf/login/loginForm";
		}
		return null;
	
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
