<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Register a student</title>
</head>
<body>
	<div id="wrapper">
		<h1>Register a Student</h1>
		<form:form method="POST" action="/students/new" modelAttribute="student">
			<form:label path="school">School: 
				<form:select path="school">
					<form:option value="0" label="Select" />
					<form:options items="${ schools }" itemValue="id" itemLabel="name" />
				</form:select>
			</form:label><br>
			<form:label path="firstName">First Name: <form:input path="firstName" /></form:label><br>
			<form:label path="lastName">Last Name: <form:input path="lastName" /></form:label><br>
			<form:label path="age">Age: <form:input type="number" path="age" /></form:label><br>
			<button type="submit">Register</button>
		</form:form>
	</div>
</body>
</html>