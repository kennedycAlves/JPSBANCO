package model.dao;

import java.sql.ResultSet;

import model.entities.Agencia;;

public interface AgenciaDAO {
	
	void insert(Agencia obj);
	void update(Agencia obj);
	void deleteById(Integer id);
	ResultSet findByCOD(Integer id);
	ResultSet findAll();
	

}
