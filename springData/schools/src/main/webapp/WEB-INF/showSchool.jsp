<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>School Page</title>
</head>
<body>
	<h1>${ school.name } Location Students</h1>
	<table>
		<thead>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Age</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${ school.students }" var="student">
			<tr>
				<td><c:out value="${ student.firstName }" /></td>
				<td><c:out value="${ student.lastName }" /></td>
				<td><c:out value="${ student.age }" /></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</body>
</html>