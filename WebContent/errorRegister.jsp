<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<div class="col-md-4 col-md-offset-4">
	<div class="alert alert-danger">
	 <strong>${Message}</strong>
	</div>
		<h2>Register to access our Shop!</h2>
		<form action="AddUser" method="post">

			<div class="form-group">
				<label for="email">Name:</label> <input type="text" name="name" pattern="(.){6,6}"><br>
			</div>

			<input type="hidden" name="role" value="client">

			<div class="form-group">
			
				<label for="password">Password:</label>	<input type ="password" placeholder="Password" name="password" id="psd">
				<br>
			</div>
			<div class="form-group">
			
				<label for="password">ConfirmPassword:</label>	<input type ="password" placeholder="ConfirmPassword" name="password"  id="confirmPsd">
				<br>
			</div>
    <button class="btn btn-large btn-primary" type="submit">Sign in</button>
		</form>
		<a href="/ComputerShop/">Home</a>

	</div></div>




	<!-- jQuery -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>


	<script>
		$('button').on('click', function() {
			if ($('#confirmPsd').val() === $('#psd').val()) {
			
				return true;
			} else {
				alert("Password are not the same!");
				return false;
			}
		
			
		})
		
		
		
		
		
	</script>

	<!-- Bootstrap Core JavaScript -->
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>