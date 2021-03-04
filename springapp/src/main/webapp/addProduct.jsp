<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Product Form</h2>
	<form:form modelAttribute="product" action="addProduct.do">
		<form:input path="name"/> <br />
		<form:input path="price" /> <br />
		<form:input path="quantity" /> <br />
		<button type="submit">Add Product</button>
	</form:form>
 
</body>
</html>