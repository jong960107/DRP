<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="root" value="/"></c:set>
<script>
alert("저장에 성공하셨습니다.");
location.href="${root}board/free?boardInfoBeanIdx1=${boardInfoBeanIdx1}&content_idx=${writeContentBean.content_board_idx}&content_idx=${writeContentBean.content_idx}"
</script>