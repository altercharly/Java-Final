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

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Login() {
    	super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Controller controller = new Controller();

		String userInput = request.getParameter("user");
		String passwordInput = request.getParameter("password");
		String nextPage;
		
		try {
			Integer userDni = Integer.parseInt(userInput);
			
			if (controller.validateUser(userDni, passwordInput)) {
				User user = new User();
				user.setEmail(userInput);
				user.setPassword(passwordInput);
				
				HttpSession session = request.getSession(true);
				session.setAttribute("userSession", user);
				nextPage = "menu";
			} else {
				nextPage = "login";
				request.setAttribute("errorMessage", "User DNI or password incorrect");
			}
		} catch (NumberFormatException e) {
			nextPage = "login";
			request.setAttribute("errorMessage", "Please enter only numbers in user (DNI)");
		}

		request.getRequestDispatcher("/WEB-INF/" + nextPage + ".jsp").forward(request, response);
	}
}
