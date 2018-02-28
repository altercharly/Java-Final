<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="entities.*"%>
<%@page import="java.util.*"%>
<%
	ArrayList<GenericDrug> lista= new ArrayList<GenericDrug>();
	lista=(ArrayList<GenericDrug>)request.getAttribute("gdrugs");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>UTN Pharmacy</title>
</head>
<body>
	<%@include file="parts/header.html" %>
	<div class="content">
		<form action="addmedicine" method="post">
			<h2>Please enter new medicine info</h2>
			<label>
				Generic drug:
				<select name="iddrug" required autofocus>
					<%
						for( GenericDrug gen : lista) {
					%>
							<option value="<% out.println(gen.getidDrug()); %>"><% out.println(gen.getdrugName());  %></option>
					<%
						}
					%>
				</select>
			</label>
			<label>
				Comercial Names:
				<input name="name" required>
			</label>
			<label>
				Description:
				<input name="description" required>
			</label>
			<button type="submit">Register</button>
		</form>
	</div>
	<%@include file="parts/footer.html" %>
</body>
</html>
