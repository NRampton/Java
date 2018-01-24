<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Index</title>
		<link rel="stylesheet" type="text/css" href="/css/styles.css">	
		<script src="/js/main.js"></script>
	</head>

	<body>
		<h1>${event.name}</h1>
		<p>Host: ${event.host.firstName} ${event.host.lastName}</p>
		<p>Date: ${event.date}</p>
		<p>Location: ${event.location}, ${event.state}</p>
		<p>People attending: ${event.attendees.size()}</p>
		<table>
			<thead>
				<th>Name</th>
				<th>Location</th>
			</thead>
			<tbody>
				<c:forEach items="${event.attendees}" var="person">
					<tr>
						<td>${person.firstName} ${person.lastName}</td>
						<td>${person.location}, ${person.state}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<h1>Message Wall</h1>
		<c:forEach items="${event.comments}" var="comment">
			<p>${comment.poster.firstName} ${comment.poster.lastName}: ${comment.text}</p>
			<hr>
		</c:forEach>
		<form:form method="POST" action="/events/${event.id}/message" modelAttribute="message">
			<p>Add comment:</p>
			<form:textarea rows="4" cols="40" path="text"></form:textarea>
			<form:errors path="text" />
			<button type="submit">Submit</button>
		</form:form>
		<a href="/">Home</a>
		<a href="/logout">Logout</a>
	</body>
</html>
