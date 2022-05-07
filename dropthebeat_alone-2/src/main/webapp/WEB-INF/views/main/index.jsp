<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.content_main {
height:600px;
display: grid;
grid-template-columns: 1fr 3fr 1fr;
grid-template-rows: 1fr;
grid-column-gap: 0px;
grid-row-gap: 0px;
}

.div1_main { grid-area: 1 / 1 / 2 / 2; }
.div2_main { 
	grid-area: 1 / 2 / 2 / 3; 
	display: grid;
	grid-template-columns: repeat(2, 1fr);
	grid-template-rows: repeat(2, 1fr);
	grid-column-gap: 0px;
	grid-row-gap: 0px;}
.div3_main { grid-area: 1 / 3 / 2 / 4; }



.divs_board { grid-area: 1 / 2 / 2 / 3; }
</style>

</head>
<body>

<c:import url="/WEB-INF/views/include/top.jsp"></c:import>


<div class="content_main">
	<div class="div1_main"> 
		
	</div>
	<div class="div2_main">
		<div class="divs_board"> </div>
	 </div>
	<div class="div3_main"> </div>
</div>
<c:import url="/WEB-INF/views/include/bottom.jsp"></c:import>

</body>
</html>