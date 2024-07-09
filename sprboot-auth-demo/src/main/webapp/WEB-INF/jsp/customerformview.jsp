<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer</title>
<link
	href="http://localhost:8080/webjars/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" />
<script
	src="http://localhost:8080/webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="http://localhost:8080/webjars/jquery/3.0.0/js/jquery.min.js"></script>
</head>
<body>
	<div class="container">
		<spring:url value="/customer/save" var="saveURL" />
		<h2>Customer</h2>
		<form:form modelAttribute="customerForm" method="post"	action="${saveURL }" cssClass="form">
			<form:hidden path="id" />
			<div class="form-group">
				<lable for="id">First Name</lable>
				<form:input path="id" cssClass="form-control" id="id" />
			</div>
			<div class="form-group">
				<lable for="firstName">First Name</lable>
				<form:input path="firstName" cssClass="form-control" id="firstName" />
			</div>
			<div class="form-group">
				<lable for="lastName">Last Name</lable>
				<form:input path="lastName" cssClass="form-control" id="lastName" />
			</div>
			<div class="form-group">
				<lable for="email">Email</lable>
				<form:input path="email" cssClass="form-control" id="email" />
			</div>
			<div class="form-group">
				<lable for="age">age</lable>
				<form:input path="age" cssClass="form-control" id="age" />
			</div>
			<div class="form-group">
				<lable for="username">User Name</lable>
				<form:input path="username" cssClass="form-control" id="username" />
			</div>
			<div class="form-group">
				<lable for="password">Password</lable>
				<form:input path="password" cssClass="form-control" id="password" />
			</div>
			<button type="submit" class="btn btn-primary">Save</button>
		</form:form>
	</div>
</body>
</html>