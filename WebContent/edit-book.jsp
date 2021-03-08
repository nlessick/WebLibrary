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
	<form action="editBookervlet" method="post">
	Name: <input type="text" name="name" value="${bookToEdit.name}">
	<input type="hidden" name="id" value="${bookToEdit.id}">
	<input type="submit" value="Save Edited Book">
	</form>

</body>
</html>