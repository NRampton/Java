<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>A table of books</title>
</head>
<body>
	<table class="table">
		<c:forEach items="${books}" var="book" varStatus="loop">
		    <tr>    
			    <td><c:out value="${book.title}"/></td>
			    <td><c:out value="${book.description}"/></td>
			    <td><c:out value="${book.language}"/></td>
			    <td><c:out value="${book.numberOfPages}"/></td>
			    <td><c:out value="${book.id}" /></td>
			    <td><a href="/books/delete/${book.id}">Delete</a></td>
			    <td><a href="/books/edit/${book.id}">Edit</a></td>
    			</tr>
		</c:forEach>
	</table>
</body>
</html>