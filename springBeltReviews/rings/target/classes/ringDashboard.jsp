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
		<div id="wrapper">
			<a href="/logout">Logout</a>
			<h2>Welcome, ${ currentUser.username }.</h2>
			<div id="upper">
				<p>Welcome to your awesome magical ring finder. Put a ring on; only good things will happen. Maybe it'll make you live forever, or turn you invisible, or turn your inherent hunger for riches and power into an insatiable curse that eventually dooms your entire species.</p>
			</div>
			
			<c:if test="${ currentUser.level > 0 }">
				<div id="admin_links">
					<ul>
						<li><a href="/ring_creator">Ring Creator (Powerful Ainur only)</a></li>
						<li><a href="/team_creator">Aüle's Forge, whence come new children of Illúvatar and likewise are forged the bonds between the same (Powerful Ainur only)</a></li>
					</ul>				
				</div>
			</c:if>
			<div id="rings_display">
				<form action="/rings/claim" method="POST">
					<label for="ring_select">
						<select name="chosenRing" id="ring_select">
							<c:forEach items="${ availableRings }" var="ring">
								<option value="${ring.id}">${ring.name}</option>
							</c:forEach>
						</select>
					</label>
					<button type="submit">BIND YOURSELF IN DARKNESS</button>
					<p class="errors">${ claimError }</p>
				</form>
			</div>
			<table>
				<thead>
					<tr>
						<th>Rings you have found (or stolen)</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${currentUser.bornRings}" var="ring">
						<tr>
							<td>${ring.name}</td>
							<td><a href="/rings/${ring.id}/lose">Part with this ring</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</body>
</html>
