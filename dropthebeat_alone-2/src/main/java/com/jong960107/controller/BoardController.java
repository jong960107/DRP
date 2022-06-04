package com.jong960107.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.apache.catalina.connector.Request;
import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.accept.ContentNegotiationManagerFactoryBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jong960107.beans.BoardInfo;
import com.jong960107.beans.ContentInfo;
import com.jong960107.beans.PageInfo;
import com.jong960107.beans.UserInfo;
import com.jong960107.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Resource(name ="loginUserBean")
	private UserInfo loginUserBean;
	
	
	@Resource(name ="boardInfoBean")
	private BoardInfo boardInfoBean;
	
	@Autowired
	private BoardService boardService;

//	---------------------------------------------------------------------
	@GetMapping("/modifyFree")
	public String modifyFree(@RequestParam("boardInfoBeanIdx1") int boardInfoBeanIdx1,
									@RequestParam("content_idx") int content_idx,
									@ModelAttribute("readContentBean") ContentInfo readContentBean,
									Model model) {
		model.addAttribute("boardInfoBeanIdx1",boardInfoBeanIdx1);
		model.addAttribute("content_idx",content_idx);
		 ContentInfo tempContentBean = boardService.getContentInfo(content_idx);

		readContentBean.setContent_writer_name(tempContentBean.getContent_writer_name());
		readContentBean.setContent_date(tempContentBean.getContent_date());
		readContentBean.setContent_subject(tempContentBean.getContent_subject());
		readContentBean.setContent_text(tempContentBean.getContent_text());
		readContentBean.setContent_file(tempContentBean.getContent_file());
		readContentBean.setContent_writer_idx(tempContentBean.getContent_writer_idx());
		readContentBean.setContent_board_idx(boardInfoBeanIdx1);
		readContentBean.setContent_idx(content_idx);
		
		return "board/modifyFree";
	}
	
	@GetMapping("/modifyFun")
	public String modifyFun(@RequestParam("boardInfoBeanIdx2") int boardInfoBeanIdx2,
									@RequestParam("content_idx") int content_idx,
									@ModelAttribute("readContentBean") ContentInfo readContentBean,
									Model model) {
		model.addAttribute("boardInfoBeanIdx2",boardInfoBeanIdx2);
		model.addAttribute("content_idx",content_idx);
		 ContentInfo tempContentBean = boardService.getContentInfo(content_idx);

		readContentBean.setContent_writer_name(tempContentBean.getContent_writer_name());
		readContentBean.setContent_date(tempContentBean.getContent_date());
		readContentBean.setContent_subject(tempContentBean.getContent_subject());
		readContentBean.setContent_text(tempContentBean.getContent_text());
		readContentBean.setContent_file(tempContentBean.getContent_file());
		readContentBean.setContent_writer_idx(tempContentBean.getContent_writer_idx());
		readContentBean.setContent_board_idx(boardInfoBeanIdx2);
		readContentBean.setContent_idx(content_idx);
		
		return "board/modifyFun";
	}
	
	@GetMapping("/modifyPolitics")
	public String modifyPolitics(@RequestParam("boardInfoBeanIdx3") int boardInfoBeanIdx3,
									@RequestParam("content_idx") int content_idx,
									@ModelAttribute("readContentBean") ContentInfo readContentBean,
									Model model) {
		model.addAttribute("boardInfoBeanIdx1",boardInfoBeanIdx3);
		model.addAttribute("content_idx",content_idx);
		 ContentInfo tempContentBean = boardService.getContentInfo(content_idx);

		readContentBean.setContent_writer_name(tempContentBean.getContent_writer_name());
		readContentBean.setContent_date(tempContentBean.getContent_date());
		readContentBean.setContent_subject(tempContentBean.getContent_subject());
		readContentBean.setContent_text(tempContentBean.getContent_text());
		readContentBean.setContent_file(tempContentBean.getContent_file());
		readContentBean.setContent_writer_idx(tempContentBean.getContent_writer_idx());
		readContentBean.setContent_board_idx(boardInfoBeanIdx3);
		readContentBean.setContent_idx(content_idx);
		
		return "board/modifyPolitics";
	}
	
	@GetMapping("/modifySport")
	public String modifySport(@RequestParam("boardInfoBeanIdx4") int boardInfoBeanIdx4,
									@RequestParam("content_idx") int content_idx,
									@ModelAttribute("readContentBean") ContentInfo readContentBean,
									Model model) {
		model.addAttribute("boardInfoBeanIdx1",boardInfoBeanIdx4);
		model.addAttribute("content_idx",content_idx);
		 ContentInfo tempContentBean = boardService.getContentInfo(content_idx);

		readContentBean.setContent_writer_name(tempContentBean.getContent_writer_name());
		readContentBean.setContent_date(tempContentBean.getContent_date());
		readContentBean.setContent_subject(tempContentBean.getContent_subject());
		readContentBean.setContent_text(tempContentBean.getContent_text());
		readContentBean.setContent_file(tempContentBean.getContent_file());
		readContentBean.setContent_writer_idx(tempContentBean.getContent_writer_idx());
		readContentBean.setContent_board_idx(boardInfoBeanIdx4);
		readContentBean.setContent_idx(content_idx);
		
		return "board/modifySport";
	}
	
	
	@PostMapping("/modifyPro")
	public String modifyPro(@Valid @ModelAttribute("readContentBean") ContentInfo readContentBean,
			Model model, BindingResult result) {
			if(result.hasErrors()) {
				return "board/modifyFree";
			}
			model.addAttribute("readContentBean",readContentBean);
			boardService.modifyContentInfo(readContentBean);
			return "board/modifyFreeSuccess";
		}
	
	
	
