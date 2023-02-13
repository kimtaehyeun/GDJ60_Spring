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
			<h1
				class="col-md-7 mx-auto text-center border-bottom border-dark pb-3">회원가입 페이지</h1>
		</div>
		<div class="col-md-6 mx-auto">
			<form action="./memberJoin" method="post" class="row g-3">
				<div class="col-md-6">
					<div class="mb-3">
						<label class="form-label">ID</label> <input type="text"
							class="form-control" name="id" placeholder="ID입력">
					</div>
					<div class="mb-3">
						<label class="form-label">PW</label> <input type="password"
							class="form-control" name="pw">
					</div>
					<div class="mb-3">
						<label class="form-label">NAME</label> <input type="text"
							class="form-control" name="name">
					</div>
					<div class="mb-3">
						<label class="form-label">ADDRESS</label> <input type="text"
							class="form-control" name="address">
					</div>
					<div class="mb-3">
						<label class="form-label">PHONE</label> <input type="text"
							class="form-control" name="phone">
					</div>
					<div class="mb-3">
						<label class="form-label">EMAIL</label> <input type="text"
							class="form-control" name="email">
					</div>
					<div class="col-12">
						<button type="submit" class="btn btn-primary">회원가입</button>
					</div> 
				</div>
			</form>
		</div>
	</div>
	<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>