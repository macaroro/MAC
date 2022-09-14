package com.mac.demo.service;

import java.awt.print.Pageable;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.authenticator.SavedRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.convert.SimplePropertyValueConversions;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mac.demo.mappers.AttachMapper;
import com.mac.demo.mappers.BoardMapper;
import com.mac.demo.mappers.UserMapper;
import com.mac.demo.model.Attach;
import com.mac.demo.model.Board;
import com.mac.demo.model.Comment;
import com.mac.demo.model.User;

@Service
public class BoardService {

	@Autowired
	private BoardMapper boardDao;
	
	@Autowired
	private UserMapper userDao;
	
	@Autowired
	private AttachMapper attachDao;
	
	@Autowired
	ResourceLoader resourceLoader;
	
//	------------------List-------------------
	public List<Board> getFreeList(){
		return boardDao.getFreeList();
	}
	
	public List<Board> getNoticeList() {
		return boardDao.getNoticeList();
	}
	
	public List<Board> getAdsList() {
		return boardDao.getAdsList();
	}

//	------------------id로 유저정보 가져오기-------------------    
	public User getOne(String idMac) {
		return userDao.getOne(idMac);
	}
	
//	------------------ SAVE -------------------    
	public boolean saveToFree(Board board){
		return 0 < boardDao.saveToFree(board);
	}
	public boolean saveToAds(Board board){
		return 0 < boardDao.saveToAds(board);
	}
	
//	------------------상세보기-------------------    
	public Board getFreeDetail(int num) {
		return boardDao.getFreeDetail(num);
	}
	public Board getAdsDetail(int num) {
		return boardDao.getAdsDetail(num);
	}
	public Board getNoticeDetail(int num) {
		return boardDao.getNoticeDetail(num);
	}
	
//	------------------DELETE-------------------    
	public boolean Freedelete(int num) {
		return 0 > boardDao.Freedelete(num);
	}
	public boolean Adsdelete(int num) {
		return 0 > boardDao.Adsdelete(num);
	}
	public boolean Noticedelete(int num) {
		return 0 > boardDao.Noticedelete(num);
	}
	public boolean Freeedit(Board board) {
		return 0 < boardDao.Freeedit(board);
	}
	public boolean Adsedit(Board board) {
		return 0 < boardDao.Adsedit(board);
	}
	public boolean Noticeedit(Board board) {
		return 0 < boardDao.Noticeedit(board);
		
	}
	public boolean freeCommentAllDelete(int num) {
		return 0<boardDao.freeCommentAllDelete(num);
		
	}
	public boolean adsCommentAllDelete(int num) {
		return 0<boardDao.adsCommentAllDelete(num);
	}
	
	
//	-----------------------댓글-----------------------
	public List<Comment> getCommentList(int num){
		return boardDao.getCommentList(num);		
	}
	
	public boolean commentsave(Comment comment) {
		return 0 < boardDao.commentsave(comment);	
	}
	
	public boolean commentdelete(int numMac) {
		return 0 < boardDao.commentdelete(numMac);
	}

//	-----------------------SEARCH-----------------------	
	public List<Board> getFreeListByKeyword(String titleMac){
		return boardDao.getFreeListByKeyword(titleMac);
	}

	public List<Board> getFreeListByNickName(String nickNameMac) {
		return boardDao.getFreeListByNickName(nickNameMac);
	}
	
	public List<Board> getAdsListByKeyword(String titleMac){
		return boardDao.getAdsListByKeyword(titleMac);
	}

	public List<Board> getAdsListByNickName(String nickNameMac) {
		return boardDao.getAdsListByNickName(nickNameMac);
	}
	
	public List<Board> getNoticeListByKeyword(String titleMac) {
		
		return boardDao.getNoticeListByKeyword(titleMac);
	}

	public List<Board> getNoticeListByNickName(String nickNameMac) {
		return boardDao.getNoticeListByNickName(nickNameMac);
	}
	
//	------------------------File------------------------
	public boolean insert(List<Attach> attList) {
		System.out.println("BoardService : " + attList.get(0).getFileNameMac());
		int res = attachDao.insertMultiAttach(attList);
		System.out.println(res + "개 업로드성공");

		return res==attList.size();
	}
	
//	public boolean update(List<Attach> attList) {
//		System.out.println("BoardService : " + attList.get(0).getFileNameMac());
//		int res = attachDao.updateMultiAttach(attList);
//		System.out.println(res + "개 업로드성공(update)");
//
//		return res==attList.size();
//	}
//	
	public List<Attach> getFileList(int pcodeMac){
		return attachDao.getFileList(pcodeMac);
	}
	
	//공지사항 파일 리스트
	public List<Attach> getNotcieFileList(int pcodeMac) {
		return attachDao.getNoticeFileList(pcodeMac);
	}


	public String getFname(int num) {
		String fname = attachDao.getFname(num);
		return fname;
	}
	public String getNoticeFname(int num) {
		String fname = attachDao.getNoticeFname(num);
		return fname;
	}

