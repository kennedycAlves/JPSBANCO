package model.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import db.*;
import db.DbException;
import model.dao.FuncionarioDAO;
import model.entities.Cliente;
import model.entities.Funcionario;

public class FuncionarioDAOJDBC implements FuncionarioDAO{
	
	private Connection conn;
	
		
	
	public FuncionarioDAOJDBC(Connection connection) {
		this.conn = connection;
	}
	

	@Override
	public void insert(Funcionario obj) {
		PreparedStatement st = null;
		
		
		try {
			st = (PreparedStatement) conn.prepareStatement("INSERT INTO FUNCIONARIO (NOME, ENDERECO, MATRICULA, CPF) "
									+ " values (?, ?, ?, ?)",
										Statement.RETURN_GENERATED_KEYS);
			
			st.setString(1, obj.getNome());
			st.setString(2, obj.getEndereco());
			st.setInt(3, obj.getMatricula());
			st.setString(4, obj.getCpf());
			
			
			
			int lines = st.executeUpdate();
			
			if(lines > 0) {
				
				ResultSet rs = st.getGeneratedKeys();
				
				if(rs.next()) {
					int matr =rs.getInt(1);
					obj.setMatricula(matr);
					System.out.println("Matricula inserido: " + matr);
				}DB.closeResultSet(rs);
				
				
			}else {
				throw new DbException("Nenhuma linha afetada");
			}
					
		}catch (SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st);
			
			
			
		
		}
		
	}

	@Override
	public void update(Funcionario obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	

	@Override
	public ResultSet findAll() {
		PreparedStatement psComando;
		ResultSet rsResultado;
		String sqlComando = "SELECT * FROM FUNCIONARIO ORDER BY NOME";
		
		try {
			psComando = (PreparedStatement) conn.prepareStatement(sqlComando);
			rsResultado = psComando.executeQuery();
			return rsResultado;
		}catch (SQLException e) {
			throw new DbException(e.getMessage());
		}

	}
	
	@Override
	public ResultSet login(Integer matricula) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			String sql = ("SELECT * FROM FUNCIONARIO WHERE MATRICULA = ?");
			

			st = (PreparedStatement) conn.prepareStatement(sql);
			
			st.setInt(1, matricula);
			rs = st.executeQuery();
			
			
			
								
				if(rs.next()) {
					
					
					Funcionario obj = new Funcionario();
					obj.setNome(rs.getString("NOME"));
					obj.setCpf(rs.getString("CPF"));
					obj.setEndereco(rs.getString("ENDERECO"));
					obj.setMatricula(rs.getInt("MATRICULA"));
							
		}
			
		
		}catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		
		
		return rs;

	}


	@Override
	public Funcionario findByid(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}


	


}
