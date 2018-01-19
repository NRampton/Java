<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Question Dashboard</title>
</head>
<body>
	<h1>Questions Dashboard</h1>
	<table>
		<thead>
			<tr>
				<th>Question</th>
				<th>Tags</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ questions }" var="question">
				<tr>
					<td><a href="/questions/${ question.id }">${ question.text }</a></td>
					<td>
						<c:forEach items="${ question.joints }" var="joint">
							<span class="dashboardTag">${ joint.tag.subject }</span>
						</c:forEach>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<p><a href="/questions/new">New Question</a></p>
</body>
</html>