<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Lookify!</title>
    <link rel="stylesheet" href="/css/styles.css" type="text/css">
</head>
<body>
    <h2>Add a song:</h2>
    <form:form method="POST" action="/songs/new" modelAttribute="song">
      <p><form:label path="title">Title</p>
      <p><form:input path="title" /> <span class="error"><form:errors path="title" /></span></form:label></p>
      
      <p><form:label path="artist">Artist</p>
      <p><form:input path="artist" /> <span class="error"><form:errors path="artist" /></span></form:label></p>
      
      <p><form:label path="rating">Rating</p>
      <p><form:input path="rating" /> <span class="error"><form:errors path="rating" /></span></form:label></p>
      <br>
      <input type="submit" value="Add"/>
    </form:form>
</body>
</html>