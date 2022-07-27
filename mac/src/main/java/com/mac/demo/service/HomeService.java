package com.mac.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mac.demo.mappers.BoardMapper;
import com.mac.demo.mappers.UserMapper;
import com.mac.demo.model.Board;
import com.mac.demo.model.User;

@Service
public class HomeService {
	
	@Autowired
	private UserMapper uao;
	@Autowired
	private BoardMapper bao;
	

	public User getMyPageInUser(String nickNameMac) {
		
	 
	    return uao.getMypage(nickNameMac);
	    
		
	}
	
	public List<Board> getMyPageInFreeBoard(String nickNameMac) {
		System.out.println(bao.getMypageInFreeBoard(nickNameMac).toString());
		 
	    return bao.getMypageInFreeBoard(nickNameMac);
	    
		
	}
	public List<Board> getMyPageInAdsBoard(String nickNameMac) {
		
	    return bao.getMypageInAdsBoard(nickNameMac);
	    
		
	}

}
