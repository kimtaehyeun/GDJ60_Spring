<%@page import="com.iu.s1.product.ProductDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>detail page</h1>
	<%
	ProductDTO productDTO = (ProductDTO) request.getAttribute("dto");
	%>
	<h3><%=productDTO.getName()%></h3>
	<h3><%=productDTO.getDetail()%></h3>

<hr>
	<h3>${requestScope.dto.name}</h3>
	<h3>${requestScope.dto.detail}</h3> 
	
</body>
</html>