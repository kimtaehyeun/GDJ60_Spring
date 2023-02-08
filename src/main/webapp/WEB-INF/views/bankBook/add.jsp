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

상품명
<input type="text" name="bookName"><br>
상품재고
<input type="text" name="bookRate"><br>
상품판매<br>
판매중
<input type="radio" value ="1" name="bookSale">
판매중단
<input type="radio" value ="0" name="bookSale">
<br>
상품설명
<input type="text" name="bookDetail"><br>
<input type="submit" value="등록">

</form>
</body>
</html>