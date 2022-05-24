<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="root" value="/"></c:set>
<script>
alert("로그인에 실패하셨습니다.아이디와 비밀번호를 확인해주세요..!)");
location.href="${root}user/login"
</script>