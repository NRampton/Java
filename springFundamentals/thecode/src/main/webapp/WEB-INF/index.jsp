<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>What is the code?</title>
	<style>
		.red {
			color: red;
		}
	</style>
</head>
<body>
	<p class="red"><c:out value="${ errors }" /></p>
	<p>What is the code?</p>
	<form action="/guess" method="POST">
		<input type="text" name="guess"><br>
		<button type="submit">Try Code</button>
	</form>
</body>
</html>