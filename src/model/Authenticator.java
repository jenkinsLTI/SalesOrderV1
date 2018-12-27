package model;

import java.sql.SQLException;
import java.util.HashMap;

import org.apache.log4j.Logger;

import DBConnection.DBConnect;


public class Authenticator {

	static HashMap<String, String> credentials = new HashMap<>();
	DBConnect db = new DBConnect();
	static Logger log = Logger.getLogger(Authenticator.class.getName());
	public String authenticate(String username, String password) throws SQLException {
		log.info("*******Authentication*******");
		db.connect();
		String status = db.authenticate(username, password);
		return status;
	}
}