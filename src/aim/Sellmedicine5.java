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

@WebServlet("/sellmedicine5")
public class Sellmedicine5 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Sellmedicine5() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/sellmedicine5.jsp").forward(request, response);
	}

    	
    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		HttpSession mysession = (HttpSession) request.getSession();
    		Medicine medicine = (Medicine) mysession.getAttribute("medicine");
    		int idMedicine = medicine.getidMedicine();
    		String cantItem = request.getParameter("cantItem");
    		int cantItems = Integer.parseInt(cantItem);
    		
      		mysession.setAttribute("cantItems",cantItems);
    		System.out.println("Items registered: " + cantItems);

    		Item item= (Item) mysession.getAttribute("itemsel");
	    	business.Controller ctrl = new Controller();
	    	double calcPrice = (double)ctrl.calcPriceItem(item, cantItems);
		request.setAttribute("calcPrice", calcPrice);
		request.getRequestDispatcher("/WEB-INF/sellmedicine6.jsp").forward(request, response);
	}
}
