<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="entities.*"%>
<%@page import="java.util.*"%>
<%
	ArrayList<Medicine> lista = new ArrayList<Medicine>();
	lista = (ArrayList<Medicine>)request.getAttribute("medicines");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Sell medicine step 2</title>
</head>
<body>
	<%@include file="parts/header.html" %>
	<div class="content">
		<form action="sellmedicine2" method="post">
			<h2 class="form-sellmedicine2-heading">Please select Generic Drug:</h2>
			<label>
				Generic drug name:
				<input name="gDrugName" required autofocus>
			</label>
			<button type="submit">Search Medicine</button>
		</form>
	</div>
	<%@include file="parts/footer.html" %>
</body>
</html>
