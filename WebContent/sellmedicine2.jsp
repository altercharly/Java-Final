<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="entities.*"%>
<%@page import="java.util.*"%>
<%
	ArrayList<Medicine> lista= new ArrayList<Medicine>();
	lista=(ArrayList<Medicine>)request.getAttribute("medicines");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>UTN Pharmacy</title>
</head>
<body>
	<div class='header'>
		<!-- img class='logo' src=" " -->
		<p class='header-tittle'> UTN Pharmacy </p>
	</div>
	<div class='content'>
		<form class="form-sellmedicine1" action="sellmedicine2" method="post">
			<h2 class="form-sellmedicine2-heading">Please select Generic Drug: </h2>
			<label for="inputGenericDrug" class="sr-only">Generic drug name: </label>
			<input name="gDrugName" id="inputGenericDrugName" class="form-control" placeholder="" required="" autofocus="">
			<br>
			<br>
			<input type='submit' name="getMedicines" value='Search Medicine' />
		</form>
	</div>
</body>
</html>
