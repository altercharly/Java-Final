<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
		<h2 class="form-addmedicine-heading">Sell Medicine by prescription only</h2>
	</div>
	<div class='body-container'>
		<form class="form-sellmedicine1" action="sellmedicine1" method="post">
			<h2 class="form-sellmedicine1-heading">Please enter pacient data: </h2>
			<label for="inputHealthPlanId" class="sr-only">Health Plan ID: </label>
			<input name="healthPlanId" id="inputHealthPlanId" class="form-control" placeholder="" required="" autofocus="">
			<br>
			<br>
			<label for="inputAffiliateNumerHP" class="sr-only">Affiliate Number: </label>
			<input name="affiliateNumberHP" id="inputAffiliateNumberHP" class="form-control" placeholder="" required="" autofocus=""> 
			<br>
			<br>
			<br>
			<br>
			<button class="btn" type="submit">Search</button>
		</form>
	</div>
</body>
</html>
