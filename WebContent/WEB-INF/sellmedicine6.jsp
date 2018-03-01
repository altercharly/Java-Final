<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="entities.*" %>
<%
	Item item = new Item();
	Professional prof = new Professional();
	Medicine med = new Medicine();
	Double cantPrice = (double) request.getAttribute("calcPrice");
	HttpSession mysession = (HttpSession) request.getSession();
	item = (Item) mysession.getAttribute("itemsel");
	prof = (Professional) mysession.getAttribute("professional");
	med = (Medicine) mysession.getAttribute("medicine");
	int cantItems = (int) mysession.getAttribute("cantItems");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Sell medicine step 6</title>
</head>
<body>
	<%@include file="../parts/header.jsp" %>
	<div class="content">
		<form action="sellmedicine6" method="post">
			<h1>Sell Medicine by prescription only</h1>
			<h2>Please confirm the sale: </h2>
			Professional Name: <%=prof.getsurname() %>, <%=prof.getname() %>
			Medicine name: <%=med.getname() %>
			Selected items: <%=cantItems %>
			Calculated price: <%=cantPrice %>
			<button type="submit">Register</button>
		</form>
	</div>
	<%@include file="../parts/footer.html" %>
</body>
</html>
