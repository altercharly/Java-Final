<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="entities.*"%>
<%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>UTN Pharmacy</title>
</head>
<body>
	<div class='header'>
		<!-- img class='logo' src=" " -->
		<p class='header-tittle'> UTN Pharmacy</p>
	</div>
	<div class='content'>
		<form class="form-sellmedicine7" action="sellmedicine7" method="post">
			<h2 class="form-sellmedicine7-heading">Sale registered succesfully </h2>
			<% out.println("Please select next action: "); %>
			<br>
			<br>
			<input type='submit' name="backMenu" value='Menu' />
			<input type='submit' name="backSale" value='Sell Medicine' />
		</form>
	</div>
</body>
</html>
