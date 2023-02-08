<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Update Page</h1>
	<form action="./update" method="POST">


		상품명 <input type="text" value="${dto.bookName}"  name="bookName"><br> 
		상품재고 <input type="text" value="${dto.bookRate}"  name="bookRate"><br> 
		상품판매 <input type="text" value="${dto.bookSale}" name="bookSale"><br> 
		상품설명 <textarea rows="text" name="bookDetail" cols="1">${dto.bookDetail}</textarea>

	</form>

	</form>
</body>
</html>