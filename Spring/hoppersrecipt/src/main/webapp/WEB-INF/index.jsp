<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1><c:out value="${name}"></c:out>'s Recipt</h1>
<h2>Item:<c:out value="${itemName}"></c:out></h2>
<h2>Price:<c:out value="${price}"></c:out></h2>
<h2>Description:<c:out value="${description}"></c:out></h2>
<h2>Vendor:<c:out value="${vendor}"></c:out> </h2>

</body>
</html>