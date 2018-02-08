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

import business.*;
import entities.*;

@WebServlet("/sellmedicine2")
public class Sellmedicine2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Sellmedicine2() {
    	super();}
    
        // TODO Auto-generated constructor stub
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		// TODO Auto-generated method stub
    		response.getWriter().append("Served at: ").append(request.getContextPath());
    		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/sellmedicine2.jsp");
            dispatcher.forward(request, response);
    	}

    	
    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		// TODO Auto-generated method stub
    		//doGet(request, response);
    		
    		System.out.println("llegué");
    		
    		String drugName=request.getParameter("gDrugName");
    		business.Controller ctrl = new Controller();
    		GenericDrug gdrug = new GenericDrug();
    		gdrug=ctrl.getGenericDrug(drugName);
    		System.out.println("Generic Drug selected!");
    		ArrayList<Medicine> medicines = new ArrayList<Medicine>();
    		medicines=ctrl.getMedicineByDrug(gdrug.getidDrug());
    		
    	
    		 request.setAttribute("medicines", medicines);
	          RequestDispatcher despachador = request.getRequestDispatcher("sellmedicine3.jsp");
	          despachador.forward(request, response);
    		
    
    		}
    	}

