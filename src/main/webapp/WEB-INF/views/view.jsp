<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>이름</td>
			<td>${dto.id }</td>
		</tr>
		<tr>
			<td>제목</td>
			<td>${dto.title }</td>
		</tr>
		<tr>
			<td>내용</td>
			<td>${dto.content }</td>
		</tr>
		<tr>
			<td>조회수</td>
			<td>${dto.count }</td>
		</tr>
		<tr>
			<td><a href="delete?num=${dto.num}">삭제</a></td>
			<td><a href="modifyView?num=${dto.num }">수정</a></td>
		</tr>
	</table>
</body>
</html>