<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Index</title>
		<link rel="stylesheet" type="text/css" href="/css/styles.css">	
		<script src="/js/main.js"></script>
	</head>

	<body>
		<c:if test="${employee.employees.size() == 0 && employee.manager != null}">	<!-- assuming employee is not a manager--they have no employees and they do have a manager -->
			<h4>${ employee.first_name } ${ employee.last_name } is a regular old employee. They work under ${ employee.manager.first_name } ${ employee.manager.last_name }</h4>
		</c:if>
		<c:if test="${employee.employees.size() > 0}">				<!-- assuming employee is a manager, since they have employees -->
			<h4>${ employee.first_name } ${ employee.last_name } is a manager. Their employees are as follows:</h4>
			<c:forEach items="${employee.employees}" var="employee">
				<p>${ employee.first_name } ${ employee.last_name }</p>		<!-- still need to add a form to add an employee to this manager -->
			</c:forEach>
		</c:if>
		<c:if test="${employee.employees.size() == 0 && employee.manager == null}">		<!-- if employee is not yet a manager and does not have a manager -->
			<h4>${ employee.first_name } ${ employee.last_name } is not a manager and has no manager. What shall we do about that?</h4>
			<h5>Make them a manager by giving them an underling:</h5>
				<form method="POST" action="/addUnderling" modelAttribute="underling"> <!-- working out the form for adding an underling. -->
				
			<p>
			<h5>Make them an underling by giving them a manager:</h5>
		</c:if>
	</body>
</html>
