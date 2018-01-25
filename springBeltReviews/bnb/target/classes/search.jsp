<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>WaterBnB</title>
		<link rel="stylesheet" type="text/css" href="/css/styles.css">	
		<script src="/js/main.js"></script>
	</head>

	<body>
		<div id="wrapper" >
			<c:if test="${ currentUser == null }">
				<a id="signin" href="/guest/signin">Login/Sign up</a>
			</c:if>
			<c:if test="${ currentUser != null }">
				<a id="logout" href="/logout">Log out</a>
			</c:if>
			<h1>Search</h1>
			<form method="GET" action="/search">
				<label>Search: <input type="text" name="location" placeholder="location" /></label>
				<button type="submit">Search</button>
			</form>
		</div>
	</body>
</html>
