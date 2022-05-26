package com.jong960107.controller;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.apache.catalina.connector.Request;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jong960107.beans.BoardInfo;
import com.jong960107.beans.ContentInfo;
import com.jong960107.beans.UserInfo;
import com.jong960107.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Resource(name ="loginUserBean")
	private UserInfo loginUserBean;
	
	
	@Resource(name ="boardInfoBean")
	private BoardInfo boardInfoBean;
	
	@Resource(name="boardService")
	private BoardService boardService;
	
	@GetMapping("/writeFree")
	public String write(@ModelAttribute("writeContentBean") ContentInfo writeContentBean,@RequestParam("boardInfoBeanIdx1") int boardInfoBeanIdx1,Model model) {
		boardInfoBean.setBOARD_INFO_IDX(boardService.getBoardInfoIdx1());
		model.addAttribute("boardInfoBeanIdx1", boardService.getBoardInfoIdx1());
		return "board/writeFree";
	}
	
	@PostMapping("/writeFreePro")
	public String writePro(@Valid @ModelAttribute("writeContentBean") ContentInfo writeContentBean, BindingResult result) {
		
		if(result.hasErrors()) {
			return "board/writeFree";
		}
		 return "board/writeSuccess";
	}
	

	@GetMapping("/writeFun")
	public String writeFun(@ModelAttribute("writeContentBean") ContentInfo writeContentBean,@RequestParam("boardInfoBeanIdx2") int boardInfoBeanIdx2,Model model) {
		boardInfoBean.setBOARD_INFO_IDX(boardService.getBoardInfoIdx2());
		model.addAttribute("boardInfoBeanIdx1", boardService.getBoardInfoIdx2());
		return "board/writeFun";
	}
	
	@PostMapping("/writeFunPro")
	public String writeFunPro(@Valid @ModelAttribute("writeContentBean") ContentInfo writeContentBean, BindingResult result) {
		
		if(result.hasErrors()) {
			return "board/writeFun";
		}
		 return "board/writeSuccess";
	}
	
	@GetMapping("/writePolitics")
	public String writePolitics(@ModelAttribute("writeContentBean") ContentInfo writeContentBean,@RequestParam("boardInfoBeanIdx3") int boardInfoBeanIdx3,Model model) {
		boardInfoBean.setBOARD_INFO_IDX(boardService.getBoardInfoIdx3());
		model.addAttribute("boardInfoBeanIdx1", boardService.getBoardInfoIdx3());
		return "board/writePolitics";
	}
	
	@PostMapping("/writePoliticsPro")
	public String writePoliticsPro(@Valid @ModelAttribute("writeContentBean") ContentInfo writeContentBean, BindingResult result) {
		
		if(result.hasErrors()) {
			return "board/writePolitics";
		}
		 return "board/writeSuccess";
	}
	
	@GetMapping("/writeSport")
	public String writeSport(@ModelAttribute("writeContentBean") ContentInfo writeContentBean,@RequestParam("boardInfoBeanIdx4") int boardInfoBeanIdx4,Model model) {
		boardInfoBean.setBOARD_INFO_IDX(boardService.getBoardInfoIdx4());
		model.addAttribute("boardInfoBeanIdx1", boardService.getBoardInfoIdx4());
		return "board/writeSport";
	}
	
	@PostMapping("/writeSportPro")
	public String writeSportPro(@Valid @ModelAttribute("writeContentBean") ContentInfo writeContentBean, BindingResult result) {
		
		if(result.hasErrors()) {
			return "board/writeSport";
		}
		 return "board/writeSuccess";
	}
	
	
//	-------------------------------------------
	
	@GetMapping("/record")
	public String record() {
		return "board/record";
	}
	
	@GetMapping("/free")
	public String free(@RequestParam("boardInfoBeanIdx1")int boardInfoBeanIdx1,Model model) {
		boardInfoBean.setBOARD_INFO_IDX(boardService.getBoardInfoIdx1());
		model.addAttribute("boardInfoBeanIdx1", boardService.getBoardInfoIdx1());
		return "board/free";
	}
	
	@GetMapping("/fun")
	public String fun(@RequestParam("boardInfoBeanIdx2")int boardInfoBeanIdx2,Model model) {
		boardInfoBean.setBOARD_INFO_IDX(boardService.getBoardInfoIdx2());
		model.addAttribute("boardInfoBeanIdx2", boardService.getBoardInfoIdx2());
		return "board/fun";
	}
	
	@GetMapping("/politics")
	public String politics(@RequestParam("boardInfoBeanIdx3")int boardInfoBeanIdx3,Model model) {
		boardInfoBean.setBOARD_INFO_IDX(boardService.getBoardInfoIdx3());
		model.addAttribute("boardInfoBeanIdx3", boardService.getBoardInfoIdx3());
		return "board/politics";
	}
	
	@GetMapping("/sport")
	public String sport(@RequestParam("boardInfoBeanIdx4")int boardInfoBeanIdx4,Model model) {
		boardInfoBean.setBOARD_INFO_IDX(boardService.getBoardInfoIdx4());
		model.addAttribute("boardInfoBeanIdx4", boardService.getBoardInfoIdx4());
		return "board/sport";
	}
	
	
	
	
}
