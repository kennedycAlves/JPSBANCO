package model.entities;

import java.util.ArrayList;
import java.lang.Math;
import model.entities.Funcionario;

public class Cliente extends ClassPessoaBanco{
	
	private Integer agencia , id;
	private Integer conta;
	private float saldo, limite, limiteLiberado;
	private static float SALDOLIMITE;
	
	private Integer funcionario;
	
	public Cliente() {
		
	}
	
	
	
	
	public Cliente(String nome, String endereco, String cpf,  Integer agencia, Integer conta, float limite) {
		super(nome, cpf, endereco);
		this.agencia = agencia;
		this.conta = conta;
		this.limite = limite;
		
		
		
	}
	
	public Cliente(String endereco,  Integer agencia, Integer conta, float limite, String cpf) {
		super (endereco, cpf);
		this.agencia = agencia;
		this.conta = conta;
		this.limite = limite;
		
		
		
	}
	
	public Cliente(String nome, String endereco,  Integer agencia, Integer conta, float limite,float limiteLiberado, String cpf, Integer funcionario) {
		super (nome, cpf, endereco);
		this.agencia = agencia;
		this.conta = conta;
		this.limite = limite;
		this.limiteLiberado = limiteLiberado;
		this.funcionario = funcionario;
		
		
	}
	
	
	
	
	public int getFuncionario() {
		return funcionario;
	}




	public void setFuncionario(int funcionario) {
		this.funcionario = funcionario;
	}




	public Integer getAgencia() {
		return this.agencia;
	}
	
	public void setAgencia(Integer agencia) {
		this.agencia = agencia;
	}
	
	public int getconta() {
		return this.conta;
	}
	
	public void setConta(int conta) {
		this.conta = conta;
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
	
	public float getLimiteLiberado() {
		return this.limiteLiberado;
	}
	
	public void setLimiteLiberado(float limiteLiberado) {
		this.limiteLiberado = limiteLiberado;
	}
	
		
	
	
	
	

//	public void cadstrar(String nome, String cpf, String endereco) {
//		this.setNome(nome);
//		this.setCpf(cpf);
//		this.setEndereco(endereco);
//		this.conta = this.conta + 1;
//		this.agencia = 5830;
//		
//		Cliente cl1 = new Cliente(null, nome, cpf, endereco, this.agencia, this.conta);
//		
//		cliente.add(cl1);
//		
//	}
	
	

	
	public String sacar(Cliente obj, float valor, int oper) {
		
	  try {
		String mensagem = null;
		
		if(valor <= (obj.getSaldo() + obj.getLimite())) {
			
			
							
			if(obj.getSaldo() >= valor) {
				
				
				System.out.println("primeiro if");	
				System.out.println(obj.getSaldo());
				obj.setSaldo(-valor);
				if (oper == 2) {
					mensagem = "Saque realizado com sucesso";
					
				}if (oper == 3) {
					mensagem = "Foram tranferidos ";
					
				}
			
			} else if(obj.getSaldo() < valor && obj.getLimite() >= valor || (obj.getSaldo() + obj.getLimite() >= valor)) {
				System.out.println("Segundo if");	
				System.out.println(obj.getSaldo());
				float i;
				for(i = valor; i > obj.getSaldo(); i--) {
				}
				System.out.println("I vale: " + i);
				
				float var2 = valor - i;		
				System.out.println(var2);
				
				float var3 = obj.getLimite() - var2;
				System.out.println(var3);
				
				obj.setSaldo(-i);
				
				
				obj.setLimite(var3);
				if (oper == 2) {
					mensagem = "Saque realizado com sucesso";
					
				}if (oper == 3) {
					mensagem = "Foram tranferidos ";
					
				}
				
				
				
			}
			
	
			
		}else {
			mensagem = "Saldo insuficiente";
			
		}
		return mensagem;
		}catch(NumberFormatException e) {
			return e.getMessage() + "Formato de dados inseridos incompatível!";
		}
		
	}
	
	 public  String  depositar(Cliente obj, float valor, int oper) {
		 
		String menssagem = null;
		
	 try {
		if (obj.getLimite() < obj.getLimiteLiberado()) { 	
		 	if((valor + obj.getLimite()) < obj.getLimiteLiberado()) {
		 		float var = obj.getLimite() + valor;
		 		obj.setLimite(var);
			}else {
				float var = obj.getLimiteLiberado() - obj.getLimite();
				obj.setLimite(obj.getLimiteLiberado());
				obj.setSaldo(valor - var);
			}
			
		if(oper == 1) {
			menssagem = "Depósito realizado com sucesso!";	
		}if(oper == 3) {
			menssagem = "Para a conta: ";
		}
			
		} else {
			System.out.println(obj.getSaldo());
			obj.setSaldo(+valor);
			System.out.println("Caiu no segundo if");
			System.out.println(obj.getSaldo());
			
			if(oper == 1) {
				menssagem = "Depósito realizado com sucesso!";	
			}if(oper == 3) {
				menssagem = "Para a conta: ";
			}	
			
			}	
		return menssagem;
	 }catch(NumberFormatException e) {
		 return e.getMessage() + " Formato de dados inseridos incompatível";
	 }

	}
	 
	 
	 public void VerSaldo(Cliente obj) {
		 System.out.println("Saldo: " + obj.getSaldo());
		 System.out.println("Limite: " + obj.getLimite());
		 
	 }




	@Override
	public String toString() {
		return "Cliente [agencia=" + agencia + ", conta=" + conta + ", saldo=" + saldo + ", limite=" + limite
				+ ", Gerente=" + funcionario + "] " ;
	}

			
}
		
		
	


