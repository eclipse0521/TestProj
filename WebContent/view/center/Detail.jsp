<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>

<table border="" width ="100%">
<c:set var="dto" value="${data }"/>
	<tr align="center">
		<td>번호</td><td>${dto.id }</td>
		<td>제목</td>	<td>${dto.title }</td>
		<td>조회수</td><td>${dto.cnt }</td>
	</tr>
	<tr>	
		<td>작성자</td><td colspan = "2">${dto.pname }</td>
		<td>작성일</td><td colspan = "2">${dto.regdate }</td>
	</tr>
	<tr>	
		<td>내용</td><td colspan = "5">${dto.content }</td>
	</tr>
	<tr>
		<td colspan="2" align="right">
		<a href="../<%=request.getAttribute("loca")%>/Modify?id=${dto.id }">수정</a>
		</td>
		<td colspan="2" align="right">
		<a href="../<%=request.getAttribute("loca")%>/Remove?id=${dto.id }">삭제</a>
		</td>
		<td colspan="2" align="right">
		<a href="../<%=request.getAttribute("loca")%>/List">목록으로</a>
		</td>
	</tr>

</table>
