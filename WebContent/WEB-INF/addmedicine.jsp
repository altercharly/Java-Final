<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="entities.GenericDrug" %>
<%@page import="java.util.ArrayList" %>
<%
	ArrayList<GenericDrug> lista = new ArrayList<GenericDrug>();
	lista = (ArrayList<GenericDrug>) request.getAttribute("gdrugs");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Add medicine</title>
</head>
<body>
	<%@include file="../parts/header.jsp" %>
	<div class="content">
		<form action="addmedicine" method="post">
			<h1>Please enter new medicine info</h1>
			<label>
				Generic drug:
				<select name="iddrug" required autofocus>
					<% for (GenericDrug gen : lista) { %>
						<option value="<% out.println(gen.getidDrug()); %>">
							<% out.println(gen.getdrugName()); %>
						</option>
					<% } %>
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
	<%@include file="../parts/footer.html" %>
</body>
</html>
