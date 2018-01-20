<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Dashboard</title>
	<link href="/css/styles.css" type="text/css" rel="stylesheet" />
</head>
<body>
	<form id="logoutForm" method="POST" action="/logout">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input id="logout" type="submit" value="Logout!" />
    </form>
	<p>Welcome, ${ currentUser.firstName }!</p>
	<div id="userdisplay">
		<table>
			<tr>
				<td>First Name: </td>
				<td>${ currentUser.firstName }</td>
			</tr>
			<tr>
				<td>Last Name: </td>
				<td>${ currentUser.lastName }</td>
			</tr>
			<tr>
				<td>Email: </td>
				<td>${ currentUser.email }</td>
			</tr>
			<tr>
				<td>Signup Date: </td>
				<td>${ createdAt }</td>
			</tr>
			<tr>
				<td>Last Sign In: </td>
				<td>${ updatedAt }</td>
			</tr>
		</table>
	</div>
	
</body>
</html>