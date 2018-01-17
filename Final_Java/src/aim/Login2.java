package aim;

import java.io.IOException;

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
@WebServlet("/login2")
public class Login2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Login2() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
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
		u.setEmail(user);
		u.setPassword(pass);
		Boolean answer = ctrl.validateUser(Integer.parseInt(user));
		if (answer != false){
			
			HttpSession session = request.getSession(true);
			System.out.println("Se encontró el usuario!");
			//session.setAttribute("userSession", u);
			//request.getRequestDispatcher("redirected2.jsp").forward(request, response);
		} else {
			System.out.println("No se encontró el usuario ingresado");
			response.sendRedirect("signin2.html");
		}
	}

}
