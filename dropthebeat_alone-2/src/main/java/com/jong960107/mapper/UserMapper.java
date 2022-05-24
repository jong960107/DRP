package com.jong960107.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.jong960107.beans.UserInfo;

@Mapper
public interface UserMapper {

		@Select("select user_name from user_table where user_id = #{user_id}")
		public String checkUserId(String user_id);
		
		@Insert("insert into user_table (user_idx,user_name,user_id,user_pw) values (user_seq.nextval,#{user_name},#{user_id},#{user_pw})")
		void addUserInfo(UserInfo joinUserInfo);

		@Select("select user_idx, user_name from user_table where user_id=#{user_id} and user_pw = #{user_pw}")
		UserInfo getLoginUserInfo(UserInfo loginUserInfo);
		
		@Select("select user_id,user_name from user_table where user_idx = #{user_idx}")
		UserInfo getModifyUserInfo2(int user_idx);
		
		@Update("update user_table set user_pw = #{user_pw} where user_idx = #{user_idx}")
		void modifyUserInfo2(UserInfo modifyUserInfo2);
		
}
