<%@page import="java.util.ArrayList"%>
<%@page import="com.iu.s1.product.ProductDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.iu.s1.product.ProductController"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>List page</h1>

<%ArrayList<ProductDTO> ar = (ArrayList<ProductDTO>)request.getAttribute("list");
	for(ProductDTO productDTO:ar){
	%>
	<h3><%=productDTO.getName()%></h3>	
<% }%>	
		


</body>
</html>