<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="entities.*"%>
<%@page import="java.util.*"%>
<%
	ArrayList<Presentation> lista = new ArrayList<Presentation>();
	lista = (ArrayList<Presentation>)request.getAttribute("pres");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Sell medicine step 4</title>
</head>
<body>
	<%@include file="parts/header.html" %>
	<div class="content">
		<h2>Please select Medicine Presentation:</h2>
		<form action="sellmedicine4" method="post">
			<label>
				Presentation:
				<select name="idPresentation" required autofocus>
					<% for (Presentation pre : lista) { %>
						<option value="<% out.println(pre.getIdPresentation()); %>">
							<% out.println(pre.getDescription()); %>
						</option>
					<% } %>
				</select>
			</label>
			<label>
				Reg. Number Professional:
				<input name="regNumberP" required>
			</label>
			<button type="submit">Select</button>
		</form>
	</div>
	<%@include file="parts/footer.html" %>
</body>
</html>
