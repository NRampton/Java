<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>${ product.name }</title>
</head>
<body>
	<h2>${ product.name }</h2>
	<p>-${ product.description }</p>
	<p>-$${ product.price }</p>
	
	<h4>Categories:</h4>
	<c:forEach items="${ product.joints }" var="joint">
		<p><c:out value="${ joint.category.name }" /></p>
	</c:forEach>
	
	<h4>Add a Category:</h4>
	<form:form method="POST" action="/products/appendCategory/${ product.id }" modelAttribute="category">
		<form:label path="id">
			<form:select path="id">
				<form:option value="0" label="select category" />
				<form:options items="${ availableCategories }" itemValue="id" itemLabel="name" />
			</form:select>
		</form:label>
		<button type="submit">Add Category</button>
	</form:form>
</body>
</html>