<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
	<link rel="stylesheet" href="../resources/css/main.css">
</head>
<body>
<h1>
	Hello world!  
</h1>
<div class="c3">
	<a href = "./product/list?num=1&num=2&num=3">product List</a>
	<a href = "/product/list">product List</a><br>
	<a href = "/bankBook/list">BankBook절대경로</a>
	<a href = "./bankBook/list">BankBook상대경로</a><br>
</div>
<img alt="iu" src="/resources/images/iu1.jpg">
<img alt="" src="./resources/images/iu2.jpg">
<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
