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
	<title>Sell medicine step 3</title>
</head>
<body>
	<%@include file="parts/header.html" %>
	<div class="content">
		<h2>Please select Medicine by Generic Drug:</h2>
		<form action="sellmedicine3" method="post">
			<label>
				Medicine name:
				<select name="iddrug" required autofocus>
					<% for(Medicine me : lista) { %>
						<option value="<% out.println(me.getname()); %>">
							<% out.println(me.getname()); %> - <% out.println(me.getdescription()); %>
						</option>
					<% } %>
				</select>
			</label>
			<button type='submit'>Search Presentation</button>
		</form>
	</div>
</body>
</html>
