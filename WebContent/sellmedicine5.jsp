<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="entities.*"%>
<%@page import="java.util.*"%>
<%
	Item item = new Item();
	Professional prof = new Professional();
	Medicine med = new Medicine();
	HttpSession mysession = (HttpSession) request.getSession();
	item = (Item)mysession.getAttribute("itemsel");
	prof = (Professional)mysession.getAttribute("professional");
	med = (Medicine)mysession.getAttribute("medicine");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Sell medicine step 5</title>
</head>
<body>
	<%@include file="parts/header.html" %>
	<div class="content">
		<h2>Please choose quantity of items: </h2>
		<form action="sellmedicine5" method="post">
			<% out.println("Professional Name: "+prof.getsurname()+", "+prof.getname()); %>
			<% out.println("Medicine name: "+med.getname()); %>
			<% out.println("Stock Medicine: "+item.getcantStock()); %>
			<% out.println("Price: "+item.getprice()); %>
			<label>
				Items number:
				<input name="cantItem" required autofocus>
			</label>
			<button type="submit">Select</button>
		</form>
	</div>
	<%@include file="parts/footer.html" %>
</body>
</html>
