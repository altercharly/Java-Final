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

@WebServlet("/addmedicine")
public class Addmedicine extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Addmedicine() {
    	super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ArrayList<GenericDrug> gdrugs = new ArrayList<GenericDrug>();
		Controller ctrl = new Controller();
		gdrugs=ctrl.getAllGenericDrug();
		GenericDrug prueba = new GenericDrug();
		 prueba = (GenericDrug)gdrugs.get(0);
		 System.out.println(prueba.getdrugName());
		                
          request.setAttribute("gdrugs", gdrugs);
          RequestDispatcher despachador = request.getRequestDispatcher("addmedicine.jsp");
          despachador.forward(request, response);
	
          
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		System.out.println("llegué");
		
		ArrayList<GenericDrug> gdrugs = new ArrayList<GenericDrug>();
		Controller ctrl = new Controller();
		gdrugs=ctrl.getAllGenericDrug();
		
		GenericDrug prueba = new GenericDrug();
		 prueba = (GenericDrug)gdrugs.get(0);
		 System.out.println(prueba.getdrugName());
		                
          request.setAttribute("gdrugs", gdrugs);
          RequestDispatcher despachador = request.getRequestDispatcher("addmedicine.jsp");
          despachador.forward(request, response);
		
		
		
		
		
		
		String name=request.getParameter("name");
		String description = request.getParameter("description");
		String idDrug = request.getParameter("iddrug");
	    
		
	    Medicine medicine = new Medicine();
	    medicine.setname(name);
	    medicine.setdescription(description);
	    GenericDrug gdrug = new GenericDrug();
	    gdrug.setidDrug(Integer.parseInt(idDrug));
	    medicine.setgenericDrugs(gdrug);
	   ctrl.addMedicine(medicine);	    
		
			
			//HttpSession session = request.getSession(true);
			//session.setAttribute("userSession", patient);
			//request.getRequestDispatcher(".jsp").forward(request, response);
		
			System.out.println("Medicine Added!");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/addpatient.jsp");
	        dispatcher.forward(request, response);
			response.sendRedirect("addmedicine.jsp");
		}
	}


