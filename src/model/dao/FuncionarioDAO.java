package model.dao;

import java.sql.ResultSet;
import java.util.List;

import model.entities.Funcionario;

public interface FuncionarioDAO {
	
	void insert(Funcionario obj);
	void update(Funcionario obj);
	void deleteById(Integer id);
	Funcionario findByid(Integer id);
	ResultSet findAll();
	ResultSet login(Integer matricula);
	

}
