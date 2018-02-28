<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="entities.*"%>
<%@page import="java.util.*"%>
<%
	ArrayList<Medicine> lista = new ArrayList<Medicine>();
	lista = (ArrayList<Medicine>) request.getAttribute("medicines");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Sell medicine step 3</title>
</head>
<body>
	<%@include file="parts/header.html"%>
	<div class="content">
		<form action="sellmedicine3" method="post">
			<h1>Sell Medicine by prescription only</h1>
			<h2>Please select Medicine by Generic Drug:</h2>
			<label>
				Medicine name:
				<select name="iddrug" required autofocus>
					<% for (Medicine me : lista) { %>
						<option value="<% out.println(me.getname()); %>">
							<% out.println(me.getname()); %> - <% out.println(me.getdescription()); %>
						</option>
					<% } %>
				</select>
			</label>
			<button type='submit'>Search Presentation</button>
		</form>
	</div>
	<%@include file="parts/footer.html"%>
</body>
</html>
