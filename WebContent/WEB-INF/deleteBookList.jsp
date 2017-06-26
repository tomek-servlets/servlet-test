<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Choose Books to be deleted</title>
</head>
<body>
	<h1>Choose Books to be deleted</h1>
	<hr>
	<c:choose>
		<c:when test="${bookList == null or bookList.isEmpty()}">
		    The List is empty.
		</c:when>
		<c:otherwise>
			<form action="DeleteBooks">
				<table border=1>

					<tr>
						<th>Title</th>
						<th>Description</th>
						<th>Price</th>
						<th>Delete</th>
					</tr>
					<c:forEach var="book" items="${bookList}">
						<tr>
							<td>${book.title}</td>
							<td>${book.description}</td>
							<td>${book.price}</td>
							<td><input type="checkbox" name="${book.id}"></td>
						</tr>
					</c:forEach>
				</table>
				<input type="submit" value="Delete selected books">
			</form>
		</c:otherwise>
	</c:choose>
	<hr>
	<a href='index.html'>Main Page</a>
	<br>



</body>
</html>