<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<c:set var="dto" value="${data }"/>
<form action="Modi">
	<table border>
		<tr>
			<td colspan="2"><h1>수정</h1></td>
		</tr>
		<input type="hidden" name ="id" value="${dto.id }"/>
		<tr>
			<td>제목</td>
			<td><input type="text" name = "title" value="${dto.title }"/></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><textarea name="content" cols="30" rows="10">${dto.content }</textarea></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="수정" />
				<a href="List">목록으로</a>
			</td> 
		</tr>
	</table>
</form>