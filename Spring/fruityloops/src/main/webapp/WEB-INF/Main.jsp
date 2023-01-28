<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Fruity Loops</title>
</head>
<body>
<div class= container>
	<h1>Houston we have Liftoff</h1>
	<table class="table table-hover">
		<thead>
			<tr>
				<td>
				 Fruit
				</td> 
				<td>
				 Price
				</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var = "fruit" items ="${fruits}">
			<tr>
				<td>
					<c:out value="${ fruit.name}"></c:out>
				</td>
				<td>
					<c:out value="${ fruit.price}"></c:out>
				</td>
				</c:forEach>
			</tr>
		</tbody>
	</table>
</div>
</body>
</html>