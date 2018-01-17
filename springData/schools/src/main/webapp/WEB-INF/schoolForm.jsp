<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Register a school</title>
	<link href="/css/styles.css" rel="stylesheet">
</head>
<body>
	<div id="wrapper">
		<h1>New School</h1>
		<form:form method="POST" action="/schools/new" modelAttribute="school">
			<form:label path="name">Name: <form:input path="name" /></form:label><br>
			<button type="submit">Register</button>
		</form:form>
	</div>
</body>
</html>