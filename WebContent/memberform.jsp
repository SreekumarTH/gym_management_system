<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>123 Gym</title>
</head>
<body>
	<div style="text-align: center">
		<h1>Member Management</h1>
		<h2>
			<a href="new">Add New Member</a>
			 &nbsp;&nbsp;&nbsp; 
			 <a href="list">List All Members</a>

		</h2>
	</div>
	<div align="center">
		<c:if test="${member != null}">
			<form action="update" method="post">
		</c:if>
		<c:if test="${member == null}">
			<form action="insert" method="post">
		</c:if>
		<table border="1" cellpadding="5">
			<caption>
				<h2>
					<c:if test="${member != null}">
            			Edit Member
            		</c:if>
					<c:if test="${member == null}">
            			Add New Member
            		</c:if>
				</h2>
			</caption>
			<c:if test="${member != null}">
				<input type="hidden" name="username"
					value="<c:out value='${member.username}' />" />
			</c:if>
			<tr>
			<tr>
				<th>Username </th>
				<td><input type="text" name="username" size="45"
					value="<c:out value='${member.username}' />" /></td>
			</tr>
			<tr>
				<th>Password </th>
				<td><input type="text" name="password" size="45"
					value="<c:out value='${member.password}' />" /></td>
			</tr>
				<th>Name </th>
				<td><input type="text" name="name" size="45"
					value="<c:out value='${member.name}' />" /></td>
			</tr>
			<tr>
				<th>Age  </th>
				<td><input type="text" name="age" size="45"
					value="<c:out value='${member.age}' />" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Save" /></td>
			</tr>
		</table>
		</form>
	</div>
</body>
</html>