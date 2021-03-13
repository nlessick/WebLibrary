<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Publishers</title>
</head>
<body>
	<form method="post" action="listnavigationServlet">
	<table>
	<c:forEach items="${requestScope.allBooks}" var="currentlist">
	<tr>
		<td><input type="radio" name="id" value="${currentlist.Id}"></td>
		<td><h2>${currentlist.title}</h2></td></tr>
		<tr><td colspan="3">Publisher: ${currentlist.name}</td></tr>
		<c:forEach var="listVal" items="${currentlist.listOfBooks}">
		<tr><td></td><td colspan="3"> ${listVal.title}, ${listVal.publishDate}
		</td>
		</tr>
		</c:forEach>
	</c:forEach>
	</table>
<input type="submit" value="edit" name="doThisToList">
<input type="submit" value="delete" name="doThisToList">
<input type="submit" value="add" name="doThisToList">
</form>
<a href="index.html">Insert a new book</a>
</body>
</html>