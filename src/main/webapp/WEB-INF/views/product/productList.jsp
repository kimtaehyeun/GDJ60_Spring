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
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
</head>
<body>
	<h1>Product List</h1>
	<%
	List<ProductDTO> ar = (List<ProductDTO>) request.getAttribute("list");
	for (ProductDTO productDTO : ar) {
	%>
	<h3><%=productDTO.getProduct_Name()%></h3>


	<%
	}
	%>
	<hr>
	<div class="col-6">
		<table class="table table-hover">
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
						<td><a href="./detail?product_Num=${dto.product_Num}">${pageScope.dto.product_Name}</a>
						</td>
						<td>${pageScope.dto.product_Num}</td>
					<tr>
				</c:forEach>
			</tbody>
		</table>
		<a class=" btn btn-danger"href="./productAdd">상품등록</a>
		
		
	</div>

	<%-- ${requestScope.list}
	<a href="./detail?Num=1">productDetail</a>
	<a href="./detail?Num=1">productDetail</a> --%>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
		crossorigin="anonymous"></script>
</body>
</html>