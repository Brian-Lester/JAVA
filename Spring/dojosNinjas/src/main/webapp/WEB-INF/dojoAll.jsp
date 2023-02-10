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
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>All Dojos</title>
</head>
<body>
<c:forEach var="dojo" items="${dojos}">
<table class="table table-striped">
	<thead>
		<tr>
			<th scope="col">
			<c:out value="${dojo.name}"></c:out>
			</th >
			<th scope="col">
			students first name:
			</th>
			<th scope="col">
			students last name:
			</th>
			<th scope="col">
			students Age:
			</th>
		</tr>
	</thead>
	<tbody>
			<c:forEach var="ninja" items="${dojo.ninjas}" varStatus="loop">
				

		<tr>
			
			<td><c:out value="${loop.index +1}"></c:out></td>
				<td><c:out value="${ninja.firstName}"></c:out></td>
				<td><c:out value="${ninja.lastName}"></c:out></td>
				<td><c:out value="${ninja.age}"></c:out></td>

		</tr>

			</c:forEach>
	</tbody>
</table>
</c:forEach>
<a href ="/"><button type="button" class="btn btn-outline-primary">Home</button></a>

</body>
</html>