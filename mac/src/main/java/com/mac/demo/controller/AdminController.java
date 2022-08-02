package com.mac.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mac.demo.model.Board;
import com.mac.demo.model.User;
import com.mac.demo.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	

	@Autowired
	private AdminService svc;
	
	//관리자 페이지 메인
	@GetMapping("")
	public String adminMain() {
		return "thymeleaf/mac/admin/adminMain";
	}
	
    //모든 유저 정보
	@GetMapping("/allUser")
	public String allUser(Model model,@RequestParam(name="page", required = false,defaultValue ="1") int page) {
		
		//페이지를 설정하면 처음으로 뜰 화면을 기본1로 설정하여 startPage에 넣어준다
	     PageHelper.startPage(page, 2);
			//startPage시작하는 페이지 넘버와 그 페이지에 얼마의 글이 들어갈지를 정한다.
			PageInfo<User> pageInfo = new PageInfo<>(svc.findAllUser());
			List<User> list= pageInfo.getList();
			 model.addAttribute("pageInfo", pageInfo);
             return "thymeleaf/mac/admin/allUser";
	}
	
	//모든 자유게시판
	@GetMapping("/allFreeBoard")
	public String allFreeBord(Model model,@RequestParam(name="page", required = false,defaultValue ="1") int page) {
		//페이지를 설정하면 처음으로 뜰 화면을 기본1로 설정하여 startPage에 넣어준다
	     PageHelper.startPage(page, 2);
			//startPage시작하는 페이지 넘버와 그 페이지에 얼마의 글이 들어갈지를 정한다.
			PageInfo<Board> pageInfo = new PageInfo<>(svc.findAllFreeBord());
			List<Board> list= pageInfo.getList();
			 model.addAttribute("pageInfo", pageInfo);
		return "thymeleaf/mac/admin/allFreeBoard";
	}
	
	//모든 광고게시판
	@GetMapping("/allAdsBoard")
	public String allAdsBoard(Model model,@RequestParam(name="page", required = false,defaultValue ="1") int page) {
		//페이지를 설정하면 처음으로 뜰 화면을 기본1로 설정하여 startPage에 넣어준다
	     PageHelper.startPage(page, 2);
			//startPage시작하는 페이지 넘버와 그 페이지에 얼마의 글이 들어갈지를 정한다.
			PageInfo<Board> pageInfo = new PageInfo<>(svc.findAllAdsBoard());
			List<Board> list= pageInfo.getList();
			 model.addAttribute("pageInfo", pageInfo);
		return "thymeleaf/mac/admin/allAdsBoard";
	}
	
	
	
	@PostMapping("/UserDeleted")
	@ResponseBody
	public Map<String,Object> UserDeleted(User user, HttpSession session) {
		Map<String, Object> map = new HashMap<>();
		String idMac = user.getIdMac();
		boolean result = svc.UserDeleted(idMac);
		map.put("result", result);
		return map;
	}
	
//	계정 삭제
	@PostMapping("/freeBoardDeleted")
	@ResponseBody
	public Map<String,Object> freeBoardDeleted(Board board, HttpSession session) {
		Map<String, Object> map = new HashMap<>();
		String idMac = board.getIdMac();
		boolean result = svc.freeBordDeleted(idMac);
		map.put("result", result);
		return map;
	}
//	계정 삭제
	@PostMapping("/adsBoardDeleted")
	@ResponseBody
	public Map<String,Object> adsBoardDeleted(Board board, HttpSession session) {
		Map<String, Object> map = new HashMap<>();
		String idMac = board.getIdMac();
		boolean result = svc.adsBoardDeleted(idMac);
		map.put("result", result);
		return map;
	}

}
