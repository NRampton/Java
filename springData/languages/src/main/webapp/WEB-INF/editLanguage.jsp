<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit <c:out value="${ language.name }" /></title>
</head>
<body>
	<form:form method="POST" action="/languages/edit/${ id }" modelAttribute="language">
		<form:label path="name">Name
		<form:errors path="name" />
		<form:input path="name" /></form:label>
		
		<form:label path="creator">Creator
		<form:errors path="creator" />
		<form:input path="creator" /></form:label>
		
		<form:label path="version">Current Version
		<form:errors path="version" />
		<form:input path="version" /></form:label>
		
		<input type="submit" value="Update"/>
	</form:form>
<p><a href="/languages">Go Back</a></p>
</body>
</html>