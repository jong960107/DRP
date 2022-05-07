<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="root" value="/"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<form:form action="${root }user/signupPro" method="post" modelAttribute="modifyUserInfo">
			<h2>회원가입</h2>
			<div class="containerBox" id="containerBox1">
				<form:label path="user_name">이름</form:label>
				<form:input path="user_name" />
				<form:errors path="user_name" style="color:red"></form:errors>
			</div>
			<div class="containerBox" id="containerBox2">
				<form:label path="user_id">아이디</form:label>
				<form:input path="user_id" />
				<form:errors  path="user_id" style="color:red"></form:errors>
			</div>
			<div class="containerBox" id="containerBox3">
				<form:label path="user_pw">비밀번호</form:label>
				<form:password path="user_pw" />
				<form:errors path="user_pw" style="color:red"></form:errors>
			</div>
			<div class="containerBox" id="containerBox4">
				<form:label path="user_pw2">비밀번호확인</form:label>
				<form:password path="user_pw2" />
				<form:errors path="user_pw2" style="color:red"></form:errors>
			</div>
			<form:button>회원가입</form:button>
		</form:form>
	</div>

</body>
</html>