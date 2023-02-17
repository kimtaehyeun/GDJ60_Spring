<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
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
</body>
</html>