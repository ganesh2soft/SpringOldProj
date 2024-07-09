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
			<form action="updateempctrlr" method="GET">

				<div class="form-group">
					<label for="joineeid" class="col-sm-2 col-form-label">Emp
						ID</label> <input type="text" class="form-control" name="joineeId"
						size="20" pattern="^[a-zA-Z\s]{1,15}$" value="${param.joineeId}"
						readonly="readonly" />
				</div>

				<div class="form-group">
					<label for="ename" class="col-sm-2 col-form-label">Emp Name</label>
					<input type="text" class="form-control" name="joineeName" size="20"
						pattern="^[a-zA-Z\s]{1,15}$" required value="${param.joineeName}" />
				</div>
				<div class="form-group">
					<label for="email" class="col-sm-2 col-form-label">Email</label> <input
						type="email" class="form-control" name="joineeemail"
						value="${param.joineeemail }" size="20" readonly="readonly" />
				</div>

				<div class="form-group">
					<label for="dept" class="col-sm-2 col-form-label">Department
					</label> <select name="dept" id="dept">
						<option value="software">IT Software Management</option>
						<option value="hr">Human Resources</option>
					</select>
				</div>

				<div class="form-group">
					<label for="roles" class="col-sm-2 col-form-label">Roles
						Assigned</label> <select name="roles" id="roles">
						<option value="PRODUCTIONUSER">ProductionUser</option>
						<option value="HRSTAFF">HrStaff</option>
						<option value="HRMANAGER">HrManager</option>
					</select>
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