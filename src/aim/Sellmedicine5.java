package aim;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import business.*;
import entities.*;

@WebServlet("/sellmedicine5")
public class Sellmedicine5 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Sellmedicine5() {
    	super();}
    
        // TODO Auto-generated constructor stub
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		// TODO Auto-generated method stub
    		response.getWriter().append("Served at: ").append(request.getContextPath());
    		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/sellmedicine5.jsp");
            dispatcher.forward(request, response);
    	}

    	
    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		// TODO Auto-generated method stub
    		HttpSession mysession = (HttpSession) request.getSession();
    		Medicine medicine = (Medicine) mysession.getAttribute("medicine");
    		int idMedicine = medicine.getidMedicine();
    		String cantItem = request.getParameter("cantItem");
    		int cantItems = Integer.parseInt(cantItem);
    		
      		mysession.setAttribute("cantItems",cantItems);
    		System.out.println("Items registered: " + cantItems);

    		Item item= (Item) mysession.getAttribute("itemsel");
	    	business.Controller ctrl = new Controller();
	    	double calcPrice = (double)ctrl.calcPriceItem(item, cantItems);
		request.setAttribute("calcPrice", calcPrice);
		RequestDispatcher despachadorr = request.getRequestDispatcher("sellmedicine6.jsp");
		despachadorr.forward(request, response);
	}
}
