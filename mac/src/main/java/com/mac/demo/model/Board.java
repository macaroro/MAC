package com.mac.demo.model;

import java.sql.Date;
public class Board {

	private int numMac; //번호
	private String nickNameMac; //닉네임
	private String titleMac; //제목
	private String contentsMac; //내용
	private java.sql.Date wdateMac; //작성일
	private int pcodeMac; //부모글pcode
	private String typeMac; //속성(업종등)
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
	public int getPcodeMac() {
		return pcodeMac;
	}
	public void setPcodeMac(int pcodeMac) {
		this.pcodeMac = pcodeMac;
	}
	public String getTypeMac() {
		return typeMac;
	}
	public void setTypeMac(String typeMac) {
		this.typeMac = typeMac;
	}
	

}
