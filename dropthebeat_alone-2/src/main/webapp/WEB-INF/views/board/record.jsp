<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<style type="text/css">
	
	
	#recorder{
		width:200px;
		height: 200px;
		background: #00d3d3;
		border-radius: 50%;
		margin: 0 auto;
		justify-content: center;
	}

	#recorder:hover{
		width:200px;
		height: 200px;
		background: #00d3d3;
		opacity: 0.5;
		border-radius: 50%;
		margin: 0 auto;
		justify-content: center;
	}
	
	#recording{
		color: white;
		font-size: 100px;
		position: relative;
		top:20px;
	}
		
	
</style>
</head>
<body>

	<div id="recorder">
	<span id="recording">DRP</span>
	</div>


</body>
</html>