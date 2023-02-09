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
		<input type="hidden" value="${dto.bookNumber}"  readonly="readonly" name="bookNumber"><br>
<fieldset>
		<label>상품명</label>
		<input type="text" value="${dto.bookName}"  name="bookName"><br> 
		</fieldset>
		<fieldset>
		<label>상품재고</label>
		<input type="text" value="${dto.bookRate}"  name="bookRate"><br> 
		</fieldset>
		
		<fieldset>
		<label for="sale">판매중</label>
		<input id="sale" type="radio" ${dto.bookSale eq 1 ? 'checked':''} value ="1" name="bookSale" >
		<label for="dissale">판매중단</label>
		<input id="dissale" type="radio" ${dto.bookSale eq 0 ? 'checked':''} value ="0" name="bookSale"><br>
		
		</fieldset>
		
	<!-- 	<select name="bookSale">
			<option value="1">판매</option>
			<option value="0">판매중단</option>
		</select> -->
		<fieldset>
		상품설명 <textarea rows="text" name="bookDetail" cols="5">${dto.bookDetail}</textarea>
		<br>
		</fieldset>
		<input type="submit" value="업데이트" >
		


	</form>
</body>
</html>