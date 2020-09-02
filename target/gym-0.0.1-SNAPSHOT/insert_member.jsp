<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>123 Gym</title>
</head>
<body>
<div align = "center">
<h1>Insert new member...</h1>
<form action = "insertmember" method = "post">
<table>
<tr><td>Name : </td><td><input type = "text" name="name"></td></tr>
<tr><td>Age : </td><td><input type = "number" name="age"></td></tr>
<tr><td>Username : </td><td><input type = "text" name="username"></td></tr>
<tr><td>Password : </td><td><input type = "password" name="password"></td></tr>
<tr><td></td><td><input type = "submit" value = "Add"></td></tr>
</table>

</form>
</div>
</body>
</html>