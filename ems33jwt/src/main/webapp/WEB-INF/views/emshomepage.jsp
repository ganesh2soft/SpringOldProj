<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file = "header.jsp" %>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
	
	<style>
body{   
   background-color: white;
   background-image: linear-gradient(10deg, white 0%, green 46%, #FFCC70 100%);
}
</style>
</head>
<body>

	<h3>EMS management Page</h3>
	<a href="/ems/logoutctrlr" class="link-warning  ">Logout</a>&nbsp;
	

	<table class="table table-hover">
		<thead>
			<tr>
				
				<th scope="col">Employee ID</th>
				<th scope="col">Employee Name</th>
				<th scope="col">Employee Email</th>
				<th scope="col">Gender</th>
				<th scope="col">Working Department</th>
				<th scope="col">Roles Assigned</th>
				<th scope="col" colspan="2">Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="row" items="${allemp}">
				<tr>
					<td><c:out value="${row.joineeId}" /></td>
					<td><c:out value="${row.joineeName}" /></td>
					<td><c:out value="${row.joineeemail}" /></td>
					<td><c:out value="${row.joineegender}" /></td>
					<td><c:out value="${row.dept}" /></td>
					<td><c:out value="${row.roles}" /></td>
			
			
			<td><a href="editctrlr?joineeId=${row.joineeId}&joineeName=${row.joineeName}
			               &email=${row.joineeemail}&dept=${row.dept}&roles=${row.roles}">Edit</a></td>		
			<td><a href="deletectrlr?joineeId=${row.joineeId}">Delete</a></td>						
				
				</tr>

			</c:forEach>

		</tbody>


	</table>

</body>
</html>