<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Page</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>
	<h3>Register here</h3>
	<a href="loginpage">Login here</a>

	<div class="container-fluid">
		<div class="col align-self-center">
			<form action="addemp" method="POST">
				
				<div class="form-group">
					<label for="ename" class="col-sm-2 col-form-label">Emp Name</label>
					<input type="text" class="form-control" name="txtename" size="20"
						pattern="^[a-zA-Z\s]{1,15}$" required />
				</div>
				<div class="form-group">
					<label for="email" class="col-sm-2 col-form-label">Email</label> <input
						type="email" class="form-control" name="txtemail" size="20"
						required />
				</div>
				<div class="form-group">
					<label for="pass" class="col-sm-2 col-form-label">Password</label>
					<input type="text" class="form-control" name="txtpass" size="20"
						required />
				</div>
				<div class="form-group">
					<label for="gender" class="col-sm-2 col-form-label">Gender</label>
					<input type="text" class="form-control" name="txtgender" size="20"
						required />
				</div>

				<div class="form-group">
					<label for="dob" class="col-sm-2 col-form-label">DOBirth</label> 
					 <input type="date" name="dob"  placeholder="yyyy-mm-dd"/>
				</div>
				
				<div class="form-group">
					<button type="submit" class="btn btn-primary">Add Employee</button>
				</div>
			</form>
		</div>

	</div>

</body>
</html>