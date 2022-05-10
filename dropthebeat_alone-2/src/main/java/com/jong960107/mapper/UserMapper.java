package com.jong960107.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

		@Select("select user_name from user_table where user_id = #{user_id}")
		public String checkUserId(String user_id);
		
	
}
