<%@page import="java.util.List"%>
<%@page import="com.iu.s1.product.ProductDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/common_css.jsp"></c:import>
<link rel="stylesheet" href="/resources/css/table.css">

</head>

<body>
	<c:import url="../template/header.jsp"></c:import>
	<h1 class="title">product ListPage</h1>

	<table class="tb2">
		<thead>
			<tr>
				<th>상품명</th>
				<th>평점</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="dto">
				<tr>
					<!-- dto는 페이지 영역에 담김 -->
					<td><a href="./detail?productNum=${dto.productNum}">${pageScope.dto.productName}</a>
					</td>
					<td>${pageScope.dto.productNum}</td>
				<tr>
			</c:forEach>
		</tbody>
	</table>
	<a class=" btn btn-danger" href="./productAdd">상품등록</a>
	
	<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>