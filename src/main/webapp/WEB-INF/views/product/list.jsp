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
List page
<%ProductController controller = new ProductController();%>
<%=controller.getProductList() %>
</body>
</html>