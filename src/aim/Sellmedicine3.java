package aim;

import java.io.IOException;
import java.util.ArrayList;

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

	public Sellmedicine3() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/sellmedicine3.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
	          request.getRequestDispatcher("/WEB-INF/sellmedicine4.jsp").forward(request, response);
    		
    
    		}
    	}

