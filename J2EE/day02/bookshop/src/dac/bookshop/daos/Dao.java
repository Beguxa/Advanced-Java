package dac.bookshop.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Dao {
	public static String DB_DRIVER = "";
	public static String DB_URL = "";
	public static String DB_USER = "";
	public static String DB_PASS = "";

	protected Connection con;
	protected PreparedStatement stmt;
	
	public void open() throws Exception {
		con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
	}

	public void close() {
		try {
			con.close();
		} catch (Exception e) {
		}
	}
}
