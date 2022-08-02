package com.mac.demo.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mac.demo.model.Board;
import com.mac.demo.model.User;

@Mapper
public interface AdminMapper {

	List<User> findAllUser();

	List<Board> findAllFreeBoard();

	List<Board> findAllAdsBoard();

	boolean freeBordDeleted(String idMac);

	boolean adsBordDeleted(String idMac);

	boolean UserDeleted(String idMac);

}
