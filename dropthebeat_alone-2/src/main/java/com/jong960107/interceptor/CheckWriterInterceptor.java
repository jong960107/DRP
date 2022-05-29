package com.jong960107.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import com.jong960107.beans.ContentInfo;
import com.jong960107.beans.UserInfo;
import com.jong960107.service.BoardService;

public class CheckWriterInterceptor implements HandlerInterceptor{

	private UserInfo loginUserBean;
	private BoardService boardService;
	
	
	public CheckWriterInterceptor(UserInfo loginUserBean, BoardService boardService) {
		this.loginUserBean = loginUserBean;
		this.boardService = boardService;
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		String str1 = request.getParameter("content_idx");
		int content_idx = Integer.parseInt(str1);
		
		ContentInfo currentContentBean = boardService.getContentInfo(content_idx);
		
		if(currentContentBean.getContent_writer_idx() != loginUserBean.getUser_idx()) {
			String contentPath = request.getContextPath();
			response.sendRedirect(contentPath+"/board/notWriter");
			return false;
		}
		
		return true;
	}
	
}
