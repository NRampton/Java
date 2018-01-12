<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Add a book</title>
</head>
<body>
	<form:form method="POST" action="/books/new" modelAttribute="book">
		<form:label path="title">Title
		<form:errors path="title" />
		<form:input path="title" /></form:label>
		
		<form:label path="description">Description
		<form:errors path="description" />
		<form:input path="description" /></form:label>
		
		<form:label path="language">Language
		<form:errors path="language" />
		<form:input path="language" /></form:label>
		
		<form:label path="numberOfPages">Pages
		<form:errors path="numberOfPages" />
		<form:input path="numberOfPages" /></form:label>
		
		<input type="submit" value="Submit"/>
	</form:form>
</body>
</html>