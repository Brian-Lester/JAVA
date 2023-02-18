<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
<nav class="navbar navbar-expand-lg bg-light">
  <div class="container-fluid">
   <h1 class ="navbar-brand">Welcome ${user.userName}</h1>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="/rBookForm">+ Add a Book</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Logout</a>
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
			Title
			</th >
			<th scope="col">
			Author
			</th>
			<th scope="col">
			PostedBy
			</th>
		</tr>
	</thead>
	<tbody>
			<c:forEach var="Book" items="${Books}" varStatus="loop">
				

		<tr>
			
			<td><c:out value="${loop.index +1}"></c:out></td>
				<td><a href= "view/book/${Book.id}"><c:out value="${Book.title}"></c:out></a></td>
				<td><c:out value="${Book.author}"></c:out></td>
				<td><c:out value="${Book.user.userName}"></c:out></td>

		</tr>

			</c:forEach>
	</tbody>
</table>
<a href="/logout" class="btn btn-danger">Logout</a>
</body>
</html>