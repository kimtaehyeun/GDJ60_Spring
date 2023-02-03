<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Add page</h1>
<div class="col-6">
	<form action="./productAdd"  method="post">
		상품명
		<input type="text"  name="name"  value="" placeholder="상품명 입력"><br>
		
		상품정보<br>
		<textarea name="detail" rows="4" cols="10"></textarea><br>
		
		<input type="submit" value="등록">
	</form>
</div>
</body>
</html>