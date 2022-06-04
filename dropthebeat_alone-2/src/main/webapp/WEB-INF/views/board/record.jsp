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

</style>
</head>

<body>

<div id="playMusic">
		<audio src="/1.mp3" controls="controls"></audio>
</div>
	
<c:import url="/WEB-INF/views/include/top.jsp"> </c:import>

<c:import url="/WEB-INF/views/main/index2.jsp"> </c:import>
	
</body>
</html>


