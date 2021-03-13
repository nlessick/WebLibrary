<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit An Existing List</title>
</head>
<body>
	<form action="editBookDetailsServlet" method="post">
	<input type="hidden" name="id" value="${listToEdit.id}">
	List Name: <input type="text" name="listName" value="${listToEdit.listName}"><br />
	Publisher Name: <input type="text" name="name" value="${listToEdit.publisher}"><br />
	Available Books:<br />
	<select name="allBooksToAdd" multiple size="6">
	<c:forEach items="${requestScope.allBooks}" var="currentitem">
	<option value="${currentitem.id}">${currentitem.title} | ${currentitem.publishDate}</option>
	</c:forEach>
	</select>
	<br />
	<input type="submit" value="Edit List and Add Books">
	</form>
<a href="index.html">Go to home page.</a>
</body>
</html>