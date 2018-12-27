package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

public class LogoutServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger(LogoutServlet.class.getName());
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		log.info("*******Trying to Logout*******");
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
			session = null;
		}
		request.setAttribute("message", "Logged out Successfully");
		request.getRequestDispatcher("login.jsp").forward(request, response);
		log.info("*******Logged out successfully*******");
	}

}
