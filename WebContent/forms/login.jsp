<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
	<div class="col-md-4 col-md-offset-4">


	<form action="j_security_check" method="POST" class="form-horizontal" >
	
	
	  <div class="form-group"> 
       <label class="control-label col-sm-2" for="pwd">Name:</label>
        <div class="col-sm-10"> 
		<input type="text" name="j_username"   class="form-control"placeholder="Enter login">
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

<button class="btn btn-default">		<a href="/ComputerShop/register.jsp">Register</a></button>
	<br>
</div></div>
</body>
</html>