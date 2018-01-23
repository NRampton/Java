<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Students</title>
</head>
<body>
	<div id="students">
		<h1>Students</h1>
		<c:forEach begin="1" end="${totalPages}" var="index">
			<a href="/students/pages/${index}">${index}</a>
		</c:forEach>
		<table>
			<thead>
				<tr>
					<th>School Name</th>
					<th>Student First Name</th>
					<th>Student Last Name</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${students.content}" var="student">
					<tr>
						<td>${school.name}</td>
						<td>${student.firstName}</td>
						<td>${student.lastName}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>