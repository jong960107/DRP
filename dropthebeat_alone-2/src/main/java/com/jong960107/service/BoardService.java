package com.jong960107.service;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jong960107.beans.BoardInfo;
import com.jong960107.beans.ContentInfo;
import com.jong960107.beans.PageInfo;
import com.jong960107.beans.UserInfo;
import com.jong960107.dao.BoardDao;

@Service
@PropertySource("option.properties")
public class BoardService {

	@Value("${path.upload}")
	private String path_upload;
	
	@Value("${page.listcnt}")
	private int page_listcnt;
	
	@Value("${page.paginationcnt}")
	private int page_paginationcnt;
	
	
	@Autowired
	private BoardDao boardDao;
	
	@Resource(name="loginUserBean")
	private UserInfo loginUserBean;
	
	public List<ContentInfo>getContentList(int board_info_idx, int page){

		int start = (page-1) * page_listcnt;
		RowBounds rowBounds = new RowBounds(start,page_listcnt);

		
		return boardDao.getContentList(board_info_idx,rowBounds);
		
	}

	public ContentInfo getContentInfo(int content_idx) {
		return boardDao.getContentInfo(content_idx);
	}

	public void modifyContentInfo(ContentInfo modifyContentBean) {
		MultipartFile upload_file = modifyContentBean.getUpload_file();
		if(upload_file.getSize()>0) {
			String file_name = saveUploadFile(upload_file);
			modifyContentBean.setContent_file(file_name);
		}
		boardDao.modifyContentInfo(modifyContentBean);
		
	}
	
	public void deleteContentInfo(int content_idx) {
		boardDao.deleteContentInfo(content_idx);
	}
	
	public PageInfo getContentCnt(int content_board_idx,int currentPage) {
		int content_cnt = boardDao.getContentCnt(content_board_idx);
		PageInfo pageBean = new PageInfo(content_cnt, currentPage, page_listcnt, page_paginationcnt);
		return pageBean;
	}
	
	
	private String saveUploadFile(MultipartFile upload_file) {
		String file_name = System.currentTimeMillis()+"_"+upload_file.getOriginalFilename();
		
		try {
			upload_file.transferTo(new File(path_upload+"/"+file_name));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return file_name;
	}
	
	@Resource(name = "boardInfoBean")
	BoardInfo boardInfoBean;
	

	
	
	public void addContentInfo(ContentInfo writeContentBean) {
		
		MultipartFile upload_file = writeContentBean.getUpload_file();
		
		if(upload_file.getSize()>0) {
			String file_name = saveUploadFile(upload_file);
			writeContentBean.setContent_file(file_name);
		}
		
		writeContentBean.setContent_writer_idx(loginUserBean.getUser_idx());
		
		boardDao.addContentInfo(writeContentBean);
	}


	
	public int getBoardInfoIdx1() {
		return boardDao.getBoardInfoIdx1();
	}
	
	public int getBoardInfoIdx2() {
		return boardDao.getBoardInfoIdx2();
	}
	
	public int getBoardInfoIdx3() {
		return boardDao.getBoardInfoIdx3();
	}
	
	public int getBoardInfoIdx4() {
		return boardDao.getBoardInfoIdx4();
	}
	
}
