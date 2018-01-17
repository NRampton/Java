<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add a new person</title>
</head>
<body>
	<h1>New Person</h1>
	<form:form method="POST" action="/persons/new" modelAttribute="person">
		<p><form:label path="firstName">First Name:</p>
      	<p><form:input path="firstName" /></form:label></p>
      	
      	<p><form:label path="lastName">Last Name:</p>
      	<p><form:input path="lastName" /></form:label></p>
      	
      	<p><input type="submit" value="Add">
	</form:form>
</body>
</html>