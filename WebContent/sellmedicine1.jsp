<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Sell medicine step 1</title>
</head>
<body>
	<%@include file="parts/header.html" %>
	<div class="content">
		<h2>Sell Medicine by prescription only</h2>
		<form action="sellmedicine1" method="post">
			<h3>Please enter patient data:</h3>
			<label>
				Health Plan ID:
				<input name="healthPlanId" required autofocus>
			</label>
			<label>
				Affiliate Number:
				<input name="affiliateNumberHP" required>
			</label>
			<button type="submit">Search</button>
		</form>
	</div>
	<%@include file="parts/footer.html" %>
</body>
</html>
