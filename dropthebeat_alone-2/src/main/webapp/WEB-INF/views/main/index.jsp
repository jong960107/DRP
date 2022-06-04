<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<c:set var="root" value="/"></c:set>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Drp Project</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>

<style type="text/css">

#center{
	display: flex;
	align-items: center;
	justify-content: center;
	margin: 0;
	min-height: 100vh;
	flex-direction: column;
}


#importantRead{
	color:red;
	font-weight: bold;
}
</style>
</head>

<body>

<c:import url="/WEB-INF/views/include/top.jsp"> </c:import>

<div id="center">
<h1>DROP THE BEAT</h1>

<h3>DROP THE BEAT 커뮤니티에 오신 회원분들을 환영합니다.!</h3>
<h4 id="importantRead">필독!</h4>
<br>
<br>
<h4>이 커뮤니티는 절대로 회원님이 작성한 게시판에 올린 글과 관련된 사실과 무관하며, <br>
 그 글로 인하여 발생되는 모든 사건 및 문제들은 그 글을 작성한 회원 당사자에게 귀속됨을 알립니다. <br>

 고로 절대로 사실과 무관한 이야기나 남을 비방하는 글이나 음성녹음을 하시지 마시기 바랍니다. <br>
그럼 세상에 자신의 이야기를 알릴 목소리를 비트와 함께 들려주세요!!!</h4>
</div>



<c:import url="/WEB-INF/views/include/bottom.jsp"> </c:import>
	
</body>
</html>