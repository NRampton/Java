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
		<p><a href="/">Go back</a></p>
		<c:if test="${ currentUser != null }">
			<p><a href="/logout">Logout</a></p>
		</c:if>
		<h5>Find your pool!</h5>
		<form method="GET" action="/search">
			<p><input type="text" name="location" placeholder="new search" /></p>
			<button type="submit">Search</button>
		</form>
		<table>
			<thead>
				<tr>
					<th>Address</th>
					<th>Pool Size</th>
					<th>Cost/Night</th>
					<th>Details</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${results}" var="pool">
					<tr>
						<td>${ pool.address}</td>
						<td>${ pool.size }</td>
						<td>${ pool.cost }</td>
						<td><a href="/pools/${pool.id}">${ pool.rating} - See more</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</body>
</html>
