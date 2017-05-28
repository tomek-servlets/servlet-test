<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Change the price</title>
</head>
<body>
	<hr>
	<c:choose>
		<c:when test="${bookList == null or bookList.isEmpty()}">
		    The List is empty.
		</c:when>
		<c:otherwise>
			<h1>Choose a product to change the price:</h1>
			<table border=1>

				<tr>
					<th>Title</th>
					<th>Description</th>
					<th>Price</th>
					<th>New Price</th>
				</tr>
				<c:forEach var="book" items="${bookList}">
					<tr>
						<td>${book.title}</td>
						<td>${book.description}</td>
						<td>${book.price}</td>
						<td>
							<form action="ChangeOnePrice" method="post">
								<input type="hidden" name="id" value="${book.id}"> 
								<input type="text" name="newPrice"><br>
								<input type="submit" value="Change price">
							</form>
						</td>
					</tr>
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>
	<hr>
	<a href='index.html'>Main Page</a>
	<br>
</body>
</html>