<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="entities.*"%>
<%@page import="java.util.*"%>
<%
	Item item = new Item();
	Professional prof = new Professional();
	Medicine med = new Medicine();
	Double cantPrice = (double)request.getAttribute("calcPrice");
	HttpSession mysession = (HttpSession) request.getSession();
	item = (Item)mysession.getAttribute("itemsel");
	prof = (Professional)mysession.getAttribute("professional");
	med = (Medicine)mysession.getAttribute("medicine");
	int cantItems = (int)mysession.getAttribute("cantItems");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Sell medicine step 6</title>
</head>
<body>
	<%@include file="parts/header.html" %>
	<div class="content">
		<h2>Please confirm the sale: </h2>
		<form action="sellmedicine6" method="post">
			<% out.println("Professional Name: " + prof.getsurname() + ", " + prof.getname()); %>
			<% out.println("Medicine name: " + med.getname()); %>
			<% out.println("Selected items: " + cantItems); %>
			<% out.println("Calculated price: " + cantPrice); %>
			<button type="submit">Register</button>
		</form>
	</div>
	<%@include file="parts/footer.html" %>
</body>
</html>
