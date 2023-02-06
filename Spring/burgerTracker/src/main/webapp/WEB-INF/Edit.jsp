<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Insert title here</title>
</head>
<body>
<form:form action="/burger/${burger.id}" method="post" modelAttribute="burger" >
<form:errors path="restName" class="text-danger"/><br>
<form:errors path="burgerName" class="text-danger"/><br>
<form:errors path="rating" class="text-danger"/><br>
<form:errors path="notes" class="text-danger"/><br>
	<div class="form-group">
        <form:label path="burgerName">Burger Name</form:label>
        <form:input path="burgerName" class="form-control" value="${burger.burgerName }"/>
	</div>
	<div class="form-group">
        <form:label path="restName">Restaurant Name</form:label>
        <form:input path="restName" class="form-control" value="${burger.restName}"/>
    </div>
   	<div class="form-group">
        <form:label path="rating">Rating</form:label>
        <form:input type="number" path="rating" class="form-control" value="${burger.rating}"/>
    </div>
   	<div class="form-group">
        <form:label path="notes">Notes:</form:label>
        <form:textarea path="notes" class="form-control" rows="3" value="${burger.notes}"/>
     </div>
        <button class= "btn btn-primary">Submit</button>
</form:form>

</body>
</html>