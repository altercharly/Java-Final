package aim;

import java.io.IOException;
import java.util.ArrayList;

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

	public Sellmedicine2() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/sellmedicine2.jsp").forward(request, response);
	}	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String drugName=request.getParameter("gDrugName");
    		business.Controller ctrl = new Controller();
    		GenericDrug gdrug = new GenericDrug();
    		gdrug=ctrl.getGenericDrug(drugName);
    		System.out.println("Generic Drug selected!");
    		ArrayList<Medicine> medicines = new ArrayList<Medicine>();
    		medicines=ctrl.getMedicineByDrug(gdrug.getidDrug());
    		
    	
    		 request.setAttribute("medicines", medicines);
	          request.getRequestDispatcher("/WEB-INF/sellmedicine3.jsp").forward(request, response);
    		
    
    		}
    	}

