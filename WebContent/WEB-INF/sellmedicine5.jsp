<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="entities.*" %>
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
	<%@include file="../parts/header.jsp" %>
	<div class="content">
		<form action="sellmedicine5" method="post">
			<h1>Sell Medicine by prescription only</h1>
			<h2>Please choose quantity of items:</h2>
			Professional Name: <%=prof.getsurname() %>, <%=prof.getname() %>
			Medicine name: <%=med.getname() %>
			Stock Medicine: <%=item.getcantStock() %>
			Price: <%=item.getprice() %>
			<label>
				Items number:
				<input name="cantItem" required autofocus>
			</label>
			<button type="submit">Select</button>
		</form>
	</div>
	<%@include file="../parts/footer.html" %>
</body>
</html>
