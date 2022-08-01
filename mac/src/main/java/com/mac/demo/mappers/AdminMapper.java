package com.mac.demo.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mac.demo.model.User;

@Mapper
public interface AdminMapper {

	List<User> findAllUser();

}
