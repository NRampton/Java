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
				<div class="pool_display_header">
					<h4>${ currentPool.address }</h4>
					<p>${ currentPool.description }</p>
				</div>
				<div class="pool_display_header">
					<p>Email: ${ currentPool.host.email }</p>
					<p>Name: ${ currentPool.host.firstName } ${ currentPool.host.lastName }</p>
					<p>Pool Size: ${ currentPool.size }</p>
					<p>Cost per Night: $${ currentPool.cost }</p>
				</div>
				<div id="showReviews">
					<p>
						<span>Reviews (${ pool.rating }</span>
						<c:if test="${ currentUser != null}">
							<a class="right" href="/pools/${ pool.id}/review">Leave a review</a>
						</c:if>
						<c:if test="${ currentUser == null">
							<span class="right">You must <a href="/guest/signin">sign in</a> to leave a review.</span>
						</c:if>
					</p>
					<div id="display">
						<c:forEach items="${ pool.reviews }" var="review">
							<p>${review.reviewer.firstName} ${review.reviewer.lastName}</p>
							<p></p>
							<p class="review_text"></p>
							<hr>
						</c:forEach>
					</div>
				</div>
		</div>
	</body>
</html>
