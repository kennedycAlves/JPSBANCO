package model.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import db.DB;
import db.DbException;
import model.dao.ClienteDAO;
import model.entities.Cliente;
import model.entities.Funcionario;

public class ClienteDAOJDBC implements ClienteDAO {
	
	
	
	private Connection conn;
	
	
	
	
	public ClienteDAOJDBC(Connection connection) {
		this.conn = connection;
	}




	@Override
	public boolean insert(Cliente obj) {
		// TODO Auto-generated method stub
		PreparedStatement st = null;
		
		
		try {
			
						
			conn = DB.getConnection();
			
			
			String sql = ("INSERT INTO CLIENTE (NOME, ENDERECO, CPF, AGENCIA, CONTA, LIMITE, LIMITELIBERADO, SALDO, F_MATRICULA) values (?, ?, ?, ?, ?, ?, ?, ?, ?)");
									
			
			st = (PreparedStatement) conn.prepareStatement(sql);
			
			st.setString(1, obj.getNome());
			st.setString(2, obj.getEndereco());
			st.setString(3,obj.getCpf());
			st.setInt(4, obj.getAgencia());
			st.setInt(5, obj.getconta());
			st.setFloat(6, obj.getLimite());
			st.setFloat(7, obj.getLimiteLiberado());
			st.setFloat(8, 0);
			st.setInt(9, obj.getFuncionario());
			
			
			st.executeUpdate();
			return true;
		
		}catch (SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st);
			
			
			
		
		}
			
		
		
	}




	@Override
	public void update(Cliente obj) {
		PreparedStatement st = null;
		Connection conn = null;
		
		try {
			DB.getConnection();
			
			conn = DB.getConnection();
			st = (PreparedStatement) conn.prepareStatement(
					"UPDATE CLIENTE "
				+ "SET ENDERECO = ?, AGENCIA = ?, CONTA = ?,  LIMITE = ?, LIMITELIBERADO = ?  "
				+ "WHERE CPF = ?"
				);
			
			
			st.setString(1, obj.getEndereco());
			st.setInt(2, obj.getAgencia());
			st.setInt(3, obj.getconta());
			st.setFloat(4, obj.getLimite());
			st.setFloat(5, obj.getLimiteLiberado());
			st.setString(6, obj.getCpf());
			
			
			int modiline = st.executeUpdate();	
			if(modiline > 0) {
				System.out.println(modiline + " Linha(s) Afetada(s)");
			}
			
			
		}catch (SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st);	
			
		}
		
		
		
	}




	@Override
	public void deleteByCpf(String cpf) {
		PreparedStatement st = null;
		
		try {
			st = (PreparedStatement) conn.prepareStatement("DELETE FROM CLIENTE WHERE CPF = ? ");
			
			st.setString(1, cpf);
			
			int lines = st.executeUpdate();
			if(lines > 0) {
				System.out.println(lines + " Linha afetada");
				
			}else
				System.out.println("Nenhum resgitro encontrado");
			
		}catch (SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st);	
			
		}
		
	}




	@Override
	public Cliente findByid(Integer id) {
		return null;
		
	}


	@Override
	public ResultSet findAll() {
		PreparedStatement psComando;
		ResultSet rsResultado;
		String sqlComando = "SELECT * FROM CLIENTE ORDER BY NOME";
		
		try {
			psComando = (PreparedStatement) conn.prepareStatement(sqlComando);
			rsResultado = psComando.executeQuery();
			return rsResultado;
		}catch (SQLException e) {
			throw new DbException(e.getMessage());
		}

	}

	@Override
	public Cliente FindByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public ResultSet FindByCPF(String cpf) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			String sql = ("SELECT * FROM CLIENTE WHERE CPF = ?");
			

			st = (PreparedStatement) conn.prepareStatement(sql);
			
			st.setString(1, cpf);
			rs = st.executeQuery();
			
			
			
			if(rs.next()) {
				
							
				Cliente obj = new Cliente();
				obj.setAgencia(rs.getInt("AGENCIA"));
				obj.setConta(rs.getInt("CONTA"));
				obj.setNome(rs.getString("NOME"));
				obj.setCpf(rs.getString("CPF"));
				obj.setEndereco(rs.getString("ENDERECO"));
				obj.setSaldo(rs.getFloat("SALDO"));
				obj.setLimite(rs.getFloat("LIMITE"));
				obj.setLimiteLiberado(rs.getFloat("LIMITELIBERADO"));
				
				
				
					
		}
			
			
			
			

		}catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		
		
		return rs;

	}	
	@Override
	public ResultSet login(String cpf) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			String sql = ("SELECT * FROM CLIENTE WHERE CPF = ?");
			

			st = (PreparedStatement) conn.prepareStatement(sql);
			
			st.setString(1, cpf);
			rs = st.executeQuery();
			
			
			
								
				if(rs.next()) {
					
					
					Cliente obj = new Cliente();
					obj.setAgencia(rs.getInt("AGENCIA"));
					obj.setConta(rs.getInt("CONTA"));
					obj.setNome(rs.getString("NOME"));
					obj.setCpf(rs.getString("CPF"));
					obj.setEndereco(rs.getString("ENDERECO"));
					obj.setSaldo(rs.getFloat("SALDO"));
					obj.setLimite(rs.getFloat("LIMITE"));
							
		}
			
		
		}catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		
		
		return rs;
		

	}




	@Override
	public void updateSaldo(Cliente obj) {
		PreparedStatement st = null;
		Connection conn = null;
		
		try {
			DB.getConnection();
			
			conn = DB.getConnection();
			st = (PreparedStatement) conn.prepareStatement(
					"UPDATE CLIENTE "
				+ "SET SALDO = ?, LIMITE = ?  "
				+ "WHERE CPF = ?"
				);
			
			
			st.setFloat(1, obj.getSaldo());
			st.setFloat(2, obj.getLimite());
			st.setString(3, obj.getCpf());
			
			
			
			int modiline = st.executeUpdate();	
			if(modiline > 0) {
				System.out.println(modiline + " Linha(s) Afetada(s)");
				System.out.println(obj.getCpf());
				System.out.println(obj.getSaldo());
				
			}
			
			
			
		}catch (SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st);	
			
		}
		
	}
	
}
