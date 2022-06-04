<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="root" value="/"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Playfair+Display:ital@1&display=swap" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
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
	
	#signUpButton{
		display:block;
		height:50px;
		margin:0 auto;
		width: 80%;
		border:solid 3px white;
		margin-bottom: 10px;
	}
	
	#loginButton{
		display:block;
		height:50px;
		margin:0 auto;
		width: 80%;
		border:solid 3px white;
		margin-bottom: 10px;
	}
	
	
	#checkUserIdExistButton{
		width: 90%;
		height: 40px;
		border: solid 3px white;
		background-color: red;
		color:white;
		border-radius: 10%;
		
	}
	
	#checkUserIdExistButton:hover{
		width: 90%;
		height: 40px;
		border: solid 3px #ececec;
		background-color: red;
		color:white;
		border-radius: 10%;
		
	}
	
</style>


</head>
<body>


<script type="text/javascript">
	function checkUserIdExist(){
		var user_id = $("#user_id").val();
		if(user_id.length==0){
			alert("아이디를 입력해주세요.");
			return;
		}
		
		$.ajax({
			url:"${root}user/checkUserIdExist/"+user_id,
			type:"GET",
			dataType:"text",
			success: function(result){
				if(result.trim() == "true"){
					alert("사용할수  있는 아이디입니다.");
					$("#userIdExist").val("true");
				}else{
					alert("사용할수 없는 아이디입니다.");
					$("#userIdExist").val("false");	
				}
			}
		})
	}
	
	function resetUserIdExist(){
		$("#userIdExist").val("false");
	}
</script>



	<div class="container">
		<form:form action="${root }user/signupPro" method="post" modelAttribute="modifyUserInfo">
			<form:hidden path="userIdExist"/>
			<h2>회원가입</h2>
			<div class="containerBox" id="containerBox1">
				<form:label path="user_name" id="user_nameLabel">이름</form:label> <br>
				<form:input path="user_name" /><br>
				<form:errors path="user_name" style="color:red"></form:errors><br>
			</div>
			<div class="containerBox" id="containerBox2">
				<form:label path="user_id">아이디</form:label><br>
				<form:input path="user_id" onkeypress="resetUserIdExist()"/><br>
				<div class="checkUserIdExistClass">
					<button type="button" id="checkUserIdExistButton" onclick="checkUserIdExist()">중복검사</button>
				</div>
				<form:errors  path="user_id" style="color:red"></form:errors><br>
			</div>
			<div class="containerBox" id="containerBox3">
				<form:label path="user_pw">비밀번호</form:label><br>
				<form:password path="user_pw" /><br>
				<form:errors path="user_pw" style="color:red"></form:errors><br><br>
			</div>
			<div class="containerBox" id="containerBox4">
				<form:label path="user_pw2">비밀번호 확인</form:label><br>
				<form:password path="user_pw2" /><br>
				<form:errors path="user_pw2" style="color:red"></form:errors><br><br>
			</div>
			<form:button id="signUpButton" class="btn btn-primary submit">회원가입</form:button>
			<form:button type="button" class="btn btn-danger" id="loginButton" onclick="location.href='${root }main/index' " >취소</form:button>
			
		</form:form>
	</div>

</body>
</html>