<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>WaterBnB</title>
		<link rel="stylesheet" type="text/css" href="/css/styles.css">	
		<script src="/js/main.js"></script>
	</head>

	<body>
		<h3>Your Current Listings</h3>
		<p><a href="/logout">Logout</a></p>
		<p><a href="/">Search other listings</a></p>
		<table>
			<thead>
				<tr>
					<th>Address</th>
					<th>Pool Size</th>
					<th>Cost / Night</th>
					<th>Details</th>
					<th>Remove listing</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${currentUser.properties}" var="pool">
					<tr>
						<td>${pool.address}</td>
						<td>${pool.size}</td>
						<td>${pool.cost}</td>
						<td><a href="/host/pools/${pool.id}">${pool.rating} - edit</a></td>
						<td><a href="/pools/delete/${pool.id}">Remove</a>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<h3>New Listing</h3>
		<form:form method="POST" action="/pools/new" modelAttribute="pool">
			<p>
				<form:label path="address">Address: 
					<form:input path="address"></form:input>
					<form:errors path="address"></form:errors>
				</form:label>
			</p>
			<p>
				<form:label path="description">Description: 
					<form:textarea path="description"></form:textarea>
					<form:errors path="description"></form:errors>
				</form:label>
			</p>
			<p>
				<form:label path="cost">Cost: 
					<form:input path="cost" type="number" step="25"></form:input>
					<form:errors path="cost"></form:errors>
				</form:label>
			</p>
			<p>
				<form:select path="size">Size: 
					<form:option value="small" label="small"></form:option>
					<form:option value="medium" label="medium"></form:option>
					<form:option value="large" label="large"></form:option>
				</form:select>
			</p>
			<button type="submit">Add Listing</button>
		</form:form>
	</body>
</html>
