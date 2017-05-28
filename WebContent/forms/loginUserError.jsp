<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Error Login</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>

	<div class="container">
  <div class="col-lg-12">
	
		<div class="alert alert-danger">
	<c:if test="${empty Message}"> 

	 <strong>Wrong login or Password!</strong>

	</c:if>
	<c:if test="${not empty Message}" >
   <strong>${Message}</strong>
</c:if>

	</div>
	<form action="LoginController" method="POST" class="form-horizontal" >
	
	
	  <div class="form-group"> 
       <label class="control-label col-sm-2" for="pwd">Name:</label>
        <div class="col-sm-10"> 
		<input type="text" name="j_username"   class="form-control" placeholder="Enter login">
		  </div>
    </div>
		
		
		 <div class="form-group">
    <label class="control-label col-sm-2" for="pwd">Password:</label>
    <div class="col-sm-10"> 
	<input type="password" name="j_password" class="form-control" id="pwd" placeholder="Enter password"><br> 
		   </div>
  </div>
		  <div class="form-group"> 
    <div class="col-sm-offset-2 col-sm-10">
<button type="submit" class="btn btn-default">Submit</button>
			
			 </div>
			 </div>
			
			
	</form>

	<a href="/ComputerShop/register.jsp"><button class="btn btn-default">	Register</button></a>
	<br>
	
	</div>
	</div>
	


</body>
</html>