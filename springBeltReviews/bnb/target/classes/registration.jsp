<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Register</title>
		<link rel="stylesheet" type="text/css" href="/css/styles.css">	
		<script src="/js/main.js"></script>
	</head>

	<body>
		<div id="wrapper">
			<h2 id="motto">WaterBnB. Swim and sleep. Just not at the same time.</h2>
			<div id="register">
				<h3>Register as a new user!</h3>
				<form:form action="/register" method="POST" modelAttribute="user">
					<p>
						<form:label path="firstName">First Name: 
							<form:input path="firstName"></form:input>
							<form:errors path="firstName"></form:errors>
						</form:label>
					</p>
					<p>
						<form:label path="lastName">Last Name: 
							<form:input path="lastName"></form:input>
							<form:errors path="lastName"></form:errors>
						</form:label>
					</p>
					<p>
						<form:label path="email">Email: 
							<form:input path="email"></form:input>
							<form:errors path="email"></form:errors>
						</form:label>
					</p>
					<p>
						<form:label path="password">Password: 
							<form:input type="password" path="password"></form:input>
							<form:errors path="password"></form:errors>
						</form:label>
					</p>
					<p>
						<form:label path="confirm">Confirm password: 
							<form:input type="password" path="confirm"></form:input>
							<p><form:errors path="confirm"></form:errors></p>
						</form:label>
					</p>
					<p>
						<form:label path="level">Register as: 
							<form:select path="level">
								<form:option value="0" label="Guest" />
								<form:option value="1" label="Host" />
							</form:select>
						</form:label>
					</p>
					<button type="submit">Register</button>
				</form:form>
			</div>
			<div id="login">
				<h3>Login:</h3>
				<c:forEach items="${errors}" var="error">
					<p>${error}</p>
				</c:forEach>
				<form method="POST" action="/login">
					<p><label>Email: <input type="text" name="email"></label></p>
					<p><label>Password: <input type="password" name="password"></label></p>
					<p><button type="submit">Login</button></p>
				</form>
			</div>
		</div>
	</body>
</html>
