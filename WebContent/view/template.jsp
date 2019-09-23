<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객 센터</title>
</head>
<body>
	<table border="">
		<tr>
			<td>
				<jsp:include page="loca/top.jsp"/>
			</td>
		</tr>
		<tr>
			<td>
				<jsp:include page="center/${mainUrl }.jsp"/>
			</td>
		</tr>
		<tr>
			<td>
				<jsp:include page="loca/bottom.jsp"/>
			</td>
		</tr>
	</table>
</body>
</html>