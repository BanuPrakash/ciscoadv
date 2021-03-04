<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
	.error {
		color:red
	}
</style>
</head>
<body>
	<h2>Product Form</h2>
	<form:errors path="*" />
	<form:form modelAttribute="product" action="addProduct.do">
		<form:input path="name"/> <form:errors path="name" cssClass="error"/> <br />
		<form:input path="price" /> <form:errors path="price"  cssClass="error"/> <br />
		<form:input path="quantity" />  <form:errors path="quantity" cssClass="error" /><br />
		<button type="submit">Add Product</button>
	</form:form>
 
</body>
</html>