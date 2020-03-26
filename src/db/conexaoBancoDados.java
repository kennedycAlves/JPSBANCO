package db;
import java.sql.*;

public class conexaoBancoDados {
	
	
	static Connection conBanco;
	
	public boolean abrirConexao(){
		
		String url = "jdbc.mysql://127.0.0.1/banco?user=root&password=1q2w3e4r,";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conBanco = DriverManager.getConnection(url);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	public boolean fecharConexao() {
		try {
			conBanco.close();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static Connection obterConexao() {
		return conBanco;
	}
	
	public static void closeStatement(Statement st) {
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}

	public static void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}

}


