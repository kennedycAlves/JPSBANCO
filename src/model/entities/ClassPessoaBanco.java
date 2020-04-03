package model.entities;

public  class  ClassPessoaBanco {
	private String nome, endereco, cpf;
	
	
	
	
	
	public ClassPessoaBanco() {
		
	}
	
	

	//Contrutor
	public ClassPessoaBanco(String nome, String cpf, String endereco) {
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		
	

	}
	
	public ClassPessoaBanco(String endereco, String cpf) {
		this.endereco = endereco;
		this.cpf = cpf;
		
	

	}
	
	

	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return this.cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getEndereco() {
		return this.endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}



	
	


	
	

	


	
	
	
	
	
	
	
	
	
	
	
	
}	