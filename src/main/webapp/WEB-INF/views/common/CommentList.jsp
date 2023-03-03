<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<table>
	<c:forEach items="${list}" var="dto">
		<tr>
			<td>${dto.contents }</td>
			<td>${dto.writer }</td>
			<td>${dto.regDate }</td>
		</tr>

	</c:forEach>

</table>
<!-- paging -->
		<div class="row">
			<nav aria-label="Page navigation example">
				<ul class="pagination">
					<li class="page-item"><a class="page-link" href="#"
						aria-label="Previous" data-board-page="1"> <span
							aria-hidden="true">&laquo;</span>
					</a></li>
					<li class="page-item  ${pager.before ? 'disabled' : ''}"><a
						class="page-link" href="#" aria-label="Previous"
						data-board-page="${pager.startNum-1}"> <span
							aria-hidden="true">&lsaquo;</span>
					</a></li>
					<c:forEach begin="${pager.startNum}" end="${pager.lastNum}"
						step="1" var="i">
						<li class="page-item"><a class="page-link" href="#"
							data-board-page="${i}">${i}</a></li>
					</c:forEach>

					<li class="page-item ${pager.after eq false ? 'disabled' : ''}"><a
						class="page-link" href="#" aria-label="Next"
						data-board-page="${pager.lastNum+1}"> <span aria-hidden="true">&rsaquo;</span>
					</a></li>
					<li class="page-item"><a class="page-link" href="#"
						aria-label="Next" data-board-page="${pager.totalPage}"> <span
							aria-hidden="true">&raquo;</span>
					</a></li>
				</ul>
			</nav>
		</div>

