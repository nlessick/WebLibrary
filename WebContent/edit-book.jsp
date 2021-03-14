<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Book</title>
</head>
<body>
	<form action="editBookServlet" method="post">
	<input type="hidden" name="id" value="${bookToEdit.id}">
	Title: <input type="text" name="title" value="${bookToEdit.title}">
	Publish date: <input type="text" name="month" placeholder="mm" size="4" value="${month}">
	<input type="text" name="day" placeholder="dd" size="4" value="${day}"> <input type="text" name="year" placeholder="yyyy" size="4" value="${year}">
	<input type="submit" value="Save Edited Book">
	</form>

</body>
</html>