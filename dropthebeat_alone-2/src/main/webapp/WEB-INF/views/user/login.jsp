<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <c:set var="root" value="/"></c:set>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
<title>Insert title here</title>
<style type="text/css">
	
		body{
		display: flex;
		align-items: center;
		justify-content: center;
		height: 100vh;
	}
	
		
	.containerShadow{
		box-shadow: 2px 2px 2px 1px rgba(0, 0, 0, 0.2);
		width: 350px;
	}
	
	.containerBox{
	position:relative;
	left: 10px;
	}

	.containerBox label{
		top:10px;
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
		margin-top: 10px;
	}
	
	
	#loginButton{
		display:block;
		height:50px;
		margin:0 auto;
		width: 80%;
		margin-bottom: 10px;
		
	}
	
	#signUpButton{
		display:block;
		height:50px;
		margin:0 auto;
		width: 80%;
		margin-bottom: 10px;
		
	}
	
	
</style>

</head>
<body>


		<div class="containerShadow">
		
		
		<form:form action="${root }user/loginPro" method="POST" modelAttribute="loginUserInfo">
			<form:hidden path="userIdExist"/>
			<h2>로그인</h2>
			
			<div class="containerBox" id="containerBox1">
				<form:label path="user_id">아이디</form:label><br>
				<form:input path="user_id"/><br>
				<form:errors  path="user_id" style="color:red"></form:errors><br>
			</div>
			<div class="containerBox" id="containerBox2">
				<form:label path="user_pw">비밀번호</form:label><br>
				<form:password path="user_pw" /><br>
				<form:errors path="user_pw" style="color:red"></form:errors><br><br>
			</div>
			<form:button class="btn btn-primary submit" id="loginButton">로그인</form:button>
			<form:button class="btn btn-success" id="signUpButton" onclick="location.href='${root}user/signup' ">회원가입</form:button>
			<form:button type="button" class="btn btn-danger" id="loginButton" onclick="location.href='${root }main/index' " >취소</form:button>
		
		</form:form>
	</div>
	
	
	
</body>
</html>