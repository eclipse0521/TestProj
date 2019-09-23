<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>

<table border="" width ="100%">
	<tr align="center">
		<td>번호</td>
		<td>제목</td>
		<td>작성자</td>
		<td>작성일</td>
		<td>조회수</td>
	</tr>
<c:forEach var="dto" items="${data }">
	<tr>
		<td>${dto.id }</td>
		<td><a href="Detail?id=${dto.id }">${dto.title }</a></td>
		<td>${dto.pname }</td>
		<td>${dto.regdate }</td>
		<td>${dto.cnt }</td>
	</tr>
</c:forEach>
	<tr>
		<td colspan="5" align="right">
			<a href="Write">작성</a>
		</td> 
	</tr>
</table>