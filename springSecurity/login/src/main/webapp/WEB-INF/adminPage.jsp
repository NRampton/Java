<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Admin Dashboard</title>
</head>
<body>
	<form id="logoutForm" method="POST" action="/logout">
	    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	    <input type="submit" value="Logout!" />
	</form>
	<h1>Welcome ${ currentUser.firstName }</h1>
	<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Email</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ users }" var="user">
				<tr>
					<td>${ user.firstName } ${ user.lastName }</td>
					<td>${ user.email }</td>
					<td>
						<c:set var="checker" value="false" />
						<c:forEach items="${ user.roles }" var="role">
							<c:if test="${ role.name.equals('ROLE_ADMIN') }"> test="${ join.userj_id == currentUser.id }
								<c:set var="checker" value="true" />
							</c:if>
						</c:forEach>
						<c:if test="${ checker.equals('true')}">
							admin
						</c:if>
						<c:if test="${ !checker.equals('true')}">
							<a href="/your_server/admin/deleteUser/${ user.id }">Delete</a>
							<a href="/your_server/admin/makeAdmin/${ user.id }">make-admin</a>
						</c:if>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>