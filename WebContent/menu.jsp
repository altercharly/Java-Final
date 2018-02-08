<%@page import="business.*"%>
<%@page import="entities.*"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>.:Menu:.</title>
</head>
<body>
	<div class='header'>
		<!-- img class='logo' src=" " -->
		<p class='header-tittle'> UTN Farmacy </p>
	</div>
	
	<div class='menu'>
	<form class="form-menu" action="menu" method="post">
		
	<input type='submit' name="sellmedicine1" value='Venta Medicamento' />
<input type='submit' name="addmedicine" value='Alta Medicamento' />
<input type='submit' name="addpatient" value='Alta Paciente' />
	
	
	<div class='footer'>
		<p class='footer-info'> Tel.: 666-001441 </p>
		<p class='footer-info'> e-mail: farmacy@utn.com.ar </p>
	  </form>
	</div>
</body>
</html>