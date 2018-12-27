package DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;


import model.RegisterBean;

public class DBConnect {
	public Connection con;
	public PreparedStatement statement;
	public ResultSet rs;
	static Logger log = Logger.getLogger(DBConnect.class.getName());
	static int id = 0;

	public void connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/salesorder", "salesorder", "password");
			log.info("*******DB Connected*******");
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public String authenticate(String username, String password) throws SQLException {
		String status = "failure";
		statement = con.prepareStatement(
				"Select username,password from salesorder.credentials where username=? and password=?");
		statement.setString(1, username);
		statement.setString(2, password);
		rs = statement.executeQuery();
		if (rs.next()) {
			status = "success";
			log.info("*******Authentication Successful*******");
		}
		return status;

	}

	public String registerData(String loginuser, String firstname, String lastname, String address, String product,
			String quantity) throws SQLException {
		log.info("*******Inserting Data into Database********");
		String status = "failure";
		
		String orderid_query = "select order_id from salesorder.register_data order by order_id desc limit 1";
		Statement stmt = con.createStatement();
		rs = stmt.executeQuery(orderid_query);
		while (rs.next()) {
			id = rs.getInt(1);
			id = id + 1;
		}

		String insertQuery = "Insert into salesorder.register_data (order_id,user_name,first_name,last_name,address,product,quantity) values (?,?,?,?,?,?,?)";
		statement = con.prepareStatement(insertQuery);
		statement.setInt(1, id);
		statement.setString(2, loginuser);
		statement.setString(3, firstname);
		statement.setString(4, lastname);
		statement.setString(5, address);
		statement.setString(6, product);
		statement.setString(7, quantity);

		int result = statement.executeUpdate();
		if (result == 1) {

			status = "success~" + id;
			log.info("*******Order registered successfully*******");
		}

		return status;
	}

	public RegisterBean getData(String id) throws SQLException {

		RegisterBean bean = null;
		int number = Integer.parseInt(id);
		log.info("*******Fetch data from Database to view an order*******");
		String query = "select first_name,last_name,address,product,quantity from salesorder.register_data where order_id ="
				+ number;
		Statement stmt = con.createStatement();
		rs = stmt.executeQuery(query);
		while (rs.next()) {
			bean = new RegisterBean();
			bean.setFirstname(rs.getString("first_name"));
			bean.setLastname(rs.getString("last_name"));
			bean.setAddress(rs.getString("address"));
			bean.setProduct(rs.getString("product"));
			bean.setQuantity(rs.getString("quantity"));
		}

		return bean;
	}

}
