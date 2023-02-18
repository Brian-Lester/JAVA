<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Add a Book:</h2>
<form:form action="/book/create/" method="post" modelAttribute="book" >
	<div class="form-group">
        <form:label path="title">Title:</form:label>
		<form:errors path="title" class="text-danger"/>
        <form:input path="title" class="form-control"/>
	</div>
	<div class="form-group">
        <form:label path="author">Author:</form:label>
		<form:errors path="author" class="text-danger"/>
        <form:input path="author" class="form-control"/>
	</div>
	<div class="form-group">
        <form:label path="description">Description:</form:label>
		<form:errors path="description" class="text-danger"/>
        <form:textarea path="description" class="form-control"/>
	</div>
		<form:input  type ="hidden" path = "user" value = "${user.id}"/>
        <button class= "btn btn-primary">Submit</button>
</form:form>
<a href ="/home"><button type="button" class="btn btn-outline-primary">Home</button></a>


</body>
</html>