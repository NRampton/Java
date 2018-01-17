<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>${ song.title }</title>
</head>
<body>
	<a href="/dashboard">Dashboard</a>
	<table>
		<tbody>
			<tr>
				<td>Title</td>
				<td>${ song.title }</td>
			</tr>
			<tr>
				<td>Artist</td>
				<td>${ song.artist }</td>
			</tr>
			<tr>
				<td>Rating</td>
				<td>${ song.rating }</td>
			</tr>
		</tbody>
	</table>
	<a href="/songs/delete/${song.id}">Delete</a>
</body>
</html>