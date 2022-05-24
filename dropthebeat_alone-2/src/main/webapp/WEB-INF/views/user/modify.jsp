<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <c:set var="root" value="/"></c:set>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	
		body{
		display: flex;
		align-items: center;
		justify-content: center;
		height: 100vh;
	}
	
		
	.container{
		box-shadow: 2px 2px 2px 1px rgba(0, 0, 0, 0.2);
		width: 350px;
	}
	
		.containerBox{
		position:relative;
		left: 10px;
	}
	
	.containerBox label{
		color: gray;
		font-family: 'Playfair Display', serif;
		
	}
		.containerBox input{
		width:90%;
		height: 30px;
		border:solid 3px #ececec;
		color:black;
   	    font-family: 'CookieRunOTF-Bold';
	    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_twelve@1.0/CookieRunOTF-Bold00.woff') format('woff');
	    font-weight: normal;
	    font-style: normal;

	}
	
	.containerBox input:hover{
		width:90%;
		height: 30px;
		border:solid 3px gray;
		color:black;
		font-family: 'CookieRunOTF-Bold';
	    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_twelve@1.0/CookieRunOTF-Bold00.woff') format('woff');
	    font-weight: normal;
	    font-style: normal;
		
	}
	
		h2{
		text-align: center;
		font-family: 'Playfair Display', serif;
		
	}
	
	#loginButton{
		display:block;
		height:50px;
		margin:0 auto;
		width: 80%;
		border:solid 3px white;
		background-color: skyblue;
		color:white;
		margin-bottom: 10px;
	}
	
	#loginButton:hover{
		display:block;
		width:inherit;
		height:50px;
		margin:0 auto;
		width: 80%;
		border:solid 3px #ECECEC;
		background-color: skyblue;
		color:white;
		margin-bottom: 10px;
		
	}
	
</style>

</head>
<body>
		<div class="container">
		<form:form action="${root }user/modifyPro" method="POST" modelAttribute="modifyUserInfo2">
			<form:hidden path="userIdExist"/>
			<h2>로그인</h2>
			
			<div class="containerBox" id="containerBox0">
				<form:label path="user_name">이름</form:label><br>
				<form:input path="user_name"  readonly="true"/><br>
				<form:errors  path="user_name" style="color:red"></form:errors><br>
			</div>
			<div class="containerBox" id="containerBox1">
				<form:label path="user_id">아이디</form:label><br>
				<form:input path="user_id" readonly="true" /><br>
				<form:errors  path="user_id" style="color:red"></form:errors><br>
			</div>
			<div class="containerBox" id="containerBox2">
				<form:label path="user_pw">비밀번호</form:label><br>
				<form:password path="user_pw" /><br>
				<form:errors path="user_pw" style="color:red"></form:errors><br><br>
			</div>
			<div class="containerBox" id="containerBox3">
				<form:label path="user_pw2">비밀번호 확인</form:label><br>
				<form:password path="user_pw2" /><br>
				<form:errors path="user_pw2" style="color:red"></form:errors><br><br>
			</div>
			<form:button id="loginButton">로그인</form:button>
		</form:form>
	</div>
</body>
</html>