

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%--  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> --%>
<html>
<head>
<title>User Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: blue">
			<div>
				<a href="http://localhost:8080/UserManagement/userWelcome" class="navbar-brand"> User Management Application </a>
			</div>

		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				
				<form action="P1" method = "post">  
					<input type="text" name="name" placeholder="Enter mobile number/Aadhar/PAN.." size=50 required /><br/>  
					<input type="password" name="password"  placeholder="Enter password here.." size=50 required /><br/>  
					<input type="submit" value="Login" name="Login"/>  
				</form>  
			</div>
		</div>
	</div>
</body>
</html>