<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<c:url value="/ems/customloginpagectrlr" var="loginUrl"/>  
<html>
<head><title>Insert title here</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<style>
body{   
   background-color: green;
   background-image: linear-gradient(43deg, green 0%, brown 30%, #FFCC70 100%);
}


</style>
<%@ include file = "header.jsp" %></head>
<body>

<form action="${loginUrl}" method="post">         
    <c:if test="${param.error != null}">          
        <p>  
            Invalid username and password.  
        </p>  
    </c:if>  
    <c:if test="${param.logout != null}">         
        <p>  
            You have been logged out.  
        </p>  
    </c:if>  
    <p>  
        <label for="username">Email</label>  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="text" id="username" name="username"/>      
    </p>  
    <p>  
        <label for="password">Password</label>  &nbsp;&nbsp;
        <input type="password" id="password" name="password"/>      
    </p>  
   <input type="hidden" name="${_csrf.parameterName}"
    value="${_csrf.token}"/>
    <button type="submit" class="btn btn-secondary">Log in</button>  
 
  <a class="btn btn-secondary" href="/ems/">Cancel</a>

</form>  
</body>
   </html>