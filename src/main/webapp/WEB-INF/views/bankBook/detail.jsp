<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/common_css.jsp"></c:import>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
<div class="container-fluid">
	<c:if test="${not empty dto}">
		<h1>Detail Page</h1>
		<h3>Number : ${dto.bookNumber}</h3>
		<h3>Title : ${dto.bookName}</h3>
		<h3>detail : ${dto.bookDetail}</h3>
		<h3>Rate: ${dto.bookRate}</h3>
		<h3>Sale: ${dto.bookSale}</h3>
		<div>
		<c:if test="${not empty dto.bankBookImgDTO}">
			<img alt="" src="../resources/upload/bankBook/${dto.bankBookImgDTO.fileName}">
		</c:if>
		</div>
		<a href="./delete?bookNumber=${dto.bookNumber}">상품삭제</a>
	</c:if>
	<c:if test="${empty dto}">
		<h3>없음</h3>
	</c:if>
	<a href="./update?bookNumber=${dto.bookNumber}">상품수정</a>
	<a href="./list">목록으로</a>
	</div>

	<div class="my-5" id="commentList">
		

	</div>
	
	<div class="my-5">
		<div class="mb-3">
			<textarea class="form-control" id="textArea"
				rows="3"></textarea>
		</div>
		<div class="mb-3">
		<button type="button" class="btn btn-primary" id="btn" data-book-bookNumber="${dto.bookNumber}">댓글 작성</button>
		</div>
	</div>
		<c:import url="../template/common_js.jsp"></c:import>
	<script src="/resources/js/bankBookReply.js"></script>
</body>
</html>