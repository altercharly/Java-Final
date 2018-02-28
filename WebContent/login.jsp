<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String errorMessage = request.getAttribute("errorMessage") == null ? "" : (String) request.getAttribute("errorMessage");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Login</title>
	<link href="Style/login.css" rel="stylesheet">
</head>
<body>
	<%@include file="parts/header.html" %>
	<div class="content">
		<form action="login" method="post" class="login-form">
			<h1>Please login</h1>
			<label>
				User:
				<input name="user" required autofocus>
			</label>
			<label>
				Password:
				<input name="password" type="password" required>
			</label>     
			<button type="submit" class="login-submit">Login</button>
			<span class="errorMessage"><% out.println(errorMessage); %></span>
		</form>
	</div>
	<%@include file="parts/footer.html" %>
</body>
</html>