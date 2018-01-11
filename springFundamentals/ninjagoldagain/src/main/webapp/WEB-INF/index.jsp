<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList" %>
<%@ taglib prefix ="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Be a greedy ninja!</title>
	<link type="text/css" rel="stylesheet" href="css/styles.css">
</head>
<body>
    <div id="wrapper">
        <h3>Your Gold: <span id="golden"><c:out value="${gold}" /></span></h3>
        <form id="reset" action="/reset" method="POST">
        		<button type="submit">Reset game</button>
        </form>
        <div id="locations_band">
	        <div class="location">
	            <h3>Farm</h3>
	            <h4>(earns 10–20 gold)</h4>
	            <form action="/process" method="POST">
	                <input type="hidden" name="location" value="farm">
	                <button type="submit">Be a farming ninja</button>
	            </form>
	        </div>
	        <div class="location">
	            <h3>Cave</h3>
	            <h4>(earns 5–10 gold)</h4>
	            <form action="/process" method="POST">
	                <input type="hidden" name="location" value="cave">
	                <button type="submit">Be a spelunking ninja</button>
	            </form>
	        </div>
	        <div class="location">
	            <h3>House</h3>
	            <h4>(earns 2–5 gold)</h4>
	            <form action="/process" method="POST">
	                <input type="hidden" name="location" value="house">
	                <button type="submit">Be a homebody ninja</button>
	            </form>
	        </div>
	        <div class="location">
	            <h3>Casino</h3>
	            <h4>(gains/loses 0-50 gold)</h4>
	            <form action="/process" method="POST">
	                <input type="hidden" name="location" value="casino">
	                <button type="submit">Be a gambling ninja</button>
	            </form>
	        </div>
	    </div>
        <h3>Activities:</h3>
        <div id="log">
        <% ArrayList<String> log = (ArrayList<String>) session.getAttribute("log"); %>
        <% for ( String entry : log.toArray(new String[log.size()])) { %>
        <p><%= entry %></p>
        <% } %>
        </div>
    </div>
</body>
</html>