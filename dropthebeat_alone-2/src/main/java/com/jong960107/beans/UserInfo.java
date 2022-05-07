package com.jong960107.beans;

import java.io.Console;
import java.time.LocalDate;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;



public class UserInfo {
	
	LocalDate currentDate = LocalDate.now(); 
	
	
	private int user_idx;
	
	@NotNull(message = "값이 비어있으면 안됩니다..!")
	@NotBlank
	@Size(min=2,max=12)
	@Pattern(regexp="[a-zA-Z가-힣0-9]*",message = "영소문자,대문자,한글,숫자만 가능합니다.")
	private String user_name;
	@NotBlank
	@NotNull(message = "값이 비어있으면 안됩니다..!")
	@Size(min=4,max=20)
	@Pattern(regexp="[a-zA-Z가-힣0-9]*",message = "영소문자,대문자,한글,숫자만 가능합니다.")
	private String user_id;
	@NotBlank
	@NotNull(message = "값이 비어있으면 안됩니다..!")
	@Size(min=4,max=20)
	@Pattern(regexp="[a-zA-Z0-9]*",message = "영소문자,대문자,숫자만 가능합니다.")
	private String user_pw;
	@NotBlank
	@NotNull(message = "값이 비어있으면 안됩니다..!")
	@Size(min=4,max=20)
	@Pattern(regexp="[a-zA-Z0-9]*",message = "영소문자,대문자,숫자만 가능합니다.")
	private String user_pw2;
	
	private String dateString = String.valueOf(currentDate);

	public LocalDate getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(LocalDate currentDate) {
		this.currentDate = currentDate;
	}

	public int getUser_idx() {
		return user_idx;
	}

	public void setUser_idx(int user_idx) {
		this.user_idx = user_idx;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_pw() {
		return user_pw;
	}

	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}

	public String getUser_pw2() {
		return user_pw2;
	}

	public void setUser_pw2(String user_pw2) {
		this.user_pw2 = user_pw2;
	}

	public String getDateString() {
		return dateString;
	}

	public void setDateString(String dateString) {
		this.dateString = dateString;
	}
}
	
	
	