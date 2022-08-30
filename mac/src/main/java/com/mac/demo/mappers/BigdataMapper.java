package com.mac.demo.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mac.demo.model.XY;

@Mapper
public interface BigdataMapper {

	List<String> getgu(String kind);
	
	List<String> getdong(String gu, String kind);

	List<String> getgil(String dong, String kind);

	XY getxy(String gil);

	

}