<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Create a product category</title>
</head>
<body>
	<h1>New Category</h1>
	<form method="POST" action="/categories/new">
		<label>Name: <input type="text" name="name"/></label><br><br>
		<button type="submit">Create</button>
	</form>
</body>
</html>