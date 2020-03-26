package model.entities;

import java.util.ArrayList;

public class Operacoes extends ClassPessoaBanco implements Runnable{
private float saldo, limite;
	
	//Contrutor
	public Operacoes(String nome, int cpf, String endereco, float saldo, float limite) {
		super(nome, cpf, endereco);
		this.saldo = saldo;
		this.limite = limite;

	}
	
	
	public float getSaldo() {
		return this.saldo;
	}
	
	public void setSaldo(float saldo) {
		this.saldo = this.saldo + saldo;
	}
	
	public float getLimite() {
		return this.limite;
	}
	
	public void setLimite(float limite) {
		this.limite = limite;
	}
	/**
	 * 
	 * @param sacar metodo para sacar
	 */
	
	//Métodos
	void sacar(float valor) {
		if(valor <= (this.saldo + this.limite)) {
			this.saldo = (this.saldo + this.limite) - valor;
			System.out.println("Saque realizado com sucesso");
		}else {
			System.out.println("Saldo insuficiente");
		}
		
	}
	
	 public synchronized void  depositar(float valor) {
		this.saldo = this.saldo + valor;
		

	}


	@Override
	public void run() {
		setSaldo(100f);;
		
		
	}
	
}


	
	

//	//ClassPessoaBanco  usuario = new ClassPessoaBanco(nome, cpf, endereco);
//	//ClassBancoPessoaCadastro obj = new ClassBancoPessoaCadastro(cpf, nome, endereco);
//	
//	 ArrayList<ClassCliente> clientes = new ArrayList<ClassCliente>();		
//	 
////	 ClassCliente cl1 = new ClassCliente("Kennedy", "2389748923", "hckjshkjzxc");
////	 ClassCliente cl2 = new ClassCliente("costa", "2389748923", "hckjshkjzxc");
////	 ClassCliente cl3 = new ClassCliente("alves", "2389748923", "hckjshkjzxc");
////	 
////	 clientes.add(cl1);
////	 clientes.add(cl3);
////	 clientes.add(cl3);
//	 
//	 
////	  System.out.println(clientes);
//	 }
	
	
	
