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
		<div class="row">
			<h1>Member Page</h1>
		</div>
		<div class="row">
			<h3>${dto.name}</h3>
			<h3>${dto.address}</h3>
			<h3>${dto.phone}</h3>
			<h3>${dto.email}</h3>
			<a href="/member/memberUpdate">수정</a>
		</div>
	</div>
	<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>