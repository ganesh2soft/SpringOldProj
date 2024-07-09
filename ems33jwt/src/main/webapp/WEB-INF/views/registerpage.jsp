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

<style>
body {
	background-color: MediumSeaGreen;
	background-image: linear-gradient(20deg, green 0%, brown 10%, #FFCC70 50%);
}

input[type=radio] {
	display: inline-block;
	margin-left: 45px;
}
</style>

<%@ include file="header.jsp"%>

</head>

<body>
<a href="/ems/"" style="float: right;">Back to Home</a>
	<h4 class="text-secondary">Joinee Self Signup Portal !!!</h4>
	
	<a href="/ems/customloginpagectrlr" style="float: right;">Employee/Joinee Login	here</a>

	<div class="container-fluid">
		<div class="col align-self-center">
			<form action="addjoinee" method="POST">

				<div class="form-group">
					<label for="ename" class="col-sm-2 col-form-label">Employee
						Name</label> <input type="text" class="form-control" name="txtjname"
						size="20" pattern="^[a-zA-Z\s]{1,15}$" required />
				</div>
				<div class="form-group">
					<label for="email" class="col-sm-2 col-form-label">Email</label> <input
						type="email" class="form-control" name="txtjemail" size="20"
						required />
				</div>
				<div class="form-group">
					<label for="pass" class="col-sm-2 col-form-label">Password</label>
					<input type="password" class="form-control" name="txtjpass"
						size="20" required />
				</div>
				<div class="form-group">
					<label for="confpass" class="col-sm-2 col-form-label">Confirm
						Password</label> <input type="password" class="form-control"
						name="txtjconfpass" size="20" required />
				</div>
				<div class="form-group">
					<label for="gender" class="col-sm-2 col-form-label">Gender</label>
					<input type="radio" id="male" name="txtjgender" value="male">
					  <label for="male">Male</label>   
					<input type="radio" id="female" name="txtjgender" value="female">  
					 <label for="female">Female</label><br>
				</div>

				&nbsp;

				<div class="form-group">
					<button type="submit" class="btn btn-primary">Add Me</button>
					 <a class="btn btn-primary" href="/ems/">Cancel</a>
				</div>
			</form>
		</div>

	</div>
</body>
</html>