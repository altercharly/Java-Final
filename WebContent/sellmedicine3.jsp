<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="entities.*"%>
<%@page import="java.util.*"%>
<%
	ArrayList<Medicine> lista= new ArrayList<Medicine>();
	lista=(ArrayList<Medicine>)request.getAttribute("medicines");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>UTN Pharmacy</title>
</head>
<body>
	<div class='header'>
		<!-- img class='logo' src=" " -->
		<p class='header-tittle'> </p>
	</div>
	<div class='content'>
		<form class="form-sellmedicine3" action="sellmedicine3" method="post">
			<h2 class="form-sellmedicine3-heading">Please select Medicine by Generic Drug: </h2>
			<h1>Medicine Registered: </h1>
			<table border="1">
				<thead>
					<th>ID Medicine</th>
					<th>Name</th>
					<th>Description</th>
				</thead>
				<tbody>
					<%
						for( Medicine me : lista) {
					%>
							<tr>
								<td><% out.println(me.getidMedicine()); %></td>
								<td><% out.println(me.getname()); %></td>
								<td><% out.println(me.getdescription()); %></td>
							</tr>
					<%
						}
					%>
				</tbody>
			</table>
			<br>
			<br>
			<label for="inputMedicineName" class="sr-only">Medicine name: </label>
			<input name="medicineName" id="inputMedicineName" class="form-control" placeholder="" required="" autofocus=""> 
			<br>
			<br>
			<br>
			<br>
			<input type='submit' name="getPresentations" value='Search Presentation' />
		</form>
	</div>
</body>
</html>
