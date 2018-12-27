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
import model.RegisterBean;

public class ViewController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger(ViewController.class.getName());

	public ViewController() {
		super();
	}

	DBConnect db = new DBConnect();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		HttpSession session = request.getSession();
		String loginuser = (String) session.getAttribute("loginuser");
		if ((loginuser == null) || (loginuser == "")) {
			request.setAttribute("viewloginerror", "Please login to view an order");
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		} else {

			RegisterBean bean;
			try {
				log.info("*******Trying to view an order*******");
				db.connect();
				if ((null != id) && !(id.equals("")) && !(id.equalsIgnoreCase("null"))) {
					bean = db.getData(id);

					if (null != bean) {
						String firstname = bean.getFirstname();
						String lastname = bean.getLastname();
						String address = bean.getAddress();
						String product = bean.getProduct();
						String quantity = bean.getQuantity();
						request.setAttribute("fn", firstname);
						request.setAttribute("ln", lastname);
						request.setAttribute("a", address);
						request.setAttribute("p", product);
						request.setAttribute("q", quantity);
						request.getRequestDispatcher("/display.jsp").forward(request, response);
						log.info("*******Order viewed successfully*******");
					} else {
						request.setAttribute("viewerror", "Order ID does not exsist, Please enter the correct ID");
						request.getRequestDispatcher("/error.jsp").forward(request, response);
						log.info("*******Error in viewing an order*******");
					}

				} else {
					request.setAttribute("viewerror", "Order ID does not exsist, Please enter the correct ID");
					request.getRequestDispatcher("/error.jsp").forward(request, response);
					log.info("*******Error in viewing an order*******");
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}
}
