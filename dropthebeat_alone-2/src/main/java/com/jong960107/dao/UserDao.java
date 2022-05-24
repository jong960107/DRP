package com.jong960107.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jong960107.beans.UserInfo;
import com.jong960107.mapper.UserMapper;

@Repository
public class UserDao {

	@Autowired
	private UserMapper userMapper;
	
	public String checkUserIdExist(String user_id) {
		return userMapper.checkUserId(user_id);
	};
	
	public void addUserInfo(UserInfo joinUserInfo) {
		userMapper.addUserInfo(joinUserInfo);
	};
	
	public UserInfo getLoginUserInfo(UserInfo LoginUserInfo) {
		return userMapper.getLoginUserInfo(LoginUserInfo);
	}
	
	public UserInfo getModifyUserInfo2(int user_idx) {
		return userMapper.getModifyUserInfo2(user_idx);
	}
	
	public void modifyUserInfo2(UserInfo modifyUserInfo2) {
		userMapper.modifyUserInfo2(modifyUserInfo2);
	}
	
}
