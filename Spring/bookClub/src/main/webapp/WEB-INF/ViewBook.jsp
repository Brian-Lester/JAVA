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
<c:if test="${ user.id != book.user.id}">
<p><c:out value="${book.user.userName}"></c:out> read <c:out value="${book.title}"></c:out> By <c:out value="${book.author}"></c:out></p>
</c:if>
<c:if test="${user.id == book.user.id}">
<p>You read <c:out value="${ book.title}"></c:out> and here are your thoughts. </p>
</c:if>

<form:form action="#" method="post" modelAttribute="book" >
	<div class="form-group">
        <form:label path="title">Title:</form:label>
		<form:errors path="title" class="text-danger"/>
        <form:input path="title" disabled = "true" class="form-control"/>
	</div>
	<div class="form-group">
        <form:label path="author">Author:</form:label>
		<form:errors path="author" class="text-danger"/>
        <form:input path="author" disabled = "true" class="form-control"/>
	</div>
	<div class="form-group">
        <form:label path="description">Description:</form:label>
		<form:errors path="description" class="text-danger"/>
        <form:textarea path="description" disabled = "true" class="form-control"/>
	</div>
</form:form>
<a href ="/home"><button type="button" class="btn btn-outline-primary">Home</button></a>

<c:if test="${ user.id == book.user.id }">
<a href ="/delete/${book.id}/${user.id}"><button type="button" class="btn btn-outline-danger">Delete</button></a>
<a href ="/edit/${book.id}/${user.id}"><button type="button" class="btn btn-outline-danger">edit</button></a>
</c:if>


</body>
</html>