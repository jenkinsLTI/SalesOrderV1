package controller;

import java.io.IOException;
import java.sql.SQLException;
ad

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import model.Authenticator;
import model.User;

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginController() {
		super();
	}

	static Logger log = Logger.getLogger(LoginController.class.getName());

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		session.setAttribute("loginuser", username);


		RequestDispatcher rd = null;

		Authenticator authenticator = new Authenticator();
		String result;
		try {
			log.info("*******Login Started*******");
			result = authenticator.authenticate(username, password);
			if (result.equals("success")) {
				rd = request.getRequestDispatcher("/homepage.jsp");
				User user = new User(username, password);
				request.setAttribute("user", user);
				request.setAttribute("loginuser", username);
				log.info("*******User Logged in*******");
			} else {
				request.setAttribute("loginerror", "Login Failed, Please try again");
				rd = request.getRequestDispatcher("/error.jsp");
				log.info("*******Login failure*******");
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		}

		rd.forward(request, response);
	}

}
