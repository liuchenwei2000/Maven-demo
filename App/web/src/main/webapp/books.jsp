<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Books</title>
</head>
<body>
<table border="1">
	<thead>
	<tr>
		<th>Title</th>
		<th>Author</th>
		<th>Price</th>
	</tr>
	</thead>
	<c:forEach var="book" items="${books}">
		<tr>
			<td>${book.title}</td>
			<td>${book.author}</td>
			<td>${book.price}</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>