<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <c:set var="root" value="/"></c:set>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
<style type="text/css">

*{
	box-sizing: border-box;
}

body{
 width:900px;
 height: 500px;
 margin:0 auto;
 overflow: hidden;
}

#top{
	float:left;
	width:300px;
	height:450px;
}

#dataArea{
	float: left;
	display: flex;
	width:600px;
	height:450px;
	align-items: center;
	justify-content: center;
}

</style>


</head>
<body>
<div id="top">
 <c:import url="/WEB-INF/views/include/top.jsp"> </c:import>
</div>

<div id="dataArea"></div>					  

<c:import url="/WEB-INF/views/include/bottom.jsp"></c:import>


<script type="text/javascript" language="javascript">

	window.onload = function(){
	
			$.ajax({
				type : 'get',
				url : '${root}board/record',
				dataType : 'html',
				error : function(data){
					
					alert('통신실패!!');
				},
				success : function(data){
				
					$("#dataArea").html(data) ;
				}
				
				});
	};


</script>
</body>
</html>