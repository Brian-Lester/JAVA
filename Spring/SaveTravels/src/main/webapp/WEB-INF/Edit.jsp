<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Expense</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
<form:form action="/edit/expense/${expense.id}" method="post" modelAttribute="expense" >
<input type="hidden" name="_method" value="put">
<form:errors path="expenseName" class="text-danger"/><br>
<form:errors path="vendor" class="text-danger"/><br>
<form:errors path="amount" class="text-danger"/><br>
<form:errors path="description" class="text-danger"/><br>
	<div class="form-group">
        <form:label path="expenseName">Expense Name:</form:label>
        <form:input path="expenseName" class="form-control"  value="${expense.expenseName}"/>
	</div>
	<div class="form-group">
        <form:label path="vendor">Vendor:</form:label>
        <form:input path="vendor" class="form-control"  value="${expense.vendor}"/>
    </div>
   	<div class="form-group">
        <form:label path="amount">Amount</form:label>
        <form:input type="number" path="amount" class="form-control" step="0.01"  value="${expense.amount}"/>
    </div>
   	<div class="form-group">
        <form:label path="description">Description:</form:label>
        <form:textarea path="description" class="form-control" rows="3"  value="${expense.description}"/>
     </div>
        <button class= "btn btn-primary">Submit</button>
</form:form>

</body>
</html>