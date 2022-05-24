package com.jong960107.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jong960107.beans.UserInfo;
import com.jong960107.dao.UserDao;

@Service
public class UserService {

	
	
	@Autowired
	private UserDao userDao;
	
	@Resource(name="loginUserBean")
	private UserInfo loginUserBean;
	
		public boolean checkUserIdExist(String user_id) {
			String user_name = userDao.checkUserIdExist(user_id);
			if(user_name == null) {
				return true;
			}else {
				return false;
			}
			
		}

		public void addUserInfo(UserInfo joinUserInfo) {
			
			
			userDao.addUserInfo(joinUserInfo);	
		}
		

		public void getLoginUserInfo(UserInfo loginUserInfo) {
			UserInfo loginUserInfo2 = userDao.getLoginUserInfo(loginUserInfo);
			if(loginUserInfo2 != null) {
				loginUserBean.setUser_idx(loginUserInfo2.getUser_idx());
				loginUserBean.setUser_name(loginUserInfo2.getUser_name());
				loginUserBean.setUserLogin(true);
				
			}
		}
		
		public void getModifyUserInfo2(UserInfo modifyUserBean2) {
			UserInfo tempModifyUserBean = userDao.getModifyUserInfo2(loginUserBean.getUser_idx());

			modifyUserBean2.setUser_id(tempModifyUserBean.getUser_id());
			modifyUserBean2.setUser_name(tempModifyUserBean.getUser_name());
			modifyUserBean2.setUser_idx(loginUserBean.getUser_idx());
			
		}
		
		public void modifyUserInfo2(UserInfo modifyUserBean2) {
			modifyUserBean2.setUser_idx(loginUserBean.getUser_idx());
			
			userDao.modifyUserInfo2(modifyUserBean2);
		}
}
