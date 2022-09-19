package com.mac.demo.model;

import java.util.List;
import lombok.*;

import org.springframework.stereotype.Component;


@Component
public class Attach
{
	private int numMac;  // index
	private int pcodeMac; // 부모코드(게시판 numMac)
	private String idMac; // 유저 ID
	private String nickNameMac; // 유저 닉네임
	private String fileNameMac; // 파일 이름
	private String filepathMac; // 파일 저장된 경로
	private java.sql.Date wdateMac; // 파일 저장 날짜
	private List<Attach> attListMac; // 첨부파일명 리스트
	public int getNumMac() {
		return numMac;
	}
	public void setNumMac(int numMac) {
		this.numMac = numMac;
	}
	public int getPcodeMac() {
		return pcodeMac;
	}
	public void setPcodeMac(int pcodeMac) {
		this.pcodeMac = pcodeMac;
	}
	public String getIdMac() {
		return idMac;
	}
	public void setIdMac(String idMac) {
		this.idMac = idMac;
	}
	public String getNickNameMac() {
		return nickNameMac;
	}
	public void setNickNameMac(String nickNameMac) {
		this.nickNameMac = nickNameMac;
	}
	public String getFileNameMac() {
		return fileNameMac;
	}
	public void setFileNameMac(String fileNameMac) {
		this.fileNameMac = fileNameMac;
	}
	public String getFilepathMac() {
		return filepathMac;
	}
	public void setFilepathMac(String filepathMac) {
		this.filepathMac = filepathMac;
	}
	public java.sql.Date getWdateMac() {
		return wdateMac;
	}
	public void setWdateMac(java.sql.Date wdateMac) {
		this.wdateMac = wdateMac;
	}
	public List<Attach> getAttListMac() {
		return attListMac;
	}
	public void setAttListMac(List<Attach> attListMac) {
		this.attListMac = attListMac;
	}
	
}