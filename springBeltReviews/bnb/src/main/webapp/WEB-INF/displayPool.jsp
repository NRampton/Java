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
			<p><a href="/">Go back</a></p>
			<p><a href="/logout">Logout</a></p>
			<h4>${ currentPool.address }</h4>
			<div class="pool_display_header">
				<p>${ currentPool.description }</p>
			</div>
			<div class="pool_display_header">
				<p>Email: ${ currentPool.host.email }</p>
				<p>Name: ${ currentPool.host.firstName } ${ currentPool.host.lastName }</p>
				<p>Pool Size: ${ currentPool.size }</p>
				<p>Cost per Night: $${ currentPool.cost }</p>
			</div>
			<div id="showReviews">
				<p>Reviews: (${ currentPool.rating }/5)</p>
				<div id="display">
					<c:forEach items="${ currentPool.reviews }" var="review">
						<p>${review.reviewer.firstName} ${review.reviewer.lastName}:</p>
						<p>Rating: ${ review.rating}</p>
						<p class="review_text">${ review.text }</p>
						<hr>
					</c:forEach>
				</div>
				<p>
					<c:choose>
						<c:when test="${ currentUser != null && currentUser != currentPool.host}">
							<a class="right" href="/pools/${ currentPool.id}/review">Leave a review</a>
						</c:when>
						<c:when test="${ currentUser == null}">
							<span class="right">You must <a href="/guest/signin">sign in</a> to leave a review.</span>
						</c:when>
						<c:when test="${ currentUser != null && currentUser == currentPool.host}">
							<span>(You can't leave a review on your own pool. Go find someone else's pool if you want to leave a review.)</span>
						</c:when>
					</c:choose>
				</p>
			</div>
		</div>
	</body>
</html>
