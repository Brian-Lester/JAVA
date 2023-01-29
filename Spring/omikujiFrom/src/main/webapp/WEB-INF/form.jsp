
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<meta charset="ISO-8859-1">
<title>Form Practice</title>
</head>
<body>
<form class="form-horizontal" action="/form/post" method="post">
  <h1>Omikuji form</h1>
  <div class="form-group">
    <label for="num" class="col-sm-3 control-label">Please Select a number between 5-25</label>
    <div class="col-sm-10">
    <select name="num" class="form-control">
		<c:forEach var = "i" begin = "5" end = "25">
         	<option> <c:out value = "${i}"/></option>
      	</c:forEach>
   
    </select>
    </div>
  </div>
  <div class="form-group">
    <label for="city" class="col-sm-2 control-label">Please enter the name of a city</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="city" placeholder="Rochester" name="city">
    </div>
    <label for="person" class="col-sm-2 control-label">Please enter the name of a Person:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="person" placeholder="Bob Dylan" name="person">
    </div>
        <label for="hobby" class="col-sm-2 control-label">Please enter the name of a Profession or hobby:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="hobby" placeholder="costumed engraved plates" name="hobby">
    </div>
        <label for="thing" class="col-sm-2 control-label">Please enter the name of a living thing:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="thing" placeholder="Dragon" name="thing">
          <label for="nice" class="col-sm-2 control-label">Please say something nice to someone:</label>
    <div class="col-sm-10">
      <textarea name="nice" class="form-control" placeholder="the world is a better place with you in it"></textarea>
    </div>
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-primary">Sign in</button>
    </div>
  </div>
</form>

</body>
</html>