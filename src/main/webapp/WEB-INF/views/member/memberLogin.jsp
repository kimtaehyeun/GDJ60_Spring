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
	<div class="container-fluid my-5">
		<div class="row mb-4">
			<h2 class="col-5 mx-auto text-center border border-dark pb-3 ">login page</h2>
		</div>
		<div class="row">
			<form action="./memberLogin" method="post" class="col-5 mx-auto">
				<div class="mb-3">
					<label class="form-label">ID</label> <input type="text"
						class="form-control" name="id" placeholder="ID입력">
				</div>
				<div class="mb-3">
					<label class="form-label">PW</label> <input type="password"
						class="form-control" name="pw">
				</div>
				<button type="submit" class="btn btn-primary">Login</button>
			</form>
		</div>
	</div>
	<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>