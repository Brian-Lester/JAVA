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
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
</head>
<body>
<h2>Add adojo:</h2>
<form:form action="/dojo/create" method="post" modelAttribute="dojo" >
<form:errors path="name" class="text-danger"/><br>
	<div class="form-group">
        <form:label path="name">Dojo Name:</form:label>
        <form:input path="name" class="form-control"/>
	</div>

        <button class= "btn btn-primary">Submit</button>
</form:form>
<a href ="/"><button type="button" class="btn btn-outline-primary">Home</button></a>

</body>
</html>