//	---------------------------------------------------------------------
	@GetMapping("/readFree")
	public String readFree(@RequestParam("boardInfoBeanIdx1") int boardInfoBeanIdx1,
									@RequestParam("content_idx") int content_idx,
									@RequestParam(value="page" ,defaultValue="1") int page,
									Model model) {
		String fileReadName = boardService.getFileReadName();
		model.addAttribute("fileReadName",fileReadName);
		ContentInfo readContentBean = boardService.getContentInfo(content_idx);
		model.addAttribute("readContentBean",readContentBean);
		model.addAttribute("content_idx",content_idx);
		model.addAttribute("boardInfoBeanIdx1",boardInfoBeanIdx1);
		List <ContentInfo> contentList = new ArrayList<ContentInfo>();
		contentList = boardService.getContentList(boardInfoBeanIdx1,page);
		model.addAttribute("contentList",contentList);
		for(ContentInfo obj : contentList) {
		
		int contentIdx = obj.getContent_idx();	
		String contentWriterName = obj.getContent_writer_name();
		String contentDate = obj.getContent_date();
		String contentSubject = obj.getContent_subject();
		String contentText = obj.getContent_text();
		String contentFile = obj.getContent_file();
		
		model.addAttribute("contentIdx",contentIdx);
		model.addAttribute("contentWriterName",contentWriterName);
		model.addAttribute("contentDate",contentDate);
		model.addAttribute("contentSubject",contentSubject);
		model.addAttribute("contentText",contentText);
		model.addAttribute("contentFile",contentFile);
		model.addAttribute("obj",obj);
		}
		
		model.addAttribute("loginUserBean",loginUserBean);
		
		return "board/readFree";
	}


	@GetMapping("/readFun")
	public String readFun(@RequestParam("boardInfoBeanIdx2") int boardInfoBeanIdx2,
									@RequestParam("content_idx") int content_idx,
									@RequestParam(value="page" ,defaultValue="1") int page,
									Model model) {
		model.addAttribute("boardInfoBeanIdx2",boardInfoBeanIdx2);
		ContentInfo readContentBean = new ContentInfo();
		readContentBean = boardService.getContentInfo(content_idx);
		model.addAttribute("readContentBean",readContentBean);
		List <ContentInfo> contentList = boardService.getContentList(boardInfoBeanIdx2,page);
		model.addAttribute("contentList",contentList);
		
		return "board/readFun";
	}
	
	@GetMapping("/readPolitics")
	public String readPolitics(@RequestParam("boardInfoBeanIdx3") int boardInfoBeanIdx3,
									@RequestParam("content_idx") int content_idx,
									@RequestParam(value="page" ,defaultValue="1") int page,
									Model model) {
		model.addAttribute("boardInfoBeanIdx3",boardInfoBeanIdx3);
		ContentInfo readContentBean = new ContentInfo();
		readContentBean = boardService.getContentInfo(content_idx);
		model.addAttribute("readContentBean",readContentBean);
		List <ContentInfo> contentList = boardService.getContentList(boardInfoBeanIdx3,page);
		
		model.addAttribute("contentList",contentList);
		
		return "board/readPolitics";
	}
	
	
	@GetMapping("/readSport")
	public String readSport(@RequestParam("boardInfoBeanIdx4") int boardInfoBeanIdx4,
									@RequestParam("content_idx") int content_idx,
									@RequestParam(value="page" ,defaultValue="1") int page,
									Model model) {
		model.addAttribute("boardInfoBeanIdx4",boardInfoBeanIdx4);
		ContentInfo readContentBean = new ContentInfo();
		readContentBean = boardService.getContentInfo(content_idx);
		model.addAttribute("readContentBean",readContentBean);
		List <ContentInfo> contentList = boardService.getContentList(boardInfoBeanIdx4,page);
		model.addAttribute("contentList",contentList);
		
		return "board/readSport";
	}
	
	
