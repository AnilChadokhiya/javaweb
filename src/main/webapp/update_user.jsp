<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>User Details Update</h2>

	<c:set var="up" scope="session" value="${updateUserPojo}" />

	<form action="update" method="post">
		<input type="hidden" name="id" value="${up.id}">
		<table>
			<tr>
				<td>UserName :</td>
				<td><input type="text" name="userName" value="${up.userName}"></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><input type="text" name="password" value="${up.password}"></td>
			</tr>
			<tr>
				<td>First Name :</td>
				<td><input type="text" name="firstName" value="${up.firstName}"></td>
			</tr>
			<tr>
				<td>Last Name :</td>
				<td><input type="text" name="lastName" value="${up.lastName}"></td>
			</tr>
			<tr>
				<td>City :</td>
				<td><input type="text" name="city" value="${up.city}"></td>
			</tr>
			<tr>
				<td>Mobile No :</td>
				<td><input type="text" name="mobileNo" value="${up.mobileNo}"></td>
			</tr>
			<tr>
				<td>Email Id :</td>
				<td><input type="text" name="emailId" value="${up.emailId}"></td>
			</tr>
			<tr>
				<td>Salary :</td>
				<td><input type="text" name="salary" value="${up.salary}"></td>
			</tr>

			<tr>
				<td></td>
			</tr>
			<tr>
				<td><input type="submit" value="Save"></td>
			</tr>
		</table>
	</form>
</body>
</html>