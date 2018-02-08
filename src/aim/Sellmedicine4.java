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

@WebServlet("/sellmedicine4")
public class Sellmedicine4 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Sellmedicine4() {
    	super();}
    
        // TODO Auto-generated constructor stub
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		// TODO Auto-generated method stub
    		response.getWriter().append("Served at: ").append(request.getContextPath());
    		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/sellmedicine4.jsp");
            dispatcher.forward(request, response);
    	}

    	
    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		// TODO Auto-generated method stub
    		//doGet(request, response);
    		
    		System.out.println("llegué");
    		HttpSession mysession= (HttpSession) request.getSession();
    		 
    		Medicine medicine= (Medicine) mysession.getAttribute("medicine");	
    		int idMedicine= medicine.getidMedicine();
    		
    		String idPresentation=request.getParameter("idPresentation");
    		int idpres = Integer.parseInt(idPresentation);
    		business.Controller ctrl = new Controller();
    		Item item = new Item();
    		item=ctrl.getItem(idMedicine, idpres);
    		
    		System.out.println("Item selected!");
    		  
    		HttpSession mysession2= request.getSession(true);
      		mysession2.setAttribute("itemsel",item);
    		String regNumberP=request.getParameter("regNumberP");
    	Professional prof = new Professional();
    	int regNumber = Integer.parseInt(regNumberP);
    	prof=ctrl.getProfessional(regNumber);
    	System.out.println("Professional selected!: "+prof.getsurname());
    	
    		HttpSession mysession3= request.getSession(true);
      		mysession3.setAttribute("professional",prof);
    		
    		 request.setAttribute("item", item);
	          RequestDispatcher despachadorr = request.getRequestDispatcher("sellmedicine5.jsp");
	          despachadorr.forward(request, response);
    		
    
    		}
    	}
