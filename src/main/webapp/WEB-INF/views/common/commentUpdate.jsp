<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<textarea name="contents" cols="30" rows="10" id="contents">${dto.contents}
</textarea>
<input type="hidden" value="${dto.num}" name="num">
<button class="submitbtn" data-comment-num="${dto.num}">UPDATE</button>