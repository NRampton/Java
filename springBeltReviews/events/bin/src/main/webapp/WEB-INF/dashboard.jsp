<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Dashboard</title>
		<link rel="stylesheet" type="text/css" href="/css/styles.css">	
		<script src="/js/main.js"></script>
	</head>

	<body>
		<h1>Greetings, ${ user.firstName }</h1>
		<h3>Here are some of the events in your state:</h3>
		<table>
			<thead>
				<tr>
					<th>Name</th>
					<th>Date</th>
					<th>Location</th>
					<th>Host</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${inState}" var="currentEvent">
					<tr>
						<td><a href="/events/${currentEvent.id}">${currentEvent.name}</a></td>
						<td>${currentEvent.date}</td>
						<td>${currentEvent.location}</td>
						<td>${currentEvent.host.firstName}</td>
						<td>
							<c:if test="${currentEvent.host.equals(user)}">
								<a href="/events/${currentEvent.id}/edit">Edit</a>
								<a href="/events/${currentEvent.id}/delete">Delete</a>
							</c:if>
							<c:if test="${!currentEvent.host.equals(user)}">
								<c:set var="check" value="false"></c:set>
								<c:forEach items="${currentEvent.attendees}" var="person">
									<c:if test="${person.id == user.id}">
										<c:set var="check" value="true" />
									</c:if>
								</c:forEach>
								<c:if test="${check}">
									<span>joining</span> <a href="/events/${currentEvent.id}/cancel">Flake out</a>
								</c:if>
								<c:if test="${!check}">
									<a href="/events/${currentEvent.id}/join">Join</a>
								</c:if>
							</c:if>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<h3>Here are some of the events in other states:</h3>
		<table>
			<thead>
				<tr>
					<th>Name</th>
					<th>Date</th>
					<th>Location</th>
					<th>State</th>
					<th>Host</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${outOfState}" var="otherEvent">
					<tr>
							<td><a href="/events/${otherEvent.id}">${otherEvent.name}</a></td>
						<td>${otherEvent.date}</td>
						<td>${otherEvent.location}</td>
						<td>${otherEvent.state}</td>
						<td>${otherEvent.host.firstName}</td>
						<td>
								<c:if test="${otherEvent.host.equals(user)}">
										<a href="/events/${otherEvent.id}/edit">Edit</a>
										<a href="/events/${otherEvent.id}/delete">Delete</a>
									</c:if>
									<c:if test="${!otherEvent.host.equals(user)}">
										<c:set var="check" value="false"></c:set>
										<c:forEach items="${otherEvent.attendees}" var="person">
											<c:if test="${person.id == user.id}">
												<c:set var="check" value="true" />
											</c:if>
										</c:forEach>
										<c:if test="${check}">
											<span>joining</span> <a href="/events/${otherEvent.id}/cancel">Flake out</a>
										</c:if>
										<c:if test="${!check}">
											<a href="/events/${otherEvent.id}/join">Join</a>
										</c:if>
									</c:if>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<h3>Create an event: </h3>
		<form:form method="POST" action="/events" modelAttribute="event">
			<p>
				<form:label path="name">Name: 
					<form:input path="name" />
					<form:errors path="name" />
				</form:label>
			</p>
			<p>
				<form:label path="sDate">Date:
					<form:input path="sDate" type="date" />
					<form:errors path="sDate" />
				</form:label>
			</p>
			<p>
				<form:label path="location">Location: 
					<form:input path="location"></form:input>
					<form:errors path="location"></form:errors>
				</form:label>
				<form:label path="state">State:
					<form:select path="state">
						<form:option value="0" label="select">Select</form:option>
						<form:option value="AL">Alabama</form:option>
						<form:option value="AK">Alaska</form:option>
						<form:option value="AZ">Arizona</form:option>
						<form:option value="AR">Arkansas</form:option>
						<form:option value="CA">California</form:option>
						<form:option value="CO">Colorado</form:option>
						<form:option value="CT">Connecticut</form:option>
						<form:option value="DE">Delaware</form:option>
						<form:option value="DC">District Of Columbia</form:option>
						<form:option value="FL">Florida</form:option>
						<form:option value="GA">Georgia</form:option>
						<form:option value="HI">Hawaii</form:option>
						<form:option value="ID">Idaho</form:option>
						<form:option value="IL">Illinois</form:option>
						<form:option value="IN">Indiana</form:option>
						<form:option value="IA">Iowa</form:option>
						<form:option value="KS">Kansas</form:option>
						<form:option value="KY">Kentucky</form:option>
						<form:option value="LA">Louisiana</form:option>
						<form:option value="ME">Maine</form:option>
						<form:option value="MD">Maryland</form:option>
						<form:option value="MA">Massachusetts</form:option>
						<form:option value="MI">Michigan</form:option>
						<form:option value="MN">Minnesota</form:option>
						<form:option value="MS">Mississippi</form:option>
						<form:option value="MO">Missouri</form:option>
						<form:option value="MT">Montana</form:option>
						<form:option value="NE">Nebraska</form:option>
						<form:option value="NV">Nevada</form:option>
						<form:option value="NH">New Hampshire</form:option>
						<form:option value="NJ">New Jersey</form:option>
						<form:option value="NM">New Mexico</form:option>
						<form:option value="NY">New York</form:option>
						<form:option value="NC">North Carolina</form:option>
						<form:option value="ND">North Dakota</form:option>
						<form:option value="OH">Ohio</form:option>
						<form:option value="OK">Oklahoma</form:option>
						<form:option value="OR">Oregon</form:option>
						<form:option value="PA">Pennsylvania</form:option>
						<form:option value="RI">Rhode Island</form:option>
						<form:option value="SC">South Carolina</form:option>
						<form:option value="SD">South Dakota</form:option>
						<form:option value="TN">Tennessee</form:option>
						<form:option value="TX">Texas</form:option>
						<form:option value="UT">Utah</form:option>
						<form:option value="VT">Vermont</form:option>
						<form:option value="VA">Virginia</form:option>
						<form:option value="WA">Washington</form:option>
						<form:option value="WV">West Virginia</form:option>
						<form:option value="WI">Wisconsin</form:option>
						<form:option value="WY">Wyoming</form:option>
					</form:select>
					<form:errors path="state" />
				</form:label>
			</p>
			<button type="submit">Create</button>
		</form:form>
		<a href="/logout">Logout</a>
	</body>
</html>
