<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Burger Tracker</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
<h1>Burger Tracker</h1>
<table class="table table-striped">
	<thead>
		<tr>
			<td scope="col">
			Burger name
			</td >
			<td scope="col">
			Restaurant name
			</td>
			<td scope="col">
			Rating(out of 5)
			</td>
		</tr>
	</thead>
	<tbody>
	<c:forEach var="burger" items="${burgers}">
		<tr>
			<td><c:out value="${burger.burgerName}"></c:out></td>
			<td><c:out value="${burger.restName}"></c:out></td>
			<td><c:out value="${burger.rating}"></c:out></td>
		</tr>
	</c:forEach>
	</tbody>
</table>
<h2>Add a Burger:</h2>
<form:form action="/" method="post" modelAttribute="burger" >
<form:errors path="restName" class="text-danger"/><br>
<form:errors path="burgerName" class="text-danger"/><br>
<form:errors path="rating" class="text-danger"/><br>
<form:errors path="notes" class="text-danger"/><br>
	<div class="form-group">
        <form:label path="burgerName">Burger Name</form:label>
        <form:input path="burgerName" class="form-control"/>
	</div>
	<div class="form-group">
        <form:label path="restName">Restaurant Name</form:label>
        <form:input path="restName" class="form-control"/>
    </div>
   	<div class="form-group">
        <form:label path="rating">Rating</form:label>
        <form:input type="number" path="rating" class="form-control"/>
    </div>
   	<div class="form-group">
        <form:label path="notes">Notes:</form:label>
        <form:textarea path="notes" class="form-control" rows="3"/>
     </div>
        <button class= "btn btn-primary">Submit</button>
</form:form>

</body>
</html>