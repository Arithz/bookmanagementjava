<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<title>Insert new title here</title>
<body>
    
	<h3>Update Book</h3>
	<form method="POST" name="update" action="updatebook">
	
		<input name="id" hidden = "hidden" value="${book.id}" type="text" /> 
		<br>
		Book Name: <input name="name" value="${book.name}" type="text" />
		<br />
		Book Author: <input name="author" value="${book.author}" type="text" /> 
		<br />
		Book Number: <input name="number" value="${book.number}" type="text" /><br />
		<br /> <input value="Update Book" type="submit" />
	</form>
	
</body>
</html>