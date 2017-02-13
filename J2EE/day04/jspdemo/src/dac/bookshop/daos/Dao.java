package dac.bookshop.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Dao {
	public static String DB_DRIVER = "com.mysql.jdbc.Driver";
	public static String DB_URL = "jdbc:mysql:///test";
	public static String DB_USER = "nilesh";
	public static String DB_PASS = "nilesh";

	protected Connection con;
	protected PreparedStatement stmt;
	
	static {
		try {
			Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
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
