<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> --%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h2>Signup</h2>

	<form action="signup" method="post">
		<table>
			<tr>
				<td>UserName :</td>
				<td><input type="text" name="userName"></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><input type="text" name="password"></td>
			</tr>
			<tr>
				<td>First Name :</td>
				<td><input type="text" name="firstName"></td>
			</tr>
			<tr>
				<td>Last Name :</td>
				<td><input type="text" name="lastName"></td>
			</tr>
			<tr>
				<td>City :</td>
				<td><input type="text" name="city"></td>
			</tr>
			<tr>
				<td>Mobile No :</td>
				<td><input type="text" name="mobileNo"></td>
			</tr>
			<tr>
				<td>Email Id :</td>
				<td><input type="text" name="emailId"></td>
			</tr>
			<tr>
				<td>Salary :</td>
				<td><input type="text" name="salary"></td>
			</tr>

			<tr>
				<td></td>
			</tr>
			<tr>
				<td><input type="submit" value="Save"></td>
			</tr>
		</table>
	</form>

	<form action="login" method="get">
		<input type="submit" value="Login">
	</form>

</body>
</html>