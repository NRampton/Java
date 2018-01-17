<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Lookify!</title>
    <link rel="stylesheet" href="/css/styles.css" type="text/css">
</head>
<body>
    <h3>All Songs</h3>
    <div id="nav">
        <a href="songs/new">Add New</a>
        <a href="search/topTen">Top Ten</a>
        <form method="POST" action="/search">
        		<label>Search by artist: <input name="search"/></label> <input type="submit" value="search" />
        </form>
    </div>
    <table>
        <thead>
            <tr>
                <th>Title</th>
                <th>Artist</th>
                <th>Rating</th>
                <th>Actions</th>
            </tr>
            <c:forEach items="${ songs }" var="song" varStatus="loop">
				<tr>
					<td><a href="/songs/${song.id}"><c:out value="${ song.title }"/></a></td>
					<td><c:out value="${ song.artist }"/></td>
					<td><c:out value="${ song.rating }"/></td>
					<td><a href="/songs/delete/${song.id}">Delete</a></td>
				</tr>
			</c:forEach>
        </thead>
    </table>
</body>
</html>