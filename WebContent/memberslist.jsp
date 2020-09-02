<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<div align="center">
<title>123 Gym</title>
</head>
<body>
	<center>
		<h1>Member Management</h1>
		<h2>
			<a href="new">Add New Member</a>
			 &nbsp;&nbsp;&nbsp; 
			 <a href="list">List
				All Members</a>

		</h2>
	</center>
	<div align="center">
		<table border="1" cellpadding="5">
			<caption>
				<h2>List of Members</h2>
			</caption>
			<tr>
				<th>Username</th>
				<th>Name</th>
				<th>Age</th>
			</tr>
			<c:forEach var="members" items="${listMember}">
				<tr>
					<td><c:out value="${members.username}" /></td>
					<td><c:out value="${members.name}" /></td>
					<td><c:out value="${members.age}" /></td>
					<td><a
						href="edit?username=<c:out value='${members.username}' />">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="delete?username=<c:out value='${members.username}' />">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	</div>
</body>
</html>