<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<style>
table, th, td {
	border: 1px solid black;
}
</style>
<title>Insert title here</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<td>User Name</td>
				<td>First Name</td>
				<td>Last Name</td>
				<td>City</td>
				<td>Salary</td>
				<td>Mobile No</td>
				<td>Email ID</td>
				<td>Update</td>
				<td>Delete</td>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${userList}" var="us">
				<tr>
					<td><c:out value="${us.userName}"></c:out></td>
					<td><c:out value="${us.firstName}"></c:out></td>
					<td><c:out value="${us.lastName}"></c:out></td>
					<td><c:out value="${us.city}"></c:out></td>
					<td><c:out value="${us.salary}"></c:out></td>
					<td><c:out value="${us.mobileNo}"></c:out></td>
					<td><c:out value="${us.emailId}"></c:out></td>
					<td>
						<form action="update" method="get">
							<input type="hidden" name="id" value="${us.id}"> <input
								type="submit" value="Edit">
						</form>
					</td>
					<td>
						<form action="delete_user" method="post">
							<input type="hidden" name="id" value="${us.id}"> <input
								type="submit" value="Delete">
						</form>
					</td>

				</tr>
			</c:forEach>
		</tbody>
	</table>

	<form action="signup">
		<input type="submit" value="Signup">
	</form>
</body>
</html>