package com.mac.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.mac.demo.mappers.AdminMapper;
import com.mac.demo.mappers.BoardMapper;
import com.mac.demo.model.Board;
import com.mac.demo.model.User;

@Service
public class AdminService {
	
	@Autowired 
	private AdminMapper dao;
	


	public List<User> findAllUser() {
		return dao.findAllUser();
		
	}

	public List<Board> findAllFreeBord() {
		
		return dao.findAllFreeBoard();
	}

	public List<Board>findAllAdsBoard() {
	
		return dao.findAllAdsBoard();
	}

	public boolean freeBordDeleted(String idMac) {
		return dao.freeBordDeleted(idMac);
	}

	public boolean adsBoardDeleted(String idMac) {
	
		return  dao.adsBordDeleted(idMac);
	}

	public boolean UserDeleted(String idMac) {
		
		return dao.UserDeleted(idMac);
	}

}
