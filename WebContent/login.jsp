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
			<h2>Please login</h2>
			<label for="user">
				User:
				<input name="user" required autofocus>
			</label>
			<label for="password">
				Password:
				<input name="password" type="password" required>
			</label>     
			<button type="submit" class="login-submit">Login</button>
		</form>
	</div>
	<%@include file="parts/footer.html" %>
</body>
</html>