//	---------------------------------------------------------------------
	
	@GetMapping("/writeFree")
	public String write(@RequestParam("boardInfoBeanIdx1") int boardInfoBeanIdx1,
			@ModelAttribute("writeContentBean") ContentInfo writeContentBean,
			Model model) {
		boardInfoBean.setBOARD_INFO_IDX(boardService.getBoardInfoIdx1());
		model.addAttribute("boardInfoBeanIdx1", boardService.getBoardInfoIdx1());
		writeContentBean.setContent_board_idx(boardInfoBeanIdx1);
	
		return "board/writeFree";
	}
	
	@PostMapping("/writeFreeSuccess")
	public String writePro(@Valid @ModelAttribute("writeContentBean") ContentInfo writeContentBean, BindingResult result) {
		
		if(result.hasErrors()) {
			return "board/writeFree";
		}
		
		boardService.addContentInfo(writeContentBean);
		 return "board/writeFreeSuccess";
	}
	

	@GetMapping("/writeFun")
	public String writeFun(@ModelAttribute("writeContentBean") ContentInfo writeContentBean,
			@RequestParam(value="page" ,defaultValue="1") int page,
			@RequestParam("boardInfoBeanIdx2") int boardInfoBeanIdx2,Model model) {
		boardInfoBean.setBOARD_INFO_IDX(boardService.getBoardInfoIdx2());
		writeContentBean.setContent_board_idx(boardInfoBeanIdx2);
		model.addAttribute("boardInfoBeanIdx1", boardService.getBoardInfoIdx2());
		List <ContentInfo> contentList = boardService.getContentList(boardInfoBeanIdx2,page);
		model.addAttribute("contentList",contentList);
		return "board/writeFun";
	}
	
	@PostMapping("/writeFunSuccess")
	public String writeFunPro(@Valid @ModelAttribute("writeContentBean") ContentInfo writeContentBean, BindingResult result) {
		
		if(result.hasErrors()) {
			return "board/writeFun";
		}
		
		boardService.addContentInfo(writeContentBean);

		 return "board/writeFunSuccess";
	}
	
	@GetMapping("/writePolitics")
	public String writePolitics(@ModelAttribute("writeContentBean") ContentInfo writeContentBean,
			@RequestParam(value="page" ,defaultValue="1") int page
			,@RequestParam("boardInfoBeanIdx3") int boardInfoBeanIdx3,Model model) {
		boardInfoBean.setBOARD_INFO_IDX(boardService.getBoardInfoIdx3());
		writeContentBean.setContent_board_idx(boardInfoBeanIdx3);
		List <ContentInfo> contentList = boardService.getContentList(boardInfoBeanIdx3,page);
		model.addAttribute("contentList",contentList);
		model.addAttribute("boardInfoBeanIdx1", boardService.getBoardInfoIdx3());
		return "board/writePolitics";
	}
	
	@PostMapping("/writePoliticsSuccess")
	public String writePoliticsPro(@Valid @ModelAttribute("writeContentBean") ContentInfo writeContentBean, BindingResult result) {
		
		if(result.hasErrors()) {
			return "board/writePolitics";
		}
		
		boardService.addContentInfo(writeContentBean);

		 return "board/writePoliticsSuccess";
	}
	
	@GetMapping("/writeSport")
	public String writeSport(@ModelAttribute("writeContentBean") ContentInfo writeContentBean,
			@RequestParam(value="page" ,defaultValue="1") int page,
			@RequestParam("boardInfoBeanIdx4") int boardInfoBeanIdx4,Model model) {
		boardInfoBean.setBOARD_INFO_IDX(boardService.getBoardInfoIdx4());
		writeContentBean.setContent_board_idx(boardInfoBeanIdx4);
		List <ContentInfo> contentList = boardService.getContentList(boardInfoBeanIdx4,page);
		model.addAttribute("contentList",contentList);
		model.addAttribute("boardInfoBeanIdx1", boardService.getBoardInfoIdx4());
		return "board/writeSport";
	}
	
	@PostMapping("/writeSportSuccess")
	public String writeSportPro(@Valid @ModelAttribute("writeContentBean") ContentInfo writeContentBean, BindingResult result) {
		
		if(result.hasErrors()) {
			return "board/writeSport";
		}
		
		boardService.addContentInfo(writeContentBean);

		 return "board/writeSportSuccess";
	}
	
	@GetMapping("/notWriter")
	public String notWriter() {
		return "board/notWriter";
	}
	
	@GetMapping("/deleteFree")
	public String delete(@RequestParam("boardInfoBeanIdx1")int boardInfoBeanIdx1,
										@RequestParam("content_idx") int content_idx,Model model) {
									
		boardService.deleteContentInfo(content_idx);
		model.addAttribute("boardInfoBeanIdx1",boardInfoBeanIdx1);
		model.addAttribute("content_idx",content_idx);
		return "board/deleteFree";
	}
	
	
