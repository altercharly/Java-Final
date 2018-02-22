<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="entities.*"%>
<%@page import="java.util.*"%>
<%
	ArrayList<Presentation> lista= new ArrayList<Presentation>();
	lista=(ArrayList<Presentation>)request.getAttribute("pres");
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
		<form class="form-sellmedicine4" action="sellmedicine4" method="post">
			<h2 class="form-sellmedicine4-heading">Please select Medicine Presentation: </h2>
			<h1>Medicine Presentation Registered: </h1>
			<table border="1">
				<thead>
					<th>ID Presentation</th>
					<th>Description</th>
				</thead>
				<tbody>
					<%
						for( Presentation pre : lista) {
					%>
							<tr>
								<td><% out.println(pre.getIdPresentation()); %></td>
								<td><% out.println(pre.getDescription());  %></td>
							</tr>
					<%
						}
					%>
				</tbody>
			</table>
			<br>
			<br>
			<label for="inputIdPresentation" class="sr-only">ID Presentation: </label>
			<input name="idPresentation" id="inputIdPresentation" class="form-control" placeholder="" required="" autofocus="">
			<br>
			<br>
			<label for="inputRNP" class="sr-only">Reg. Number Professional: </label>
			<input name="regNumberP" id="inputRNP" class="form-control" placeholder="" required="" autofocus=""> 
			<br>
			<br>
			<br>
			<br>
			<input type='submit' name="setPresentation" value='Select' />
		</form>
	</div>
</body>
</html>
