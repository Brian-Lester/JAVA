<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Save Travels</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
<h1>Save Travels</h1>
<table class="table table-striped">
	<thead>
		<tr>
			<th scope="col">
			Expense
			</th >
			<th scope="col">
			Vendor
			</th>
			<th scope="col">
			Amount
			</th>
			<th scope="col">
			Actions
			</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach var="expense" items="${expenses}">
		<tr>
			<td><a href= "/view/expense/${expense.id}"><c:out value="${expense.expenseName}"></c:out></a></td>
			<td><c:out value="${expense.vendor}"></c:out></td>
			<td><c:out value="${expense.amount}"></c:out></td>
			
				<td class ="btn-group"><a href="expense/${expense.id}" class="btn btn-primary">Edit </a> <form action="/expense/delete/${expense.id}" method="post">
    <input type="hidden" name="_method" value="delete">
    <input type="submit" value="Delete" class="btn btn-danger">
</form></td>

		</tr>
	</c:forEach>
	</tbody>
</table>
<h2>Add an Expense:</h2>
<form:form action="/create/expense" method="post" modelAttribute="expense" >
<form:errors path="expenseName" class="text-danger"/><br>
<form:errors path="vendor" class="text-danger"/><br>
<form:errors path="amount" class="text-danger"/><br>
<form:errors path="description" class="text-danger"/><br>
	<div class="form-group">
        <form:label path="expenseName">Expense Name:</form:label>
        <form:input path="expenseName" class="form-control"/>
	</div>
	<div class="form-group">
        <form:label path="vendor">Vendor:</form:label>
        <form:input path="vendor" class="form-control"/>
    </div>
   	<div class="form-group">
        <form:label path="amount">Amount</form:label>
        <form:input type="number" path="amount" class="form-control" step="0.01"/>
    </div>
   	<div class="form-group">
        <form:label path="description">Description:</form:label>
        <form:textarea path="description" class="form-control" rows="3"/>
     </div>
        <button class= "btn btn-primary">Submit</button>
</form:form>


</body>
</html>