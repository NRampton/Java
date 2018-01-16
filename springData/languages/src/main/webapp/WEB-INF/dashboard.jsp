<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Languages</title>
</head>
<body>
	<h1>Languages</h1>
	<table>
		<thead>
			<tr>
				<th>Language</th>
				<th>Creator</th>
				<th>Current Version</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ languages }" var="language" varStatus="loop">
				<tr>
					<td><a href="/languages/${language.id}"><c:out value="${ language.name }"/></a></td>
					<td><c:out value="${ language.creator }"/></td>
					<td><c:out value="${ language.version }"/></td>
					<td><a href="/languages/edit/${language.id}">Edit</a> <a href="/languages/delete/${language.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<h2>Add a language:</h2>
	<form:form method="POST" action="/languages/new" modelAttribute="language">
		<form:label path="name">Name
		<form:errors path="name" />
		<form:input path="name" /></form:label>
		
		<form:label path="creator">Creator
		<form:errors path="creator" />
		<form:input path="creator" /></form:label>
		
		<form:label path="version">Current Version
		<form:errors path="version" />
		<form:input path="version" /></form:label>
		
		<input type="submit" value="Add"/>
	</form:form>
</body>
</html>