package com.mac.demo.model;


import org.springframework.stereotype.Component;

import lombok.*;


@Component
public class Board {

	private int numMac; //번호
	private String nickNameMac; //닉네임
	private String titleMac; //제목
	private String contentsMac; //내용
	private java.sql.Date wdateMac; //작성일
	private String typeMac; //속성(업종등)
	private String idMac; //유저아이디
	private int countMac;
	private String tableMac;
	private String categoryMac;
	public int getNumMac() {
		return numMac;
	}
	public void setNumMac(int numMac) {
		this.numMac = numMac;
	}
	public String getNickNameMac() {
		return nickNameMac;
	}
	public void setNickNameMac(String nickNameMac) {
		this.nickNameMac = nickNameMac;
	}
	public String getTitleMac() {
		return titleMac;
	}
	public void setTitleMac(String titleMac) {
		this.titleMac = titleMac;
	}
	public String getContentsMac() {
		return contentsMac;
	}
	public void setContentsMac(String contentsMac) {
		this.contentsMac = contentsMac;
	}
	public java.sql.Date getWdateMac() {
		return wdateMac;
	}
	public void setWdateMac(java.sql.Date wdateMac) {
		this.wdateMac = wdateMac;
	}
	public String getTypeMac() {
		return typeMac;
	}
	public void setTypeMac(String typeMac) {
		this.typeMac = typeMac;
	}
	public String getIdMac() {
		return idMac;
	}
	public void setIdMac(String idMac) {
		this.idMac = idMac;
	}
	public int getCountMac() {
		return countMac;
	}
	public void setCountMac(int countMac) {
		this.countMac = countMac;
	}
	public String getTableMac() {
		return tableMac;
	}
	public void setTableMac(String tableMac) {
		this.tableMac = tableMac;
	}
	public String getCategoryMac() {
		return categoryMac;
	}
	public void setCategoryMac(String categoryMac) {
		this.categoryMac = categoryMac;
	}

	
	
}