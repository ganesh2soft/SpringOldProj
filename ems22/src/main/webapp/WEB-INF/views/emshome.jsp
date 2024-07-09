<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	
	<style>
body{   
   background-color: #d08141;
   background-image: linear-gradient(43deg, white 0%, blue 46%, #FFCC70 100%);
}
</style>
</head>
<body>
	Home Page
	

	<table class="table table-hover">
		<thead>
			<tr>
				
				<th scope="col">Emp ID</th>
				<th scope="col">Emp Name</th>
				<th scope="col">Email</th>
				<th scope="col">Gender</th>
				<th scope="col">Date of Joining</th>
				<th scope="col" colspan="2">Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="row" items="${allemp}">
				<tr>
					<td><c:out value="${row.employeeId}" /></td>
					<td><c:out value="${row.employeeName}" /></td>
					<td><c:out value="${row.email}" /></td>
					<td><c:out value="${row.gender}" /></td>
					<td><c:out value="${row.doj}" /></td>	
					<td><a href="edit?employeeId=${row.employeeId}&employeeName=${row.employeeName}&email=${row.email}&gender=${row.gender}&doj=${row.doj}">Edit</a></td>		
					<td><a href="delete?employeeId=${row.employeeId}">Delete</a></td>						
				</tr>

			</c:forEach>

		</tbody>


	</table>

</body>
</html>