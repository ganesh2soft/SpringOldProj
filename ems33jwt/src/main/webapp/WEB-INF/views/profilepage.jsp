<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Joinee/Employee Home Page</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
	
	<style>
body{   
   background-color:  	 #b3ffb3;
  
}
</style>
<%@ include file = "header.jsp" %>
</head>
<body>
<h6 class="text-danger text-center"> Joinee/Employee Portal </h6>
<nav class="navbar navbar-light bg-primary">
  <form class="container-fluid justify-content-center">
  <a href="/ems/logoutctrlr" class="link-light  ">Logout</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 <a href="/ems/hradminctrlr" class="link-light">Switch to HR Admin Portal</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 <a href="/ems/noticesctrlr" class="link-light">Notices</a>&nbsp;
  </form>
</nav>

;

	<table class="table table-hover">
		<thead>
			<tr>

				<th scope="col">Employee ID</th>
				<th scope="col">Employee Name</th>
				<th scope="col">Email</th>
				<th scope="col">Gender</th>
				<th scope="col">Department</th>
				<th scope="col">Roles assigned</th>
				<th scope="col" colspan="2">Action</th>
			</tr>
		</thead>
		<tbody>
			
				<tr>
			        
					<td><c:out value="${displayemp.joineeId}" /></td>
					<td><c:out value="${displayemp.joineeName}" /></td>
					<td><c:out value="${displayemp.joineeemail}" /></td>
					<td><c:out value="${displayemp.joineegender}" /></td>
						<td><c:out value="${displayemp.roles}" /></td>
						<td><c:out value="${displayemp.roles}" /></td>			
				</tr>

		

		</tbody>


	</table>

</body>
</html>