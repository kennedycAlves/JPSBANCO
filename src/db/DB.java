package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.xml.transform.stream.StreamResult;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {
	
	private static Connection conn = null;
	
	public static Connection getConnection() {
		if(conn == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn =  DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/banco","root","1q2w3e4r,");
			
								
			}catch (Exception e) {
				e.printStackTrace();
				
			}
			
		}
		return conn;
	}
	
	public static void closeConnection() {
		if(conn != null) {
			try {
				conn.close();
			}
			catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	
	
	
	
	public static void closeStatement(Statement st) {
		if (st != null) {
			try {
				st.close();
			}catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	
	public static void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			}catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	
	
}
