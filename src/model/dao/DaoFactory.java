package model.dao;

import db.DB;
import model.dao.impl.AgenciaDAOJDBC;
import model.dao.impl.ClienteDAOJDBC;
import model.dao.impl.FuncionarioDAOJDBC;


public class DaoFactory {

	
	public static  ClienteDAO creteClienteDAO() {
		return new ClienteDAOJDBC(DB.getConnection());
	}

	
	public static  FuncionarioDAO creteFuncionarioDAO() {
		return new FuncionarioDAOJDBC(DB.getConnection());
	}
	
	
	public static  AgenciaDAO creteAgenciaDAO() {
		return new AgenciaDAOJDBC(DB.getConnection());
	}
	
	
}
