<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="ISO-8859-1">
	<title>.:Login:.</title>
</head>
<body>
	<%@include file="parts/header.html" %>
	<div class='body-container'>
		<form action="login" method="post">
			<h2 class="form-signin-heading">Please login</h2>
			<label for="inputUser" class="sr-only">User :</label>
			<input name="user" id="inputUser" class="form-control" placeholder="" required="" autofocus="">
			<label for="inputPassword" class="sr-only">Password :</label>
			<input name="pass" id="inputPassword" class="form-control" placeholder="" required="" type="password">     
			<button class="btn" type="submit">Login</button>
		</form>
	</div>
</body>
</html>
