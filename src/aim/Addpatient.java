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

@WebServlet("/addpatient")
public class Addpatient extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Addpatient() {
    	super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Controller controller = new Controller();
		ArrayList<HealthPlan> healthPlans = new ArrayList<HealthPlan>();
		healthPlans = controller.getAllHealthPlan();
		request.setAttribute("hplans", healthPlans);
		RequestDispatcher dispatcher = request.getRequestDispatcher("addpatient.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		System.out.println("llegu�");
		
		business.Controller ctrl = new Controller();
		String name=request.getParameter("name");
		String surname = request.getParameter("surname");
		String affiliateNHP = request.getParameter("affiliateNHP");
	    String birthdate = request.getParameter("birthdate");
	    String healthPlanId = request.getParameter("healthPlanId");
	    
	    Patient patient = new Patient();
	    patient.setname(name);
	    patient.setsurname(surname);
	    SimpleDateFormat formateText = new SimpleDateFormat("dd-MM-yyy");
	    Date date = null;
	    try {
			date=formateText.parse(birthdate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    patient.setbirthdate(Integer.parseInt(birthdate));
	    patient.setaffiliateNumberHP(Integer.parseInt(affiliateNHP));
	    patient.setHealthPlanId(Integer.parseInt(healthPlanId));
	    
	    
	   ctrl.addPatient(patient);
	    
		
			
			//HttpSession session = request.getSession(true);
			//session.setAttribute("userSession", patient);
			//request.getRequestDispatcher(".jsp").forward(request, response);
		
			System.out.println("Patient Added!");
			RequestDispatcher despachadorr = request.getRequestDispatcher("menu.jsp");
	          despachadorr.forward(request, response);
		}
	}

