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
<h1>회원가입페이지</h1>
<div class="col-6">
	<form action="./memberJoin"  method="post">
	
		ID
		<input type="text"  name="id"   placeholder="ID입력"><br>
		
		PW
		<input type="text"  name="pw" ><br>
		
		NAME
		<input type="text"  name="name" ><br>		
		ADDRESS
		<input type="text"  name="address" ><br>	
		PHONE
		<input type="text"  name="phone" ><br>	
		EMAIL
		<input type="text"  name="email" ><br>	
		<input type="submit" value="등록"> 
	</form>
</div>
</body>
</html>