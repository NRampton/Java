<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>A Question</title>
</head>
<body>
	<h1>${ question.text }</h1>
	<h3>Tags: </h3>
	<c:forEach items="${ question.joints }" var="joint">
		<span class="displayTag">${ joint.tag.subject }</span>
	</c:forEach>
	<table>
		<thead>
			<tr>
				<th>Answers</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ question.answers }" var="answer">
				<tr>
					<td>${ answer.text }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<h3>Add your answer:</h3>
	<form method="POST" action="/questions/${ question.id }">
		<label>Answer: <textarea name="response" cols="50" rows="5"></textarea></label>
		<p><button type="submit">Answer it!</button>
	</form>
	<p><a href="/questions">Dashboard</a></p>
</body>
</html>