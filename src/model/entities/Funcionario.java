package model.entities;

public class Funcionario extends ClassPessoaBanco{
	
	private Integer matricula;
	
	
	
	public Funcionario() {
		
	}


	public Funcionario(String nome, String endereco,  Integer matricula, String cpf) {
		super(nome, cpf, endereco);
		this.matricula = matricula;
	}


	public Integer getMatricula() {
		return matricula;
	}


	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}


	@Override
	public String toString() {
		return  getNome();
	}


	

	


	





	







	

	

	
	
	
	

}
