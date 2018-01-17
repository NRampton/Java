<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Register a new license</title>
</head>
<body>
	<h1>New License</h1>
	<form:form method="POST" action="/licenses/new" modelAttribute="license">
		<p><form:label path="person">Name:
		<form:select path="person">
			<form:option value="0" label="Select" />
			<form:options items="${ persons }" itemValue="id" itemLabel="firstName" />
		</form:select>
		</form:label></p>
      	
      	<p><form:label path="state">State:</p>
      	<p><form:input path="state" /></form:label></p>
      	
      	<p><form:label path="expiration_date">Expiration Date:</p>
      	<p><form:input type="date" path="expiration_date" /></form:label></p>
      	
      	<p><input type="submit" value="Add">
	</form:form>
</body>
</html>