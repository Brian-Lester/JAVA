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
<div class="container">
<h2>Posted by: <c:out value="${house.user.userName}"></c:out></h2>

<form:form action="#" method="post" modelAttribute="house" >
	<div class="form-group">
        <form:label path="address">Address:</form:label>
		<form:input path="address" disabled = "true" class="form-control"/>
	</div>
	<div class="form-group">
        <form:label path="price">Price:</form:label>
        <form:input path="price" disabled = "true" class="form-control"/>
	</div>
	<div class="form-group">
        <form:label path="listingDate">Listing date:</form:label>
        <form:input path="listingDate" disabled = "true" class="form-control" />
	</div>
</form:form>
<a href ="/home"><button type="button" class="btn btn-outline-primary">Home</button></a>

<form:form  class = "form" action="/add/message/" method="post" modelAttribute="newMessage">
	<div class="form-group">
        <form:label path ="message">Please Leave a Message!</form:label>
        <form:errors path="message" class="text-danger"/><br>
		<form:input  class="form-control" path="message" />
		<form:input  type ="hidden" path = "user" value = "${user.id}"/>
		<form:input  type ="hidden" path = "house" value = "${house.id}"/>
	</div>
	<button class = "btn btn-outline-primary">Submit</button>
</form:form>

<c:if test="${ user.id == house.user.id }">
	<a href ="/delete/${house.id}/${user.id}"><button type="button" class="btn btn-outline-danger">Delete</button></a>
	<a href ="/edit/${house.id}/${user.id}"><button type="button" class="btn btn-outline-danger">edit</button></a>
</c:if>
	<div class="overflow-scroll w-100 p-3" style ="height:150px">
		<c:forEach var="message" items = "${house.messages}">
			<div>
				<p>Added by: <c:out value = "${message.user.userName }"></c:out></p>
				<p>- <c:out value="${message.message }"></c:out></p>
			</div>
		</c:forEach>
	</div>
</div>



</body>
</html>