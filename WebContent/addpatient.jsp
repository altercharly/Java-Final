<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="entities.*"%>
<%@page import="business.*"%>
<%@page import="aim.*"%>
<%@page import="java.util.*"%>
<%
	ArrayList<HealthPlan> lista = new ArrayList<HealthPlan>();
	lista = (ArrayList<HealthPlan>)request.getAttribute("hplans");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Add patient</title>
</head>
<body>
	<%@include file="parts/header.html" %>
	<div class="content">
		<form action="addpatient" method="post">
			<h2>Please register new patient</h2>
			<label>
				Surname:
				<input name="surname" required autofocus>
			</label>
			<label>
				Names:
				<input name="name" required>
			</label>
			<label>
				Birth Date:
				<input name="birthdate" required>
			</label>
			<label>
				Health Plan:
				<select name="healthPlanId" required>
					<% for( HealthPlan hp : lista) { %>
						<option value="<% out.println(hp.getidHealthPlan()); %>"><% out.println(hp.getnameHP()); %></option>
					<% } %>
				</select>
			</label>
			<label>
				Affiliate Number Health Plan:
				<input name="affiliateNHP" required>
			</label>
			<button type="submit">Register</button>
		</form>
	</div>
	<%@include file="parts/footer.html" %>
</body>
</html>
