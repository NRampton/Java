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
		<div id="wrapper">
		<h4>${ pool.address }</h4>
			<form:form method="POST" action="/pools/new" modelAttribute="pool">
				<div class="pool_display_header">					
					<p>
						<form:label path="description">Description: 
							<form:textarea rows="5" cols="40" path="description"></form:textarea>
							<form:errors path="description"></form:errors>
						</form:label>
					</p>
					<form:hidden path="id" value="${ pool.id }" />
					<form:hidden path="address" value="${ pool.address }"/>
					<button type="submit">Update Listing</button>
				</div>
				<div class="pool_display_header">
					<p>Email: ${ pool.host.email }</p>
					<p>Name: ${ pool.host.firstName } ${ pool.host.lastName }</p>
					<p>Size: 
						<form:select path="size"> 
							<form:option value="small" label="small"></form:option>
							<form:option value="medium" label="medium"></form:option>
							<form:option value="large" label="large"></form:option>
						</form:select>
					</p>
					<p>
						<form:label path="cost">Cost: 
							<form:input path="cost" type="number" step="25"></form:input>
							<form:errors path="cost"></form:errors>
						</form:label>
					</p>				
				</div>			
			</form:form>
		</div>
	</body>
</html>
