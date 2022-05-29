package com.jong960107.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.session.RowBounds;

import com.jong960107.beans.BoardInfo;
import com.jong960107.beans.ContentInfo;
import com.jong960107.beans.UserInfo;

@Mapper
public interface BoardMapper {

	@SelectKey(statement = "select content_seq.nextval from dual", keyProperty = "content_idx",before = true, resultType = int.class)

	@Insert("insert into content_table(content_idx, content_subject, content_text,  " +
			"content_file, content_writer_idx, content_board_idx, content_date) " +
			"values (#{content_idx}, #{content_subject}, #{content_text},#{content_file, jdbcType=VARCHAR}, " +
			"#{content_writer_idx}, #{content_board_idx}, sysdate)")
	void addContentInfo(ContentInfo writeContentBean);
	
	@Update("update content_table set content_subject = #{content_subject},"
			+ " content_text = #{content_text}, content_file = #{content_file,jdbcType=VARCHAR} "
			+ "	where content_idx = #{content_idx}")
		void modifyContentInfo(ContentInfo readContentBean);
	
	
	
	@Select("select a1.content_idx, a1.content_subject,a2.user_name as content_writer_name,\n"
			+ "        to_char(a1.content_date,'YYYY-MM-DD') as content_date\n"
			+ "from content_table a1,user_table a2\n"
			+ "where a1.content_writer_idx = a2.user_idx\n"
			+ "    and a1.content_board_idx = #{board_info_idx}\n"
			+ "        order by a1.content_idx desc")
	List<ContentInfo>getContentList(int board_info_idx,RowBounds rowBounds);
	
	@Select("select a2.user_name as content_writer_name,\n"
			+ "        to_char(a1.content_date,'YYYY-MM-DD') as content_date,\n"
			+ "        a1.content_subject,a1.content_text,a1.content_file,a1.content_writer_idx\n"
			+ "from content_table a1,user_table a2\n"
			+ "where a1.content_writer_idx = a2.user_idx\n"
			+ "    and content_idx = #{content_idx}")
	ContentInfo getContentInfo(int content_idx);
	
	@Select("select count(*) from content_table where content_board_idx = #{content_board_idx}")
	int getContentCnt(int content_board_idx);
	
	
	
	
	@Delete("delete from content_table where content_idx = #{content_idx}")
	void deleteContent(int content_idx);
	
	@Select("select BOARD_INFO_IDX from BOARD_INFO_TABLE where BOARD_INFO_NAME = '자유게시판' ")
	 int getBoardInfoIdx1();
	
	@Select("select BOARD_INFO_IDX from BOARD_INFO_TABLE where BOARD_INFO_NAME = '유머게시판' ")
	 int getBoardInfoIdx2();
	
	@Select("select BOARD_INFO_IDX from BOARD_INFO_TABLE where BOARD_INFO_NAME = '정치게시판' ")
	 int getBoardInfoIdx3();
	
	@Select("select BOARD_INFO_IDX from BOARD_INFO_TABLE where BOARD_INFO_NAME = '스포츠게시판' ")
	 int getBoardInfoIdx4();
	
}
