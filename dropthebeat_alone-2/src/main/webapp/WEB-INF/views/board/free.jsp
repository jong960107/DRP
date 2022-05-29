<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="pageBean" value="${pageBean }"></c:set> 
<c:set var="root" value="/"></c:set>
<!DOCTYPE html>
<html>
<head>
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
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
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
</head>
<body>
 <c:import url="/WEB-INF/views/include/top.jsp"> </c:import>

	<!-- 게시글 리스트 -->
<div class="container" style="margin-top:100px">
	<div class="card shadow">
		<div class="card-body">
			<h4 class="card-title">자유게시판</h4>
			<table class="table table-hover" id='board_list'>
				<thead>
					<tr>
						<th class="text-center d-none d-md-table-cell">글번호</th>
						<th class="w-50">제목</th>
						<th class="text-center d-none d-md-table-cell">작성자</th>
						<th class="text-center d-none d-md-table-cell">작성날짜</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="obj" items="${contentList}">
					<tr>
						<td class="text-center d-none d-md-table-cell">${obj.content_idx }</td>
						<td><a href="${root }board/readFree?boardInfoBeanIdx1=${boardInfoBeanIdx1}&content_idx=${obj.content_idx}">${obj.content_subject }</a></td>
						<td class="text-center d-none d-md-table-cell">${obj.content_writer_name }</td>
						<td class="text-center d-none d-md-table-cell">${obj.content_date }</td>	
					</tr>
				</c:forEach>
				</tbody>
			</table>
			
			<div class="d-none d-md-block">
				<ul class="pagination justify-content-center">
				<c:choose>
				<c:when test="${pageBean.prevPage <= 0}">
					<li class="page-item disabled">
						<a href="#" class="page-link">이전</a>
					</li>
				</c:when>
				<c:otherwise>
					<li class="page-item">
						<a href="${root }board/free?boardInfoBeanIdx1=${boardInfoBeanIdx1}&page=${pageBean.prevPage}" class="page-link">이전</a>
					</li>
				</c:otherwise>
				</c:choose>
				
					
					<c:forEach var="idx" begin="${pageBean.min}" end="${pageBean.max}">
					<c:choose>
						<c:when test="${idx==pageBean.currentPage }">
							<li class="page-item active">
								<a href="${root }board/free?boardInfoBeanIdx1=${boardInfoBeanIdx1}&page=${idx}" class="page-link">${idx }</a>
							</li>
						</c:when>
					<c:otherwise>
							<li class="page-item ">
								<a href="${root }board/free?boardInfoBeanIdx1=${boardInfoBeanIdx1}&page=${idx}" class="page-link">${idx }</a>
							</li>
					</c:otherwise>
					</c:choose>
					</c:forEach>
				<c:choose>
					<c:when test="${pageBean.prevPage <= 0}">
						<li class="page-item disabled">
							<a href="#" class="page-link">다음</a>
						</li>
					</c:when>
					<c:otherwise>
						<li class="page-item">
							<a href="${root }board/free?boardInfoBeanIdx1=${boardInfoBeanIdx1}&page=${pageBean.nextPage}" class="page-link">다음</a>
						</li>
					</c:otherwise>
				</c:choose>
				</ul>
			</div>
			
			<div class="d-block d-md-none">
				<ul class="pagination justify-content-center">
					<li class="page-item">
							<a href="${root }board/free?boardInfoBeanIdx1=${boardInfoBeanIdx1}&page=${pageBean.prevNum}" class="page-link">이전</a>
					</li>
					<li class="page-item">
							<a href="${root }board/free?boardInfoBeanIdx1=${boardInfoBeanIdx1}&page=${pageBean.nextNum}" class="page-link">다음</a>
					</li>
				</ul>
			</div>
			
			<div class="text-right">
				<a href="${root }board/writeFree?boardInfoBeanIdx1=${boardInfoBeanIdx1}" class="btn btn-primary">글쓰기</a>
			</div>
			
		</div>
	</div>
</div>


</body>
</html>