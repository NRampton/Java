<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>New Question</title>
</head>
<body>
	<h1>What is your question?</h1>
	<form:form method="POST" action="/questions/new" modelAttribute="question">
		<p><form:label path="text">Question:<br>
		<form:errors path="text" />
		<form:textarea cols="100" rows="5" path="text" /> 
		</form:label></p>
		
		<p><label>Tags:
			<input name="tags" />
		</label></p>
		
		<p><c:out value="${ errors }" /></p>
		
		<button type="submit">Submit</button>
	</form:form>
</body>
</html>