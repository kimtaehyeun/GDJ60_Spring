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
		
			<form action="./memberUpdate" method="post">
				이름 : <input type="text" class="form-control" name="name" value="${sessionScope.member.name}" ><br>
				주소 : <input type="text" class="form-control" name="address" value="${sessionScope.member.address}"  ><br>
				폰넘버 : <input type="text" class="form-control" name="phone" value="${sessionScope.member.phone}" ><br>
				이메일 : <input type="text" class="form-control" name="email" value="${sessionScope.member.email}" ><br>
				<!--  안보내도됨--><%-- <input type="hidden" name="id" value="${sessionScope.member.id}" ><br> --%>
				<button type="submit">전송</button>
			</form>
		</div>

	</div>

	<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>