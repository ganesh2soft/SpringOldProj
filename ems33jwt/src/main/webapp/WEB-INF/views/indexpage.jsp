<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

<style>
body{   
     background-color: black;
  background-image: linear-gradient(43deg, white 0%, #50c89e 46%, #fdff70 100%);

}
</style>

<title>Insert title here</title>
<%@ include file = "header.jsp" %>
</head>
<body>

<nav class="navbar navbar-light bg-primary">
  <form class="container-fluid justify-content-center">
  <a href="/ems/registerctrlr" class="link-light">New_Joinee_Signup</a> &nbsp;&nbsp;&nbsp;&nbsp;
   
   <a href="/ems/customloginpagectrlr" class="link-light">Employee/Joinee Login</a> &nbsp;&nbsp;&nbsp;&nbsp;

 <a href="/ems/logoutctrlr" class="link-light">Logout</a>&nbsp;;&nbsp;&nbsp;&nbsp;
<a href="/ems/noticesctrlr" class="link-light">Notices</a>&nbsp;
  </form>
</nav>

</body>
</html>