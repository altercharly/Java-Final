<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="entities.*"%>
<%@page import="java.util.*"%>
<%
	ArrayList<GenericDrug> lista= new ArrayList<GenericDrug>();
	lista=(ArrayList<GenericDrug>)request.getAttribute("gdrugs");
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
		<p class='header-tittle'> UTN Pharmacy </p>
	</div>
	<div class='body-container'>
		<form class="form-addmedicine" action="addmedicine" method="post">
        	<h2 class="form-addmedicine-heading">Please register new medicine</h2>
			<h1>Generic Drugs Registered: </h1>        
            <table border="1">
				<thead>
					<th>ID Drug</th>
					<th>Name</th>
                </thead>
                <tbody>
					<%
						for( GenericDrug gen : lista) {
					%>
							<tr>
								<td><% out.println(gen.getidDrug()); %></td>
								<td><% out.println(gen.getdrugName());  %></td>
							</tr>
					<%
						}
					%>
				</tbody>
			</table>
			<br>
			<br>
			<label for="inputDrug" class="sr-only">ID Drug :</label>
			<input name="iddrug" id="inputIdDrug" class="form-control" placeholder="" required="" autofocus="">
			<br>
			<br>
			<label for="inputName" class="sr-only">Comercial Names :</label>
			<input name="name" id="inputName" class="form-control" placeholder="" required="" autofocus=""> 
			<br>
			<br>
			<label for="inputDescription" class="sr-only">Drescription :</label>
			<input name="description" id="inputDescription" class="form-control" placeholder="" required="" autofocus=""> 
			<br>
			<br>
			<button class="btn" type="submit">Register</button>
		</form>
	</div>
</body>
</html>
