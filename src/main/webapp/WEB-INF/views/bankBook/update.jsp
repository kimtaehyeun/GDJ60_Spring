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

		<%-- 상품번호 <input type="text" value="${dto.bookNumber}"  name="bookNumber"><br> 
		 --%>
		<input type="hidden" value="${dto.bookNumber}" name="bookNumber">
		상품명 <input type="text" value="${dto.bookName}" name="bookName"><br>
		상품재고 <input type="text" value="${dto.bookRate}" name="bookRate"><br>
	
		판매중 <input type="radio" value="1" name="bookSale"> 
		판매중단 <input type="radio" value="0" name="bookSale">
			<br>
		
		상품설명
		<textarea rows="text" name="bookDetail" cols="1">${dto.bookDetail}</textarea>
		<br> <input type="submit" value="업데이트">
	</form>


</body>
</html>