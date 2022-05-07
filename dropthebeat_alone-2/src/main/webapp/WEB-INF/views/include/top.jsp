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
<style type="text/css">
/* reset.css */

	*{
	box-sizing: border-box;
	margin:0;
	}
	
/* header */

		#contentWrapper{
		height:100px;
		display: grid;
		grid-template-columns: 1fr 3fr 1fr;
		grid-template-rows: 1fr;
		grid-column-gap: 0px;
		grid-row-gap: 0px;
}
		.div2_top { 
		grid-area: 1 / 2 / 2 / 3; 
		text-align: center; 
		border-bottom: 1px solid black;
		
		}
		
		.div2_top a{
		text-decoration: none;
		font-family: 'Tangerine', cursive;
		color:black;
		}
		
	
		
	
	.div2_top h1{
	font-family: 'Tangerine', cursive;
	font-size: 50px;
	text-align:center;
	margin-top: 20px;
	}
	
	.div2_top label{
	font-family: 'Tangerine', cursive;
	text-align:center;
	display:block;
	}
	
	.div1_top li{
	display:block;
	list-style: none;
	font-size: 10px;
	padding-left: 10px;
	padding-top:10px;
	text-align: center;
	}
	
	.div1_top a{
	text-decoration: none;
	color:black;
	font-family: 'Tangerine', cursive;
	}
	
	
	
	.div3_top li{
	display:block;
	list-style: none;
	font-size: 10px;
	padding-left: 10px;
	padding-top:10px;
	text-align: center
	}
	
	.div3_top a{
	text-decoration: none;
	color:black;
	font-family: 'Tangerine', cursive;
	}

	
	
</style>
</head>
<body>

	<div id="contentWrapper" class="contentWrapper">
		<div class="div1_top">
				<br>
			<ul>
			  <li> <a href="${root }board/free" >자유게시판</a> </li>
			  <li> <a href="${root }board/fun" >유머게시판</a>  </li>
			  <li> <a href="${root }board/politics" >정치게시판</a>  </li>
			  <li> <a href="${root }board/sport">스포츠게시판</a>  </li>
			</ul>
		</div>
		
		<div class="div2_top">
			<a href="index">
				<h1>DropTheBeat</h1>
				<label>made by One of 4th Grade 
				Student at MyongJi School</label>
			</a>
		</div>
	
		
	<div class="div3_top">
		<br>
		<ul>
		  <li> <a href="${root }user/login" >로그인</a> </li>
		  <li> <a href="${root }user/signup" >회원가입</a>  </li>
		  <li> <a href="${root }user/modify" >정보수정</a>  </li>
		  <li> <a href="${root }user/logout">로그아웃</a>  </li>
		</ul>
	</div>
	
</div>

</body>
</html>