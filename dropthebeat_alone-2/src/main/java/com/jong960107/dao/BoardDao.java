package com.jong960107.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jong960107.beans.BoardInfo;
import com.jong960107.beans.ContentInfo;
import com.jong960107.mapper.BoardMapper;

@Repository
public class BoardDao {

	@Resource(name = "boardInfoBean")
	BoardInfo boardInfo;
	
	@Autowired
	private BoardMapper boardMapper;
	
	public void addContentInfo(ContentInfo writeContentBean) {
		

		boardMapper.addContentInfo(writeContentBean);
		
	}
	
	public List<ContentInfo>getContentList(int board_info_idx,RowBounds rowBounds){
		return boardMapper.getContentList(board_info_idx,rowBounds);
	}
	
	public ContentInfo getContentInfo(int content_idx) {
		return boardMapper.getContentInfo(content_idx);
	}

	public void modifyContentInfo(ContentInfo modifyContentBean) {
		boardMapper.modifyContentInfo(modifyContentBean);
	}

	public void deleteContentInfo(int content_idx) {
		boardMapper.deleteContent(content_idx);
	}
	
	public int getContentCnt(int content_board_idx) {
		return boardMapper.getContentCnt(content_board_idx);
	}
	
	
	public int getBoardInfoIdx1() {
		return boardMapper.getBoardInfoIdx1();
	}
	
	public int getBoardInfoIdx2() {
		return boardMapper.getBoardInfoIdx2();
	}
	
	public int getBoardInfoIdx3() {
		return boardMapper.getBoardInfoIdx3();
	}
	
	public int getBoardInfoIdx4() {
		return boardMapper.getBoardInfoIdx4();
	}
	
}
