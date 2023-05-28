<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fitness Tracker</title>
<link rel="stylesheet" href="/css/style.css">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
<nav class="navbar navbar-expand-lg bg-light">
  <div class="container-fluid">
   <h1 class ="navbar-brand">Welcome Back ${user.userName}!</h1>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="/rHouseForm">+ Add a Workout</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/logout">Logout</a>
        </li>
        </ul>
    </div>
  </div>
</nav>

<table class="table table-striped">
	<thead>
		<tr>
			<th>#</th>
			<th scope="col">
			Listing Date
			</th >
			<th scope="col">
			Address
			</th >
			<th scope="col">
			Price
			</th>
			<th scope="col">
			posted by
			</th>
		</tr>
	</thead>
	<tbody>
			<c:forEach var="house" items="${houses}" varStatus="loop">
				

		<tr>
			<td><c:out value ="${loop.index +1}"></c:out></td>
			<td><fmt:formatDate value="${house.listingDate}" pattern="yyyy-MM-dd" /></td>
				<td><a href ="/view/house/${house.id}"><c:out value="${house.address}"></c:out></a></td>
				<td><c:out value ="${house.price}"></c:out></td>
				<td><c:out value="${house.user.userName}"></c:out></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<a href="/logout" class="btn btn-danger">Logout</a>
</body>
</html>