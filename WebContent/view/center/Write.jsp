<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>

<form action="WriteIn">
	<table border>
		<tr>
			<td colspan="2"><h1>작성</h1></td>
		</tr>
		<tr>
			<td>제목</td>
			<td><input type="text" name = "title"/></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><textarea name="content" cols="30" rows="10"></textarea></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="작성" />
				<a href="List">목록으로</a>
			</td> 
		</tr>
	</table>
</form>