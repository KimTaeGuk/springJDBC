<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="modify" method="POST">
	<input type="hidden" name="num" value="${dto.num }"/>
	<table border="1">
		<tr>
			<td>제목</td>
			<td><input type="text" name="title" value="${dto.title }"/></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><input type="text" name="content" value="${dto.content }"/></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="전송"/></td>
		</tr>
	</table>
</form>
</body>
</html>