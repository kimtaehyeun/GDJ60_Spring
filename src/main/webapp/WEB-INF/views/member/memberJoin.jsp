<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/common_css.jsp"></c:import>
<style>
	.redResult{
		color: red;
	}
	.blueResult{
		color: blue;
	}
</style>

</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	<div class="container-fluid my-5">
		<div class="row mb-4">
			<h1
				class="col-md-7 mx-auto text-center border-bottom border-dark pb-3">회원가입 페이지</h1>
		</div>
		<div class="col-md-6 mx-auto">
			<form action="./memberJoin" method="post" class="row g-3" id="frm">
				<div class="col-md-6">
					<div class="mb-3">
						<label class="form-label">ID</label> <input type="text"
							class="form-control check" name="id" placeholder="ID입력" id = "id">
								<label class="form-label qwe" id="idcheck"></label>
					</div>
					<div class="mb-3">
						<label class="form-label">PW</label> <input type="password"
							class="form-control" name="pw" id="pw1">
							<label class="form-label" id ="pw1check"></label>
					</div>
					<div class="mb-3">
						<label class="form-label">PW확인</label> <input type="password"
							class="form-control" id="pw2">
							<label class="form-label" id="pw2check"></label>
						
					</div>
					
					<div class="mb-3">
						<label class="form-label">NAME</label> <input type="text"
							class="form-control" name="name" id="name">
							<label class="form-label" id="namecheck"></label>
					</div>
					<div class="mb-3">
						<label class="form-label ">ADDRESS</label> <input type="text"
							class="form-control" name="address" id="address">
							<label class="form-label" id="addresscheck"></label>
							 
					</div>
					<div class="mb-3">
						<label class="form-label">PHONE</label> <input type="text"
							class="form-control" name="phone" id="phone">
							<label class="form-label qwe" id="phonecheck"></label>
					</div>
					<div class="mb-3">
						<label class="form-label">EMAIL</label> <input type="text"
							class="form-control" name="email" id="email">
							<label class="form-label qwe" id="emailcheck"></label>
					</div>
					<div class="col-12">
						<button type="button" class="btn btn-primary"  id="btn" onclick="f2()">회원가입</button>
					</div> 
				</div>
			</form>
		</div>
	</div>
	<script type="text/javascript" src="/resources/js/memberJoin.js"></script>
	<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>