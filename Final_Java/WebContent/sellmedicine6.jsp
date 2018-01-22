<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="entities.*"%>
   <%@page import="java.util.*"%> 
    <% 
 Item item = new Item();
    Professional prof = new Professional();
    Medicine med = new Medicine();
    HttpSession mysession3= (HttpSession) request.getSession();
    Double cantPrice = (double)request.getAttribute("calcPrice");
    HttpSession mysession1= (HttpSession) request.getSession();
    item= (Item) mysession1.getAttribute("itemsel");
    
    HttpSession mysession= (HttpSession) request.getSession();
    prof= (Professional) mysession.getAttribute("professional");
    
    HttpSession mysession2= (HttpSession) request.getSession();
    med= (Medicine) mysession.getAttribute("medicine");
    
    HttpSession mysession5= (HttpSession) request.getSession();
	 int cantItems= (int) mysession5.getAttribute("cantItems");
 
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
		<p class='header-tittle'> Detail </p>
	</div>
	<div class='body-container'>
		<form class="form-sellmedicine6" action="sellmedicine6" method="post">
        	<h2 class="form-sellmedicine6-heading">Please confirm the sale: </h2>
        	
        	     <% out.println("Professional Name: "+prof.getsurname()+", "+prof.getname()); %>
        	     <br>
        	<br> 
        	     <% out.println("Medicine name: "+med.getname()); %>
        	     <br>
        	<br> 
        	     <% out.println("Selected items: "+cantItems); %>
        	     <br>
        	<br> 
        	     <% out.println("Calculated price: "+ cantPrice); %>
        	<br>
        	<br> 
        	     
        	 
        	<input type='submit' name="registerSale" value='Register' />
        	 </form>
	</div>
</body>
</html>