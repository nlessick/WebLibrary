<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book List</title>
</head>
<body>
<form method="post" action="navigationServlet">
<table>
<c:forEach items="${requestScope.allBooks}" var="currentbook">
<tr>
	<td><input type="radio" name="id" value="${currentbook.id}"></td>
	<td>${currentbook.title}</td>
	<td>${currentbook.publishDate}</td>
</tr>
</c:forEach>
</table>
<input type="submit" value="edit" name="doThisToBook">
<input type="submit" value="delete" name="doThisToBook">
<input type="submit" value="add" name="doThisToBook">
</form>
<a href="index.html">Insert a new book</a><br />
<a href="addBooksForListServlet">Add a publisher</a>
</body>
</html>