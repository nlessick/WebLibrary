<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create a new list</title>
</head>
<body>
	<form action="createNewPublisherServlet" method="post">
	List Name: <input type="text" name="listName"><br />
	Publisher Name: <input type="text" name="name"><br />
	Available Items:<br />
	<select name="allBooksToAdd" multiple size="6">
	<c:forEach items="${requestScope.allBooks}" var="currentitem">
		<option value="${currentitem.id}">${currentitem.title} | ${currentitem.publishDate}</option>
	</c:forEach>
	</select>
	<br />
	<input type="submit" value="Create List and Add Books">
	</form>
<a href="index.html">Insert a new book.</a>
</body>
</html>