
package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import DBConnection.DBConnect;

public class RegisterServlet extends HttpServlet {
	String user = null;

	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger(RegisterServlet.class.getName());

	public RegisterServlet() {
	}

	DBConnect db = new DBConnect();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String loginuser = (String) session.getAttribute("loginuser");
		if ((loginuser == null) || (loginuser == "")) {
			request.setAttribute("registerloginerror", "Please login and try again. ");
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		} else {
			String firstname = request.getParameter("firstname");
			String lastname = request.getParameter("lastname");
			String address = request.getParameter("address");
			String product = request.getParameter("product");
			String quantity = request.getParameter("quantity");

			String userRegistered;
			try {
				log.info("*******Registering an order********");
				db.connect();
				userRegistered = db.registerData(loginuser, firstname, lastname, address, product, quantity);
				String[] split = userRegistered.split("~");
				String id = split[1];
				String status = split[0];

				if (status.equalsIgnoreCase("success")) {
					request.setAttribute("id", id);
					request.getRequestDispatcher("/ordersuccess.jsp").forward(request, response);
					log.info("*******Order ID generated*******" + id + firstname);
				} else

				{
					request.setAttribute("registererror", "Error occured while placing order, Please try again. ");
					request.getRequestDispatcher("/error.jsp").forward(request, response);
					log.info("*******Error in placing the oreder*******");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

}