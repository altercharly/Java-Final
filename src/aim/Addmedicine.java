package aim;

import java.io.IOException;
import java.util.ArrayList;

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
		
		ArrayList<GenericDrug> genericDrugs = new ArrayList<GenericDrug>();
		Controller controller = new Controller();
		genericDrugs = controller.getAllGenericDrug();
		request.setAttribute("gdrugs", genericDrugs);
		RequestDispatcher dispatcher = request.getRequestDispatcher("addmedicine.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		System.out.println("llegu�");
		
		ArrayList<GenericDrug> gdrugs = new ArrayList<GenericDrug>();
		Controller ctrl = new Controller();
		gdrugs=ctrl.getAllGenericDrug();
		
		GenericDrug prueba = new GenericDrug();
		 prueba = (GenericDrug)gdrugs.get(0);
		 System.out.println(prueba.getdrugName());
		                
          request.setAttribute("gdrugs", gdrugs);
          RequestDispatcher despachadorr = request.getRequestDispatcher("menu.jsp");
          despachadorr.forward(request, response);
		
		
		
		
		
		
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


