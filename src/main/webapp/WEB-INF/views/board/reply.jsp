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
			<h1 class="col-md-5 mx-auto text-center border border-primary pb-3">${boardName} Add Page</h1>
		</div>
		<div class="row col-md-7 mx-auto">
			<form action="./reply" method="POST" enctype="multipart/form-data">
				<input type="hidden" name="num" value="${boardDTO.num}">
				<div class="mb-3">
					<label for="writer" class="form-label">작성자</label> <input
						type="text" class="form-control" name="writer" id="writer">
				</div>

				<div class="mb-3">
					<label for="title" class="form-label">제목</label> <input
						type="text" class="form-control" name="title" id="title">
				</div>
				<div class="mb-3">
					<label for="contents" class="form-label">글내용</label>
					<textarea class="form-control" name="contents" rows="3" id="contents"></textarea>
				</div>
				<!-- <div id="fileList">
					<div class="mb-3">
						<label for="files" class="form-label" >이미지</label>
						<input type="file" class="form-control" id="files" name="pic">
					</div>
					<button type="button" id="btn">add</button>
				</div>
				<div class="form-check">
					<input class="form-check-input" type="radio" name="bookSale"
						value="1" checked> <label class="form-check-label">
						판매 </label>
				</div>
				<div class="form-check">
					<input class="form-check-input" type="radio" name="bookSale"
						value="0"> <label class="form-check-label"> 판매중단 </label>
				</div> -->
				<button type="submit"
					class="btn btn-outline-primary col col-md-2 offset-md-10">글쓰기
				</button>
			</form>
		</div>
	</div>

	<c:import url="../template/common_js.jsp"></c:import>
	<script src="/resources/js/fileManager.js"></script>
	<script>
		setMax(3);
		setParam('f');
	</script>
</body>
</html>