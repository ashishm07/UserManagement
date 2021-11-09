<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.nkn.usermanagement.bean.User"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>

<html>
<head>
<title>User Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<%
	response.setHeader("cache-control", "no-cache, no-store, must-revalidate "); // to prevent creating caches

	String name;
	int flag = 0;
	
	/*** To ensure only authorised users can see this page ***/
	Cookie cookie[] = request.getCookies();
	for (Cookie c : cookie) {
		if (c.getName().equals("uname")) {
			flag = 1;
			break;
		}

		if (flag == 1) {

			name = c.getValue();
			out.print(name + " has been added.");
			System.out.println(name + " has been added");


			//	String message = (String)request.getAttribute("alertMsg");
			out.print("Testing session");

		}
	}

	if (flag == 0) {
		response.sendRedirect("userLogin.jsp");

	}
	%>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: blue">
			<div>
				<a href="http://localhost:8005/UserManagement/userWelcome"
					class="navbar-brand" onsubmit=false> User Management
					Application </a>
			</div>
		</nav>
	</header>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">User Information</h3>
			<hr>
			<div class="container text-left">

				<form action="userWelcome" method="POST">
					<input type="submit" value="Add" name="Add" /> <br /> <input
						type="submit" value="Delete" name="Delete" /> <br /> <input
						type="submit" value="Update" name="Update" /> <br /> <input
						type="submit" value="List All Users" name="List All Users" />
				</form>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>name</th>
						<th>password</th>
					</tr>
				</thead>
				<tbody>
					<%
					List<User> users = (List<User>) request.getAttribute("listUser");
					if (users != null) {
						for (User u : users) {
					%>
					<tr>
						<td><%=u.getName()%></td>
						<td><%=u.getPassword()%></td>
					</tr>
					<%
					}
					}
					%>
				</tbody>

			</table>

			<form action="userWelcome" method="POST">
				<input type="submit" value="LogOut" name="LogOut" /> <br />
			</form>


		</div>
	</div>
</body>
</html>