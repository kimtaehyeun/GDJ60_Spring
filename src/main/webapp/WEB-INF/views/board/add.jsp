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
			<h1 class="col-md-5 mx-auto text-center border border-primary pb-3">${boardName}
				Add Page</h1>
		</div>
		<div class="row col-md-7 mx-auto">
			<form action="./add" method="POST" enctype="multipart/form-data">
				<div class="mb-3">
					<label for="writer" class="form-label">작성자</label> <input
						type="text" class="form-control" name="writer" id="writer">
				</div>

				<div class="mb-3">
					<label for="title" class="form-label">제목</label> <input type="text"
						class="form-control" name="title" id="title">
				</div>
				<div class="mb-3">
					<label for="contents" class="form-label">글내용</label>
					<textarea class="form-control" name="contents" rows="3"
						id="contents"></textarea>
				</div>

				<div id="fileList" class="my-5">
					<div class="mb-3">
						<label for="files" class="form-label">이미지</label> <input
							type="file" class="form-control" id="files" name="files">
						<button type="button" id = "deletebtn" class="dels">X</button>
					</div>
					<button type="button" id="fileAddbtn">add</button>
				</div>
				<div class="mb-3">
					<button type="submit" class="mt btn btn-danger">글쓰기</button>
				</div>
			</form>
		</div>
	</div>

	<c:import url="../template/common_js.jsp"></c:import>
	<script src="/resources/js/fileManager2.js"></script>
	 <script>
		setMax(5);
		/* setParam('f'); */
	</script>
</body>
</html>