<%@page import="entities.*"%>
<%@page import="business.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	<div class='body-container'>
		<form class="form-addpatient" name="addpatient" action="addpatient" method="post">
        	<h2 class="form-addpatient-heading">Please register patient</h2>
        	     
        	<label for="inputSurname" class="sr-only">Surname :</label>
      		<input name="surname" id="inputSurname" class="form-control" placeholder="" required="" autofocus="">
        	<br>
        	<br>
        	<label for="inputName" class="sr-only">Names :</label>
        	<input name="name" id="inputName" class="form-control" placeholder="" required="" autofocus=""> 
        	<br>
        	<br>
        	<label for="inputBirthdate" class="sr-only">Birth Date :</label>
        	<input name="birthdate" id="inputBirthdate" class="form-control" placeholder="" required="" autofocus=""> 
        	<br>
        	<br>
        	<label for="inputAffiliateNHP" class="sr-only">Affiliate Number Health Plan :</label>
        	<input name="affiliateNHP" id="inputAffiliateNHP" class="form-control" placeholder="" required="" autofocus=""> 
        	<br>
        	<br>
        	
        	<button class="btn" type="submit">Register</button>
        	
        </form>
	</div>


</body>
</html>