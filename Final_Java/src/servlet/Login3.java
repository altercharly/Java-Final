package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.*;
import business.*;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login3")
public class Login3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Login3() {
       super();
    	// TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		User u = new User();
       
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/sigin.html");
        dispatcher.forward(request, response);
        
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		//response.getWriter().append(email).append(": ").append(pass);
		
		Controller ctrl = new Controller();
		
		
		String user=request.getParameter("user");
		String pass=request.getParameter("pass");
		User u = new User();
		Boolean answer = ctrl.validateUser(Integer.parseInt(user));
		if (answer != false){
			
			HttpSession session = request.getSession(true);
			System.out.println("Se encontró el usuario!");
			//session.setAttribute("userSession", u);
			//request.getRequestDispatcher("redirected2.jsp").forward(request, response);
			 RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/sigin.html");
		        dispatcher.forward(request, response);
		} else {
			System.out.println("No se encontró el usuario ingresado");
			response.sendRedirect("signin2.html");
		}
	}

}