//	-------------------------------------------
	
	@GetMapping("/record")
	public String record() {
		return "board/record";
	}
	
	@GetMapping("/free")
	public String free(@RequestParam("boardInfoBeanIdx1")int boardInfoBeanIdx1,
									@RequestParam(value="page" ,defaultValue="1") int page,
									Model model) {
		boardInfoBean.setBOARD_INFO_IDX(boardService.getBoardInfoIdx1());
		model.addAttribute("boardInfoBeanIdx1", boardService.getBoardInfoIdx1());

		List <ContentInfo> contentList  = boardService.getContentList(boardInfoBeanIdx1,page);
		model.addAttribute("contentList",contentList);
		
		
		PageInfo pageBean  = boardService.getContentCnt(boardInfoBeanIdx1, page);
		model.addAttribute("pageBean",pageBean);
		return "board/free";
		
	}
	
	@GetMapping("/fun")
	public String fun(@RequestParam("boardInfoBeanIdx2")int boardInfoBeanIdx2,@RequestParam(value="page" ,defaultValue="1") int page,Model model) {
		boardInfoBean.setBOARD_INFO_IDX(boardService.getBoardInfoIdx2());
		model.addAttribute("boardInfoBeanIdx2", boardService.getBoardInfoIdx2());

		List <ContentInfo> contentList  = boardService.getContentList(boardInfoBeanIdx2,page);

		for(ContentInfo obj : contentList) {
		
		int contentIdx = obj.getContent_idx();	
		String contentWriterName = obj.getContent_writer_name();
		String contentDate = obj.getContent_date();
		String contentSubject = obj.getContent_subject();
		String contentText = obj.getContent_text();
		String contentFile = obj.getContent_file();
		
		model.addAttribute("contentIdx",contentIdx);
		model.addAttribute("contentWriterName",contentWriterName);
		model.addAttribute("contentDate",contentDate);
		model.addAttribute("contentSubject",contentSubject);
		model.addAttribute("contentText",contentText);
		model.addAttribute("contentFile",contentFile);
		}
		return "board/fun";
		
	}
	@GetMapping("/politics")
	public String politics(@RequestParam("boardInfoBeanIdx3")int boardInfoBeanIdx3,@RequestParam(value="page" ,defaultValue="1") int page,Model model) {
		boardInfoBean.setBOARD_INFO_IDX(boardService.getBoardInfoIdx1());
		model.addAttribute("boardInfoBeanIdx3", boardService.getBoardInfoIdx1());

		List <ContentInfo> contentList  = boardService.getContentList(boardInfoBeanIdx3,page);

		for(ContentInfo obj : contentList) {
		
		int contentIdx = obj.getContent_idx();	
		String contentWriterName = obj.getContent_writer_name();
		String contentDate = obj.getContent_date();
		String contentSubject = obj.getContent_subject();
		String contentText = obj.getContent_text();
		String contentFile = obj.getContent_file();
		
		model.addAttribute("contentIdx",contentIdx);
		model.addAttribute("contentWriterName",contentWriterName);
		model.addAttribute("contentDate",contentDate);
		model.addAttribute("contentSubject",contentSubject);
		model.addAttribute("contentText",contentText);
		model.addAttribute("contentFile",contentFile);
		}
		return "board/politics";
		
	}
	@GetMapping("/sport")
	public String sport(@RequestParam("boardInfoBeanIdx4")int boardInfoBeanIdx4,@RequestParam(value="page" ,defaultValue="1") int page,Model model) {
		boardInfoBean.setBOARD_INFO_IDX(boardService.getBoardInfoIdx4());
		model.addAttribute("boardInfoBeanIdx4", boardService.getBoardInfoIdx4());

		List <ContentInfo> contentList  = boardService.getContentList(boardInfoBeanIdx4,page);

		for(ContentInfo obj : contentList) {
		
		int contentIdx = obj.getContent_idx();	
		String contentWriterName = obj.getContent_writer_name();
		String contentDate = obj.getContent_date();
		String contentSubject = obj.getContent_subject();
		String contentText = obj.getContent_text();
		String contentFile = obj.getContent_file();
		
		model.addAttribute("contentIdx",contentIdx);
		model.addAttribute("contentWriterName",contentWriterName);
		model.addAttribute("contentDate",contentDate);
		model.addAttribute("contentSubject",contentSubject);
		model.addAttribute("contentText",contentText);
		model.addAttribute("contentFile",contentFile);
		}
		return "board/sport";
		
	}
	
	
	
	
}
