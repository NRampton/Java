<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link type="text/css" rel="stylesheet" href="css/styles.css">
	<title>Time to do some coding</title>
</head>
<body>
	<div id="wrapper">
		<h1>Fortran!</h1>
		<div id="nav">
			<a href="/your_server/m/38/0553/0733">Set Up</a>
			<a href="/your_server/m/38/0483/0345">Forms</a>
			<a href="/your_server/m/38/0553/0342">Cards</a>
			<a href="/your_server/m/26/0553/0348">Advanced</a>
			<a href="/your_server/m/26/0483/2342">Binary</a>
		</div>
		<input type="checkbox" name="done">Assignment Completed
		<p><c:out value="${placeholder}" /></p>
	</div>
</body>
</html>