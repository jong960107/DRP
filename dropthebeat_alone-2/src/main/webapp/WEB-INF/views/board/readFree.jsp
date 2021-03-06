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

</head>
<body>

 <c:import url="/WEB-INF/views/include/top.jsp"> </c:import>
	
<!-- 상단 메뉴 부분 -->


<div class="container" style="margin-top:100px">
	<div class="row">
		<div class="col-sm-3"></div>
		<div class="col-sm-6">
			<div class="card shadow">
				<div class="card-body">
					<div class="form-group">
						<label for="board_writer_name">작성자</label>
						<input type="text" id="board_writer_name" name="board_writer_name" class="form-control" value="${readContentBean.content_writer_name }" disabled="disabled"/>
					</div>
					<div class="form-group">
						<label for="board_date">작성날짜</label>
						<input type="text" id="board_date" name="board_date" class="form-control" value="${readContentBean.content_date }" disabled="disabled"/>
					</div>
					<div class="form-group">
						<label for="board_subject">제목</label>
						<input type="text" id="board_subject" name="board_subject" class="form-control" value="${readContentBean.content_subject }" disabled="disabled"/>
					</div>
					<div class="form-group">
						<label for="board_content">내용</label>
						<textarea id="board_content" name="board_content" class="form-control" rows="10" style="resize:none" disabled="disabled">${readContentBean.content_text }</textarea>
					</div>
					<c:if test="${readContentBean.content_file != null }">
					<div class="form-group">
						<label for="board_file">첨부음악</label>
						<audio controls="controls" src="${root }${readContentBean.content_file}" width="100%"></audio>	
					</div>
					</c:if>
					<div class="form-group">
						<div class="text-right">
								<a href="${root }board/free?boardInfoBeanIdx1=${boardInfoBeanIdx1}" class="btn btn-primary">목록보기</a>			
									<c:if test="${loginUserBean.user_idx == readContentBean.content_writer_idx }">
									<a href="${root }board/modifyFree?boardInfoBeanIdx1=${boardInfoBeanIdx1}&content_idx=${content_idx}" class="btn btn-info">수정하기</a>
									<a href="${root }board/deleteFree?boardInfoBeanIdx1=${boardInfoBeanIdx1}&content_idx=${content_idx}" class="btn btn-danger">삭제하기</a>
								</c:if>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-sm-3"></div>
	</div>
</div>
	

</body>
</html>