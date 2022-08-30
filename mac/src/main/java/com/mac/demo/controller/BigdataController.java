package com.mac.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mac.demo.model.XY;
import com.mac.demo.service.BigdataService;

@Controller
@RequestMapping("/big")
public class BigdataController {

	@Autowired
	private BigdataService svc;
	
	@GetMapping("/location")
	public String location() {
		return "thymeleaf/mac/bigdata/map";
	}
	
	@GetMapping("/test")
	public String test() {
		return "thymeleaf/mac/bigdata/bigdate";
	}
	
	//해당 데이터 테이블의 구 데이터 가져오기
		@PostMapping("/kind")
		@ResponseBody
		public Map<String,Object> gu(@RequestParam("kind")String kind,Model model) {
			Map<String, Object> map = new HashMap<>();
			
			//선택창
			String selectgu="<option value='' selected>-- 구를 선택해주세요 --</option>";
			String selectgu2="<option value='' selected>-- 구를 먼저 선택해주세요 --</option>";
			//구 리스트 저장
			List<String> gulist = svc.getgu(kind);
			//html 해석하게 수정
			List<String> gulist2 = new ArrayList<>();
			String dong = null;
			for(int i=0; i<gulist.size(); i++) {
				String gu2 = "<option>"+gulist.get(i)+"</option>";
				gulist2.add(gu2);
			}
			gulist2.add(0,selectgu);
			//구동길 리스트를 맵으로 보여줌
			map.put("gulist", gulist2);
			map.put("donglist", selectgu2);
			map.put("gillist", selectgu2);
			return map;
		}
		
		//해당 데이터 테이블의 동 데이터 가져오기
		@PostMapping("/dong")
		@ResponseBody
		public Map<String,Object> dong(@RequestParam("gu")String gu, @RequestParam("kind")String kind) {
			Map<String, Object> map = new HashMap<>();
			String selectdong="<option value='' selected>-- 동을 선택해주세요 --</option>";
			String selectdong2="<option value='' selected>-- 동를 먼저 선택해주세요 --</option>";
			List<String> donglist = svc.getdong(gu, kind);
			List<String> donglist2 = new ArrayList<>();
			for(int i=0; i<donglist.size(); i++) {
				String dong2 = "<option>"+donglist.get(i)+"</option>";
				donglist2.add(dong2);
			}
			donglist2.add(0,selectdong);
			map.put("donglist", donglist2);
			map.put("gillist", selectdong2);
			map.put("kind", kind);
			return map;
		}
		
		//해당 데이터 테이블의 골목길 데이터 가져오기
		@PostMapping("/gil")
		@ResponseBody
		public Map<String,Object> gil(@RequestParam("dong")String dong, @RequestParam("kind")String kind) {
			Map<String, Object> map = new HashMap<>();
			String selectgill="<option value='' selected>-- 길을 선택하세요 --</option>";
			List<String> gillist = svc.getgil(dong, kind);
			List<String> gillist2 = new ArrayList<>();
			for(int i=0; i<gillist.size(); i++) {
				String dong2 = "<option>"+gillist.get(i)+"</option>";
				gillist2.add(dong2);
			}
			gillist2.add(0,selectgill);
			map.put("gillist", gillist2);
			map.put("kind", kind);
			return map;
		}

		//골목길 좌표 가져오기
		@PostMapping("/xy")
		@ResponseBody
		public Map<String,Object> xy(@RequestParam("gil")String gil) {
			Map<String, Object> map = new HashMap<>();
			XY xy = svc.getxy(gil);
			int x = xy.getX();
			int y = xy.getY();
			map.put("x", x);
			map.put("y", y);
			return map;
		}
}
