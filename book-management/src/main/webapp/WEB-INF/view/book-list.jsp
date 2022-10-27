<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<script>
function deletealert(id) {
	if(confirm("Are you sure you want to delete this book?")) {
		location.href = "deletebook/"+id;
	}
}
</script>
<body>
	<h1>Books List</h1>
	<br>
	<table border="2" width="70%" cellpadding="2">
		<tr>
			<th>Book Id</th>
			<th>Book Name</th>
			<th>Book Author</th>
			<th>Book Number</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<c:forEach items="${books}" var="item">
			<tr align="center">
				<td>${item.id}</td>
				<td>${item.name}</td>
				<td>${item.author}</td>
				<td>${item.number}</td>
				<td><a href="<%=request.getContextPath()%>/editbook/${item.id}">Edit</a></td>
				<td><button id="${item.id}" onclick="deletealert(this.id)">Delete</button></td>
			</tr>
		</c:forEach>
	</table>

	<br />
	<a href="bookform">Add New Book</a>
</body>
</html>