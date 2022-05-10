<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<c:set var="root" value="/"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DropTheBeat</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Tangerine:wght@700&display=swap" rel="stylesheet">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=East+Sea+Dokdo&display=swap" rel="stylesheet">

<style type="text/css">
/* reset.css */




	*{
	box-sizing: border-box;
	margin:0;
	}
	
	.contentWrapper{
	width:220px;
	}
	
	h2{
		text-align: center;
		margin-top: 30px;
	}
	
	.contentWrapper button{
		height:50px;
		margin:0 auto;
		width: 100%;
		border:solid 3px white;
		background-color: skyblue;
		color:white;
	}
	
	.divTop1 li{
		list-style: none;
	}
	
	.divTop1 a{
		text-decoration: none;
		color:white;
		font-style: bold;
		font-size: 20px;
	}
	
	.divTop2 li{
		list-style: none;
	}
	
	.divTop2 a{
		text-decoration: none;
		color:white;
		font-style: bold;
		font-size: 20px;
	}
	
	
	
</style>
</head>
<body>

			  	<div id="contentWrapper" class="contentWrapper">  	
			  	
					<div class="divTop1">
					  	<h2>DropTheBeat</h2>
					
						<br>
						<ul>
						  <li> <button> <a href="${root }board/free" >자유게시판</a></button> </li>
						  <li> <button><a href="${root }board/fun" >유머게시판</a></button>  </li>
						  <li> <button><a href="${root }board/politics" >정치게시판</a></button>  </li>
						  <li> <button><a href="${root }board/sport">스포츠게시판</a></button>  </li>
						</ul>
					</div>
					
					<div class="divTop2">
						<br>
						<ul>
						  <li> <button><a href="${root }user/login" >로그인</a></button> </li>
						  <li> <button><a href="${root }user/signup" >회원가입</a></button>  </li>
						  <li> <button><a href="${root }user/modify" >정보수정</a></button>  </li>
						  <li> <button><a href="${root }user/logout">로그아웃</a></button>  </li>
						</ul>
					</div>
			  </div>
		
</body>
</html>