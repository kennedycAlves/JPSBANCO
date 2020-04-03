package model.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

import db.DB;
import db.DbException;
import model.dao.AgenciaDAO;
import model.entities.Agencia;
import model.entities.Cliente;

public class AgenciaDAOJDBC implements AgenciaDAO{
	
	private Connection conn;
	
	public AgenciaDAOJDBC(Connection connection) {
		this.conn = connection;
	}

	@Override
	public void insert(Agencia obj) {
		PreparedStatement st = null;
		
		
		try {
			st = (PreparedStatement) conn.prepareStatement("INSERT INTO AGENCIA (COD, ENDERECO, F_MATRICULA, QTD_CONTAS) "
									+ " values (?, ?, ?, ?)",
										Statement.RETURN_GENERATED_KEYS);
			
			st.setInt(1, obj.getCod());
			st.setString(2, obj.getEndereco());
			st.setInt(3, obj.getGerente());
			st.setInt(4, obj.getQtdContas());
			
			
			
			int lines = st.executeUpdate();
			
			
				
			ResultSet rs = st.getGeneratedKeys();
				
				
			DB.closeResultSet(rs);
				
				
			
					
		}catch (SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st);
			
			
			
		
		}
		
	}

	@Override
	public void update(Agencia obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ResultSet findByCOD(Integer cod) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			String sql = ("SELECT * FROM AGENCIA WHERE COD = ?");
			

			st = (PreparedStatement) conn.prepareStatement(sql);
			
			st.setInt(1, cod);
			rs = st.executeQuery();
			
			
			
			if(rs.next()) {
				
							
				Agencia obj = new Agencia();
				obj.setCod(rs.getInt("COD"));
				obj.setEndereco(rs.getString("ENDERECO"));
				obj.setGerente(rs.getInt("F_MATRICULA"));
				obj.setQtdContas(rs.getInt("QTD_CONTAS"));
				
		}
		
		}catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		
		
		return rs;
	}

	@Override
	public ResultSet findAll() {
		PreparedStatement psComando;
		ResultSet rsResultado;
		String sqlComando = "SELECT * FROM AGENCIA ORDER BY COD";
		
		try {
			psComando = (PreparedStatement) conn.prepareStatement(sqlComando);
			rsResultado = psComando.executeQuery();
			return rsResultado;
		}catch (SQLException e) {
			throw new DbException(e.getMessage());
		}

	}

}
