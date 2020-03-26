package model.dao;

import java.sql.ResultSet;
import java.util.List;

//import model.entities.Department;
import model.entities.Cliente;

public interface ClienteDAO {
	
	boolean insert(Cliente obj);
	void update(Cliente obj);
	void updateSaldo(Cliente obj);
	void deleteByCpf(String cpf);
	Cliente findByid(Integer id);
	Cliente FindByName(String name);
	ResultSet findAll();
	//List<Cliente> findByDepartment(Department department);
	ResultSet FindByCPF(String cpf);
	ResultSet login(String cpf);
	

}
