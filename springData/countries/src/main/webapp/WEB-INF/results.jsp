<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Query Results</title>
</head>
<body>
	Here are your results:
	<table>
		<thead>
			<tr>
				<th>Country name</th>
				<th>num of cities</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${results}" var="row">
				<tr>
					<td>${ row[0] }</td>
					<td>${ row[1] }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>