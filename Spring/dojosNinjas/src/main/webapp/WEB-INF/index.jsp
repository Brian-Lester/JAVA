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
<title>Dashboard</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
</head>
<body>
<h1>Welcome to Dojos and Ninjas!!!</h1>
<div class="btn-group" role="group" aria-label="Basic outlined example">
  <a href = "/dojo/create"><button type="button" class="btn btn-outline-primary">Create a Dojo!</button></a>
  <a href = "/dojo/all"><button type="button" class="btn btn-outline-primary">View Current Dojos!</button></a>
  <a href ="/ninja/create"><button type="button" class="btn btn-outline-primary">Create a Ninja!</button></a>
</div>

</body>
</html>