	public Attach getDetailByNum(int _num) {
		List<Map<String,Object>> list = attachDao.getDetailByNum(_num);
		
//		Fileupload vo = new Fileupload();
		for(int i=0; i<list.size(); i++) {
			Map<String, Object> map = list.get(i);
			
			int num = ((BigDecimal)map.get("NUM")).intValue();
			String writer = (String)map.get("WRITER");
			Date udate = new Date(((Timestamp)map.get("UDATE")).getTime());
			String comments = (String)map.get("COMMENTS");
			
			String fname = (String)map.get("FNAME");
			
			if(fname != null) {
				Attach attvo = new Attach();
				int fnum = ((BigDecimal)map.get("FNUM")).intValue();
			}
		}
		return null;
	}
	

	public boolean filedelete(int num) {
		int removed = attachDao.filedelete(num);
		return removed > 0;
	}

	@Transactional(rollbackFor = {Exception.class})
	public boolean delete3(HttpServletRequest request, int num) throws Exception {
		boolean attDeleted = attachDao.deleteAttInfo(num)>0;
		if(!attDeleted) throw new Exception("attach_tb rows delete fail");
		
		boolean uploadDeleted = attachDao.deleteUpload(num)>0;
		if(!uploadDeleted) throw new Exception("upload_tb rows delete fail");
		
		//게시물 번호를 이용해서 첨부파일명 모두 가져오기
		List<String> fnameList = attachDao.getAttachByPnum(num);
		String dir = request.getServletContext().getRealPath("WEB-INF/files/");
		int delCnt = 0;
		
			if(!(fnameList==null) || fnameList.size()==0) {
				for(int i=0; i<fnameList.size(); i++) {
					String path = dir + fnameList.get(i);
					File f = new File(path);
					if(!f.exists()) {
						System.out.println("File Not Found, '" + path + "'");
						continue;
					}
					delCnt += f.delete() ? 1:0;
				}
				if(delCnt==fnameList.size()) {
					System.out.println("Successfully deleted!");
				} else {
					System.out.println("Faile to delete the files");
					throw new Exception("file delete fail");
				}
			}
		return true;
	}
	
	public boolean insertMultiAttach(Attach vo) {
		int pcodeMac = vo.getNumMac();  // 자동 증가된 업로드 번호를 받음
		
		List<Attach> attList = vo.getAttListMac();

		int totalSuccess = 0;
		for(int i=0;i<attList.size();i++)
		{
			Map<String,Object> fmap = new HashMap<>();
			fmap.put("pcodeMac", Integer.valueOf(pcodeMac));
			fmap.put("fileNameMac", attList.get(i).getFileNameMac());
			fmap.put("filepathMac", vo.getFilepathMac());
//			totalSuccess += attchDao.insertAttach(fmap);   // 첨부파일 정보 저장
		}
		return totalSuccess==attList.size();
	}
	
	public ResponseEntity<Resource> download (HttpServletRequest request, int FileNum) throws Exception{
		String filename = getFname(FileNum);
		String originFilename = URLDecoder.decode(filename, "UTF-8");
		Resource resource = resourceLoader.getResource("WEB-INF/files/" + originFilename);
		System.out.println("파일명:" + resource.getFilename());
		String contentType = null;
		try {
			contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
//			System.out.println(contentType); // return : image/jpeg
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (contentType == null) {
			contentType = "application/octet-stream";
		}
		
		ResponseEntity<Resource> file =  ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
				// HttpHeaders.CONTENT_DISPOSITION는 http header를 조작하는 것, 화면에 띄우지 않고 첨부화면으로
				// 넘어가게끔한다
				// filename=\"" + resource.getFilename() + "\"" 는 http프로토콜의 문자열을 고대로 쓴 것
				.body(resource);
		
		return file;
	}
	
	//공지사항 다운로드
	public ResponseEntity<Resource> noticeDownload(HttpServletRequest request, int fileNum) throws Exception {
		String filename = getNoticeFname(fileNum);
		String originFilename = URLDecoder.decode(filename, "UTF-8");
		Resource resource = resourceLoader.getResource("WEB-INF/files/" + originFilename);
		System.out.println("파일명:" + resource.getFilename());
		String contentType = null;
		try {
			contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
//			System.out.println(contentType); // return : image/jpeg
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (contentType == null) {
			contentType = "application/octet-stream";
		}
		
		ResponseEntity<Resource> file =  ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
				// HttpHeaders.CONTENT_DISPOSITION는 http header를 조작하는 것, 화면에 띄우지 않고 첨부화면으로
				// 넘어가게끔한다
				// filename=\"" + resource.getFilename() + "\"" 는 http프로토콜의 문자열을 고대로 쓴 것
				.body(resource);
		
		return file;
	}
	

	
//	------------------------PAGE------------------------
	public int[] getLinkRange(Page<Board> pageInfo) {
		int start = 0;
		int end = 0;
		
		if (pageInfo.getNumber() - 2 < 0) {
			start = 0;
		} else {
			start = pageInfo.getNumber() - 2;
		}
		
		if (pageInfo.getTotalPages() < (start + 4)) {
			end = pageInfo.getTotalPages();
			start = (end - 4) < 0 ? 0 : (end - 4);
		} else {
			end = start + 4;
		}
		return new int[] { start, end };
	}



	
	

	


}
