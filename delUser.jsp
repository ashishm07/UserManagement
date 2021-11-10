

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
				<a href="http://localhost:8080/" class="navbar-brand"> User Management Application </a>
			</div>

		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">

				
				<form action="userWelcome" method = "POST">  
					<input type="text" name="name" placeholder="Enter name here.." onclick="this.value=''"/><br/>  
					<input type="password" name="password" value="" placeholder="Enter password here.." onclick="this.value=''"/><br/>  
					<input type="submit" value="Delete User" name="Delete User"/>  
				</form>  
			</div>
		</div>
	</div>
</body>
</html>