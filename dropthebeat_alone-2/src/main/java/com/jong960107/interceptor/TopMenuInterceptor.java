package com.jong960107.interceptor;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import com.jong960107.beans.BoardInfo;
import com.jong960107.beans.UserInfo;
import com.jong960107.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class TopMenuInterceptor implements HandlerInterceptor{
	
	@Resource(name = "loginUserBean")
	private UserInfo loginUserBean;

	@Resource(name = "boardInfoBean")
	private BoardInfo boardInfoBean;

	@Resource(name = "boardService")
	private BoardService boardService;
	
	

	
	
	
	public TopMenuInterceptor(UserInfo loginUserBean, BoardInfo boardInfoBean,BoardService boardService) {
		this.loginUserBean = loginUserBean;
		this.boardInfoBean = boardInfoBean;
		this.boardService = boardService;
	}






	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		

		
		request.setAttribute("boardInfoBeanIdx1", boardService.getBoardInfoIdx1());
		request.setAttribute("boardInfoBeanIdx2", boardService.getBoardInfoIdx2());
		request.setAttribute("boardInfoBeanIdx3", boardService.getBoardInfoIdx3());
		request.setAttribute("boardInfoBeanIdx4", boardService.getBoardInfoIdx4());

		request.setAttribute("loginUserBean", loginUserBean);
		return true;
	}
	
}
