package db;

import java.sql.*;

import db.conexaoBancoDados;

public class especialidades {

	private Connection conBanco;
	private PreparedStatement psComando;
	private ResultSet rsResult;
	
	
	public void configurarConexao(Connection conBanco) {
		this.conBanco = conBanco;
	}
	
	
	public boolean inserirRegistro(String strDescricao) {
		String strComandoSQL;
		conBanco = conexaoBancoDados.obterConexao();
		try {
			strComandoSQL = "INSERT INTO clinica_medica_especialidades(Descricao_Especialidade) VALUE('"+strDescricao+"')";
			psComando = conBanco.prepareStatement(strComandoSQL);
			psComando.executeUpdate();
			return true;
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	public boolean alterarRegistro(int idCodigo, String strDescricao) {
		String strComandoSQL;
		try{
			strComandoSQL = "UPDATE clinica_medica_especialidades  SET Descricao_Especialidade = '"+strDescricao+"' WHERE Codigo_Especialidade = '"+idCodigo+"'";
			psComando = conBanco.prepareStatement(strComandoSQL);
			psComando.executeUpdate();
			return true;
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	public boolean excluirRegistro(int intCodigo, String strDescricao) {
		String strComandoSQL;
		try {
			strComandoSQL = "DELETE FROM clinica_medica_especialidades WHERE Codigo_Especielaidade = '"+intCodigo+"'";
			psComando = conBanco.prepareStatement(strComandoSQL);
			psComando.executeUpdate();
			return true;
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public ResultSet listarRegistros(String strOrdem) {
		String strComandoSQL;
		try {
			if(strOrdem == "CÓDIGO") {
				strComandoSQL = "SELECT * FROM clinica_medica_especialidades ORDER BY Codigo_Especialidade";
			}else {
				strComandoSQL = "SELECT * FROM clinica_medica_especialidades ORDER BY Descricao_Especialidade";
			}
			psComando = conBanco.prepareStatement(strComandoSQL);
			rsResult = psComando.executeQuery();
			return rsResult;
			
				
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
}
