package com.mac.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.mac.demo.mappers.AdminMapper;
import com.mac.demo.model.User;

@Service
public class AdminService {
	
	@Autowired 
	private AdminMapper dao;

	public List<User> findAllUser() {
		return dao.findAllUser();
		
	}

}
