<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit page</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>
	Edit

	<div class="container-fluid">
		<div class="col align-self-center">
			<form action="updateemp" method="GET">

				<div class="form-group">
					<label for="eid" class="col-sm-2 col-form-label">Emp ID</label> <input
						type="text" class="form-control" name="employeeId" size="20"
						pattern="^[a-zA-Z\s]{1,15}$" value="${param.employeeId}"
						readonly="readonly"/>
				</div>

				<div class="form-group">
					<label for="ename" class="col-sm-2 col-form-label">Emp Name</label>
					<input type="text" class="form-control" name="employeeName" size="20"
						pattern="^[a-zA-Z\s]{1,15}$" required
						value="${param.employeeName}" />
				</div>
				<div class="form-group">
					<label for="email" class="col-sm-2 col-form-label">Email</label> <input
						type="email" class="form-control" name="email"
						value="${param.email }" size="20"  readonly="readonly"/>
				</div>

				<div class="form-group">
					<label for="gender" class="col-sm-2 col-form-label">Gender</label>
					<input type="text" class="form-control" name="gender"
						value="${param.gender }" size="20" required />
				</div>

				<div class="form-group">
					<label for="dob" class="col-sm-2 col-form-label">DOJ</label> <input
						type="date" name="doj" value="${param.doj }"
						placeholder="yyyy-mm-dd" />
				</div>

				<div class="form-group">
					<button type="submit" class="btn btn-primary">Update
						Employee</button>
				</div>
			</form>
		</div>

	</div>

</body>
</html>