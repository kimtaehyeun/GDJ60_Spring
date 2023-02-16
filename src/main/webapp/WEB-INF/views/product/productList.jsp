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
	<div class="row">
		<nav aria-label="Page navigation example">
			<ul class="pagination">
				<li class="page-item ${pager.before ? 'disabled' : ''}"><a
					class="page-link" href="./list?page=${pager.startNum-1}"
					aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
				</a></li>
				<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" step="1"
					var="i">
					<li class="page-item"><a class="page-link"
						href="./list?page=${i}">${i}</a></li>
				</c:forEach>
				<li class="page-item ${pager.after eq false ? 'disabled' : ''}"><a
					class="page-link" href="./list?page=${pager.lastNum+1}"
					aria-label="Next"> <span aria-hidden="true">&raquo;</span>
				</a></li>
			</ul>
		</nav>
	</div>
	<!-- search -->
	<form class="row g-3" action="./list" method="get">
		<div class="col-auto">
			<label for="search" class="visually-hidden">Search</label>
			<input type="text" class="form-control" id="search" name="search"
				placeholder="검색어를 입력하세요." value="">
		</div>
		<div class="col-auto">
			<button type="submit" class="btn btn-primary mb-3">검색
				</button>
		</div>
	</form>



	<a class=" btn btn-danger" href="./productAdd">상품등록</a>

	<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>