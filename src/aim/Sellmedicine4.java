package aim;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import business.*;
import entities.*;

@WebServlet("/sellmedicine4")
public class Sellmedicine4 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Sellmedicine4() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/sellmedicine4.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		HttpSession mysession = (HttpSession) request.getSession();
    		Medicine medicine= (Medicine) mysession.getAttribute("medicine");	
    		int idMedicine= medicine.getidMedicine();
    		
    		String idPresentation=request.getParameter("idPresentation");
    		int idpres = Integer.parseInt(idPresentation);
    		business.Controller ctrl = new Controller();
    		Item item = new Item();
    		item=ctrl.getItem(idMedicine, idpres);
    		
    		System.out.println("Item selected!");
      		mysession.setAttribute("itemsel",item);
    		String regNumberP=request.getParameter("regNumberP");
    		Professional prof = new Professional();
    		int regNumber = Integer.parseInt(regNumberP);
    		prof=ctrl.getProfessional(regNumber);
    		System.out.println("Professional selected!: "+prof.getsurname());
      		mysession.setAttribute("professional",prof);

		request.setAttribute("item", item);
		request.getRequestDispatcher("/WEB-INF/sellmedicine5.jsp").forward(request, response);
	}
}
