<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/common_css.jsp"></c:import>
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	<div class="container-fluid">
		<div class="row mb-4 mt-4 md-7">
			<h1 class="col-md-5 mx-auto text-center border border-primary pb-3">BankBook
				Addpage</h1>
		</div>
		<div class="row col-md-7 mx-auto">
			<form action="./add" method="POST">
				<div class="mb-3">
					<label for="bookName" class="form-label">상품명</label> <input
						type="text" class="form-control" name="bookName">
				</div>

				<div class="mb-3">
					<label for="bookRate" class="form-label">이자율</label> <input
						type="text" class="form-control" name="bookRate">
				</div>
				<div class="mb-3">
					<label for="bookDetail" class="form-label">상세설명</label>
					<textarea class="form-control" name="bookDetail" rows="3"></textarea>
				</div>
				<div class="mb-3">
					<label for="files" class="form-label">이미지</label>
					<input type="file" class="form-control" id="files" name="pic">
				</div>
				
				<div class="form-check">
					<input class="form-check-input" type="radio" name="bookSale"
						value="1" checked> <label class="form-check-label">
						판매 </label>
				</div>
				<div class="form-check">
					<input class="form-check-input" type="radio" name="bookSale"
						value="0"> <label class="form-check-label"> 판매중단 </label>
				</div>
				<button type="submit"
					class="btn btn-outline-primary col col-md-2 offset-md-10">등록
				</button>
			</form>
		</div>
	</div>

	<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>