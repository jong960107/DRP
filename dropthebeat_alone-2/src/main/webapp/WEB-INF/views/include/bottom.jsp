<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<c:set var="root" value="/"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.parent {
	height:100px;
	display: grid;
	grid-template-columns: 1fr 3fr 1fr;
	grid-template-rows: 1fr;
	grid-column-gap: 0px;
	grid-row-gap: 0px;
	line-height: 100px;
}

.div1 { 
grid-area: 1 / 2 / 2 / 3; 
text-align: center;
}
</style>

</head>
<body>
<div class="parent">
<div class="div1">
	문의사항: jong960107@naver.com
 </div>
</div>
</body>
</html>