<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer List</title>
<link href="../webjars/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" />
<script src="../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="../webjars/jquery/3.0.0/js/jquery.min.js"></script>
</head>
<body>
	<div class="container">
		<h2>Customer List</h2>
		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="row">Customer Id</th>
					<th scope="row">First Name</th>
					<th scope="row">Last Name</th>
					<th scope="row">Email</th>				
					<th scope="row">age</th>
					<th scope="row">User Name</th>
					<th scope="row">Password</th>
					<th scope="row">Edit</th>
					<th scope="row">Delete</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${customerList }" var="customer">
					<tr>
						<td>${customer.id }</td>
						<td>${customer.firstName }</td>
						<td>${customer.lastName }</td>
						<td>${customer.email }</td>
						<td>${customer.age }</td>
						<td>${customer.userName }</td>
						<td>${customer.password }</td>
						<td><spring:url
								value="/customer/update/${customer.id }" var="updateURL" />
							<a class="btn btn-primary" href="${updateURL }" role="button">Update</a>
						</td>
						<td><spring:url
								value="/customer/delete/${customer.id }" var="deleteURL" />
							<a class="btn btn-primary" href="${deleteURL }" role="button">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<spring:url value="/customer/add" var="addURL" />
		<a class="btn btn-primary" href="${addURL }" role="button">Add New
			Customer</a>
	</div>
</body>
</html>