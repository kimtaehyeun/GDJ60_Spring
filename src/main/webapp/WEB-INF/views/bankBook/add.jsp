<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	등록 페이지
	<form action="./add" method="POST">


		<fieldset>
			<legend>상품명</legend>
			<input type="text" name="bookName"><br>
		</fieldset>

		<fieldset>
			<legend>이자율</legend>
			<input type="text" name="bookRate"><br>
		</fieldset>
		<fieldset>
			<legend>상세설명</legend>
			<input type="text" name="bookDetail">
		</fieldset>


		<!-- 	<fieldset>
			<legend>판매여부</legend>
			<select name="bookSale">
				<option value="1">판매</option>
				<option value="0" selected="selected">판매중단</option>
			</select>
		</fieldset> -->

		<fieldset>
			<legend>판매여부</legend>
			<label for="bs1">판매</label> 
			<input id="bs1" type="radio" name="bookSale" value="1"> 
			<label for="bs2">판매중단</label> 
			<input id="bs2" type="radio" name="bookSale" value="0">
		</fieldset>

		<input type="submit" value="등록">

	</form>
</body>
</html>