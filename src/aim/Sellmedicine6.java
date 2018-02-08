package aim;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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

@WebServlet("/sellmedicine6")
public class Sellmedicine6 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Sellmedicine6() {
    	super();}
    
        // TODO Auto-generated constructor stub
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		// TODO Auto-generated method stub
    		response.getWriter().append("Served at: ").append(request.getContextPath());
    		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/sellmedicine6.jsp");
            dispatcher.forward(request, response);
    	}

    	
    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		// TODO Auto-generated method stub
    		//doGet(request, response);
	
    HttpSession mysession1= (HttpSession) request.getSession();
    Patient patient= (Patient) mysession1.getAttribute("patient");
    		
	HttpSession mysession4= (HttpSession) request.getSession();
	Professional prof= (Professional) mysession4.getAttribute("professional");
	    
	 HttpSession mysession2= (HttpSession) request.getSession();
	 Medicine med= (Medicine) mysession2.getAttribute("medicine");
	 
	 HttpSession mysession3= (HttpSession) request.getSession();
	 Item item= (Item) mysession3.getAttribute("itemsel");
	 
	 HttpSession mysession5= (HttpSession) request.getSession();
	 int cantItems= (int) mysession5.getAttribute("cantItems");
	 
	 Controller ctrl = new Controller();
	 double total = cantItems*(double)item.getprice();
	 Prescription p = new Prescription();
	 p.setidItem(item.getidItem());
	 p.setidpatient(patient.getidPatient());
	 p.setidproffesional(prof.getidProffesional());
	 Calendar date = Calendar.getInstance();
	 Date prescdate = date.getTime();
	 p.setprescriptionDate(prescdate);
	 p.setTotal(total);
	 int idPrescription = ctrl.setPrescription(p);
	 Prescription_Item pi = new Prescription_Item();
	 pi.setCantItem(cantItems);
	 pi.setIdItem(item.getidItem());
	 pi.setidPrescription(idPrescription);
	 ctrl.setPrescription_Item(pi);
	 ctrl.updateCantItem(item, cantItems);
	 
	 RequestDispatcher despachadorr = request.getRequestDispatcher("sellmedicine7.jsp");
     despachadorr.forward(request, response);
	

	}
}
