<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Search results</title>
</head>	
<body>
	<h3>Search results for "${ term }"</h3>
	<form method="POST" action="/search">
    		<label>Perform a new search: <input name="search"/></label> <input type="submit" value="search" />
    </form>
	<table>
		<thead>
			<tr>
				<th>Title</th>
				<th>Artist</th>
				<th>Rating</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${results}" var="song">
				<tr>
					<td>${ song.title }</td>
					<td>${ song.artist }</td>
					<td>${ song.rating }</td>
					<td><a href="/songs/delete/${ song.id }">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<p><a href="/dashboard">Dashboard</a></p>
</body>
</html>