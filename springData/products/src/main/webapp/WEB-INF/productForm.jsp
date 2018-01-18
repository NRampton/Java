<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Create a product entry</title>
</head>
<body>
	<h1>New Product</h1>
	<form:form method="POST" action="/products/new" modelAttribute="product">
		<form:label path="name">Name: <form:input path="name" /></form:label><br><br>
		<form:label path="description"> Description: <form:textarea path="description" cols="12" rows="3" /></form:label><br><br>
		<form:label path="price">Price: $ <form:input path="price" type="number" step="0.01" style="width: 50px"/></form:label><br><br>
		<button type="submit">Create</button>
	</form:form>
</body>
</html>