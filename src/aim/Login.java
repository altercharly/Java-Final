package aim;

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
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Login() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Controller controller = new Controller();

		String userInput = request.getParameter("user");
		String passwordInput = request.getParameter("password");
		String nextPage = "";
		
		try {
			Integer userDni = Integer.parseInt(userInput);
			
			if (controller.validateUser(userDni, passwordInput)) {
				User user = new User();
				user.setEmail(userInput);
				user.setPassword(passwordInput);
				
				HttpSession session = request.getSession(true);
				session.setAttribute("userSession", user);
				nextPage = "menu.jsp";
			} else {
				nextPage = "login.jsp";
				request.setAttribute("errorMessage", "User DNI or password incorrect");
			}
		} catch (NumberFormatException e) {
			nextPage = "login.jsp";
			request.setAttribute("errorMessage", "Please enter only numbers in user (DNI)");
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(nextPage);
		dispatcher.forward(request, response);
	}
}
