<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<meta charset="ISO-8859-1">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container">
<p>
In <c:out value="${num }"></c:out> days, you will live in <c:out value="${city }"></c:out> with <c:out value="${person }"></c:out> as your roommate, selling <c:out value="${hobby }"></c:out> for a living. the next time you see a <c:out value="${thing }"></c:out>, you will have good luck. Aslo, <c:out value="${nice }"></c:out>
</div>

</body>
</html>