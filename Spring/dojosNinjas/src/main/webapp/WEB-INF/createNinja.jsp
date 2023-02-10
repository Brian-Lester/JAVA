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
<h2>Add a Ninja:</h2>
<form:form action="/ninja/create" method="post" modelAttribute="ninja" >
<form:errors path="firstName" class="text-danger"/><br>
	<div class="form-group">
        <form:label path="firstName">First Name:</form:label>
        <form:input path="firstName" class="form-control"/>
	</div>
		<div class="form-group">
        <form:label path="lastName">Last Name:</form:label>
        <form:input path="lastName" class="form-control"/>
	</div>
		<div class="form-group">
        <form:label path="age">Age:</form:label>
        <form:input path="age" class="form-control"/>
	</div>
		<div class="form-group">
	<form:select path="dojo">
        <c:forEach var="onePerson" items="${dojos}">
            <!--- Each option VALUE is the id of the person --->
            <form:option value="${onePerson.id}">
            <!--- This is what shows to the user as the option --->
                <c:out value="${onePerson.name}"/>
            </form:option>
        </c:forEach>
    </form:select>
	</div>

        <button class= "btn btn-primary">Submit</button>
</form:form>
<a href ="/"><button type="button" class="btn btn-outline-primary">Home</button></a>
</body>
</html>