package model.entities;

public class Agencia {
	
	String endereco;
	Integer cod, gerente, qtdContas;
	
	
	public Agencia(String endereco, Integer cod, Integer gerente, Integer qtdContas) {
		super();
		this.endereco = endereco;
		this.cod = cod;
		this.gerente = gerente;
		this.qtdContas = qtdContas;
	}
	
	public Agencia() {
		
	}


	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	public Integer getCod() {
		return cod;
	}


	public void setCod(Integer cod) {
		this.cod = cod;
	}


	public Integer getGerente() {
		return gerente;
	}


	public void setGerente(Integer gerente) {
		this.gerente = gerente;
	}


	public Integer getQtdContas() {
		return qtdContas;
	}


	public void setQtdContas(Integer qtdContas) {
		this.qtdContas = qtdContas;
	}
	
	
	public Integer somaContas(Integer qtdAtual) {
		Integer soma = qtdAtual + 1;
		return soma;
		
	}
	

}
