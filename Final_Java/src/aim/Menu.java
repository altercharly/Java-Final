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

@WebServlet("/menu")
public class Menu extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Menu() {
    	super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/addpatient.jsp");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		System.out.println("llegué");
		
		if (request.getParameter("addmedicine") != null) {
			business.Controller ctrl = new Controller();
			ArrayList<GenericDrug> gdrugs = new ArrayList<GenericDrug>();
			
			gdrugs=ctrl.getAllGenericDrug();
			
			GenericDrug prueba = new GenericDrug();
			 prueba = (GenericDrug)gdrugs.get(0);
			 System.out.println(prueba.getdrugName());
			                
	          request.setAttribute("gdrugs", gdrugs);
	          RequestDispatcher despachador = request.getRequestDispatcher("addmedicine.jsp");
	          despachador.forward(request, response);
			
	} else if (request.getParameter("sellmedicine1") != null) {
	            //seria la venta del medicamento
		RequestDispatcher despachador = request.getRequestDispatcher("sellmedicine1.jsp");
        despachador.forward(request, response);
		
	} else if (request.getParameter("addpatient") != null) {
	          //agrega paciente
		RequestDispatcher despachador = request.getRequestDispatcher("addpatient.jsp");
        despachador.forward(request, response);
	}
		
		
		
		
		
		
		
		
		
		
	}}