package aim;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

@WebServlet("/sellmedicine1")
public class Sellmedicine1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Sellmedicine1() {
    	super();}
    
        // TODO Auto-generated constructor stub
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		// TODO Auto-generated method stub
    		response.getWriter().append("Served at: ").append(request.getContextPath());
    		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/sellmedicine1.jsp");
            dispatcher.forward(request, response);
    	}

    	
    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		// TODO Auto-generated method stub
    		//doGet(request, response);
    		
    		System.out.println("llegué");
    		
    		business.Controller ctrl = new Controller();
    		String healthPlanId=request.getParameter("healthPlanId");
    		String affiliateNHP = request.getParameter("affiliateNumberHP");
    	
    		HealthPlan hplan = new HealthPlan();
    		hplan=ctrl.getHealthPlan(Integer.parseInt(healthPlanId));	
    		System.out.println("HealthPlan selected!");
    		
    		Patient patient = new Patient();
    		patient=ctrl.getPatient(Integer.parseInt(affiliateNHP));
    		System.out.println("Patient selected!");
 
    		
    		
    		boolean answer = ctrl.validatecantmaxPrescription(Integer.parseInt(healthPlanId), patient.getidPatient());
    		if(answer=true){
    			System.out.println("Patient can buy medicine!");
    			//saves the Patient in Session
    			HttpSession mysession= request.getSession(true);
          		mysession.setAttribute("patient",patient);
    			
    			System.out.println("Patient name:" + patient.getname() + "Health Plan name" + hplan.getnameHP());
    		}else{
    			System.out.println("Patient can't buy medicine! Sorry");
    		}
    		
    		 RequestDispatcher despachador = request.getRequestDispatcher("sellmedicine2.jsp");
	          despachador.forward(request, response);
    		}
    	}


