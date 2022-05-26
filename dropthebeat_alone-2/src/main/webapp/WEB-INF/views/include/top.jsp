<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  

<c:set var="root" value="/"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DropTheBeat</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Tangerine:wght@700&display=swap" rel="stylesheet">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=East+Sea+Dokdo&display=swap" rel="stylesheet">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Playfair+Display:ital@1&display=swap" rel="stylesheet">
<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Tangerine:wght@700&display=swap" rel="stylesheet">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=East+Sea+Dokdo&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>

</head>
<body>

<!-- 상단 메뉴 부분 -->
<nav class="navbar navbar-expand-md bg-primary navbar-dark fixed-top shadow-lg">
	<a class="navbar-brand" href="${root }main/index">DropTheBeat</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
	        data-target="#navMenu">
		<span class="navbar-toggler-icon"></span>        
	</button>
	<div class="collapse navbar-collapse" id="navMenu">
		<ul class="navbar-nav">
			<li class="nav-item">
				 <a href="#" class="nav-link" id="recordButton">녹음시작</a>
			</li>
			<li class="nav-item">
				 <a href="#" class="nav-link" id="freeButton">자유게시판</a>
			</li>
			<li class="nav-item">
				<a href="#" class="nav-link" id="funButton">유머게시판</a>
			</li>
			<li class="nav-item">
				<a href="#" class="nav-link" id="politicsButton">정치게시판</a>
			</li>
			<li class="nav-item">
				<a href="#" class="nav-link" id="sportButton">스포츠게시판</a>
			</li>
		</ul>
		
		<ul class="navbar-nav ml-auto">
			<c:choose>
				<c:when test="${loginUserBean.userLogin == true }">
				<li class="nav-item">
				<a href="${root }user/modify" class="nav-link">정보수정</a>
				</li>
				<li class="nav-item">
					<a href="${root }user/logout" class="nav-link">로그아웃</a>
				</li>
					</c:when>
				<c:otherwise>
				<li class="nav-item">
				<a href="${root }user/login" class="nav-link">로그인</a>
				</li>
				<li class="nav-item">
					<a href="${root }user/signup" class="nav-link">회원가입</a>
				</li>
				</c:otherwise>
			</c:choose> 
		</ul>
	</div>
</nav>


<div id="content"></div>


<script type="text/javascript" >



window.onload = connectingAjax;
	
var connectingAjax = function(){
			$.ajax({
				type : 'get',
				url : "${root}board/record?boardInfoBeanIdx0=${boardInfoBeanIdx0}",
				dataType : 'html',
				error : function(data){
					
					alert('통신실패!!');
				},
				success : function(data){
					
					$("#content").html(data) 
				}		
		});		
					
};

/* ------------------------------------------------ */

var recordButton = document.getElementById("recordButton");
var freeButton = document.getElementById("freeButton");
var funButton = document.getElementById("funButton");
var politicsButton = document.getElementById("politicsButton");
var sportButton = document.getElementById("sportButton");

recordButton.addEventListener("click",	function(){
	$.ajax({
		type : 'get',
		url : "${root}board/record",
		dataType : 'html',
		error : function(data){
			
			alert('통신실패!!');
		},
		success : function(data){
			console.log("successFree")
			$("#content").html(data) 
		}		
});		
}

);



freeButton.addEventListener("click",	function(){
	$.ajax({
		type : 'get',
		url : "${root}board/free?boardInfoBeanIdx1=${boardInfoBeanIdx1}",
		dataType : 'html',
		error : function(data){
			
			alert('통신실패!!');
		},
		success : function(data){
			console.log("successFree")
			$("#content").html(data) 
		}		
});		
}

);

funButton.addEventListener("click",	function(){
	$.ajax({
		type : 'get',
		url : "${root}board/fun?boardInfoBeanIdx2=${boardInfoBeanIdx2}",
		dataType : 'html',
		error : function(data){
			
			alert('통신실패!!');
		},
		success : function(data){
			console.log("successFree")
			$("#content").html(data) 
		}		
});		
}

);

politicsButton.addEventListener("click",	function(){
	$.ajax({
		type : 'get',
		url : "${root}board/politics?boardInfoBeanIdx3=${boardInfoBeanIdx3}",
		dataType : 'html',
		error : function(data){
			
			alert('통신실패!!');
		},
		success : function(data){
			console.log("successFree")
			$("#content").html(data) 
		}		
});		
}

);

sportButton.addEventListener("click",	function(){
	$.ajax({
		type : 'get',
		url : "${root}board/sport?boardInfoBeanIdx4=${boardInfoBeanIdx4}",
		dataType : 'html',
		error : function(data){
			
			alert('통신실패!!');
		},
		success : function(data){
			console.log("successFree")
			$("#content").html(data) 
		}		
});		
}

);

</script>



</body>
</html>