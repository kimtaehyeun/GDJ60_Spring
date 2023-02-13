<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>저축상품</title>
<c:import url="../template/common_css.jsp"></c:import>

</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	<div class="container-fluid my-5">
		<div class="row justify-content-center">
			<h1
				class="col-md-7 mx-auto text-center border-bottom border-dark pb-3">BankBook
				ListPage</h1>
		</div>
		<div class="row col-md-7 mx-auto">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>상품명</th>
						<th>이자율</th>
						<th>판매여부</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="dto">
						<tr>
							<td><a href="./detail?bookNumber=${dto.bookNumber}">${pageScope.dto.bookName}</td>
							<td>${dto.bookRate}</td>
							<td>
								<%-- <c:if test="${dto.bookSale eq 1}">판매중</c:if> <c:if
									test="${dto.bookSale eq 0}">판매중단</c:if>
									 --%> <c:choose>
									<c:when test="${dto.bookSale eq 1}">판매중</c:when>
									<c:otherwise>판매중단</c:otherwise>
								</c:choose>
							</td>
						</tr>
					</c:forEach>
				</tbody>


			</table>
		</div>
		<div class="row col-md-7 mx-auto">
			<a href="./add" class="btn btn-primary col col-md-2 offset-md-10 ">상품등록 </a>
		</div>
	</div>
	<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>