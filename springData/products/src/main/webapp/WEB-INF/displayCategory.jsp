<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>${ category.name }</title>
</head>
<body>
	<h2>${ category.name }</h2>
	
	<h4>Products:</h4>
	<c:forEach items="${ category.joints }" var="joint">
		<p><c:out value="${ joint.product.name }" /></p>
	</c:forEach>
	
	<h4>Add a Product:</h4>
	<form:form method="POST" action="/categories/appendProduct/${ category.id }" modelAttribute="product">
		<form:label path="id">
			<form:select path="id">
				<form:option value="0" label="select category" />
				<form:options items="${ availableProducts }" itemValue="id" itemLabel="name" />
			</form:select>
		</form:label>
		<button type="submit">Add Product</button>
	</form:form>
</body>
</html>