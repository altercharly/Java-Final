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

@WebServlet("/sellmedicine3")
public class Sellmedicine3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Sellmedicine3() {
    	super();}
    
        // TODO Auto-generated constructor stub
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		// TODO Auto-generated method stub
    		response.getWriter().append("Served at: ").append(request.getContextPath());
    		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/sellmedicine3.jsp");
            dispatcher.forward(request, response);
    	}

    	
    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		// TODO Auto-generated method stub
    		//doGet(request, response);
    		
    		System.out.println("llegué");
    		
    		String medicineName=request.getParameter("medicineName");
    		business.Controller ctrl = new Controller();
    		Medicine medicine = new Medicine();
    		medicine=ctrl.getMedicineByName(medicineName);
    		
    		ArrayList<Presentation> pres = new ArrayList<Presentation>();
    		pres=ctrl.getPresentationByMedicine(medicine.getidMedicine());
    		
    		System.out.println("Presentations selected!");
    		   		
    	
    		HttpSession mysession= request.getSession(true);
      		mysession.setAttribute("medicine",medicine);
    		
    		 request.setAttribute("pres", pres);
	          RequestDispatcher despachador = request.getRequestDispatcher("sellmedicine4.jsp");
	          despachador.forward(request, response);
    		
    
    		}
    	}

