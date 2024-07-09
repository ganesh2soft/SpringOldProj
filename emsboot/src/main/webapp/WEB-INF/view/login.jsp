<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

</head>
<body>
	From Login Page

	<h2 style="color: red;">${NOTIFICATION}</h2>
	<div class="container">
		<div class="col align-self-center">
			<form action="signin" method="get">
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
					<button type="submit" class="btn btn-primary">Login</button>
				</div>


			</form>

		</div>

	</div>

</body>
</html>