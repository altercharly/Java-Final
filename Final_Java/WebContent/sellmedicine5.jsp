<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="entities.*"%>
   <%@page import="java.util.*"%> 
    <% 
 Item item = new Item();
    Professional prof = new Professional();
    Medicine med = new Medicine();
    item=(Item)request.getAttribute("item");
    HttpSession mysession= (HttpSession) request.getSession();
    prof= (Professional) mysession.getAttribute("professional");
    
    HttpSession mysession2= (HttpSession) request.getSession();
    med= (Medicine) mysession.getAttribute("medicine");
 
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
	<div class='body-container'>
		<form class="form-sellmedicine5" action="sellmedicine5" method="post">
        	<h2 class="form-sellmedicine5-heading">Please : </h2>
        	     <% out.println("Professional Name: "+prof.getsurname()+", "+prof.getname()); %>
        	     <br>
        	<br> 
        	     <% out.println("Medicine name: "+med.getname()); %>
        	     <br>
        	<br> 
        	     <% out.println("Stock Medicine: "+item.getcantStock()); %>
        	     <br>
        	<br> 
        	     <% out.println("Price: "+item.getprice()); %>
        	<br>
        	<br> 
        	 <label for="inputCantItem" class="sr-only">Items number: </label>
        	<input name="cantItem" id="inputCantItem" class="form-control" placeholder="" required="" autofocus=""> 
        	<br>
        	<br>
        	<input type='submit' name="setCantItem" value='Select' />
</body>
</html>