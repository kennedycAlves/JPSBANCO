package model.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.ClienteDAO;
import model.dao.DaoFactory;
import model.entities.Cliente;
import db.*;

/**
 * Servlet implementation class Operacoes
 */
@WebServlet("/Operacoes")
public class Operacoes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Operacoes() {
        super();
        // TODO Auto-generated constructor stub
    }
    
   
    static int tipooper;
    static String cpfCLI;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int tipoOperacao = Integer.parseInt(request.getParameter("TipoOperacao"));
		String cpf = (String) getServletContext().getAttribute("cpf");
		cpfCLI = cpf;
		tipooper = tipoOperacao;
		if(tipoOperacao == 1) {
			
			
			
			PrintWriter out = response.getWriter();
			out.println("<!DocType html>");
	    	out.println("<html>");
	    	out.println("<head>");
	    	out.println("<title>Deposito</title>");
	    	out.println("</head>");
	    	out.println("<body>");
	    	out.println(cpf);
	    	out.println("<form name='formDeposito' action='Operacoes' method='post'>");
	    	out.println("<p>Valor do Deposito<input name='valor' type='number' id='quantity'></p>");
	    	out.println("<input type='submit' name='btrPesquisar' value='depositar'/>");
	    	out.println("</form>"); 
	    	out.println("<br>");
	    	
	    	try{
				
				ResultSet rsResultado2;
				Cliente cliente = new Cliente();
				ClienteDAO clientedao = DaoFactory.creteClienteDAO();
		
				
				rsResultado2 = clientedao.FindByCPF(cpfCLI);
				
				out.println("<table border='1'>");
				out.println("<tr>");
				out.println("<th>CPF</th>");
				out.println("<td>"+rsResultado2.getString("CPF")+"</td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<th>Nome</th>");
				out.println("<td>"+rsResultado2.getString("NOME")+"</td>"); 
				out.println("</tr>");
				out.println("<tr>");
				out.println("<th>Endereço</th>");
				out.println("<td>"+rsResultado2.getString("ENDERECO")+"</td>"); 
				out.println("</tr>");
				out.println("<tr>");
				out.println("<th>Agencia</th>");
				out.println("<td>"+rsResultado2.getString("AGENCIA")+"</td>"); 
				out.println("</tr>");
				out.println("<tr>");
				out.println("<th>Conta</th>");
				out.println("<td>"+rsResultado2.getString("CONTA")+"</td>"); 
				out.println("</tr>");
				out.println("<tr>");
				out.println("<th>Limite</th>");
				out.println("<td>"+rsResultado2.getString("LIMITE")+"</td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<th>Saldo</th>");
				out.println("<td>"+rsResultado2.getString("SALDO")+"</td>");
				out.println("</tr>");
				out.println("</table>");
				out.println("<br>");
	    	
	    	}catch (Exception e) {
					out.println(e);
	    	}
	    	
	    	out.println("</body>");
			out.println("</html>");
	    	
			
			
		}
		
		if(tipoOperacao == 2) {
			
			
			
			PrintWriter out = response.getWriter();
			out.println("<!DocType html>");
	    	out.println("<html>");
	    	out.println("<head>");
	    	out.println("<title>Transferência</title>");
	    	out.println("</head>");
	    	out.println("<body>");
	    	out.println(cpf);
	    	out.println("<form name='formSaque' action='Operacoes' method='post'>");
	    	out.println("<p>Valor do Saque<input name='valor' type='number' id='quantity'></p>");
	    	out.println("<input type='submit' name='btrPesquisar' value='Sacar'/>");
	    	out.println("</form>"); 
	    	out.println("<br>");
	    	
	    	try{
				
				ResultSet rsResultado2;
				Cliente cliente = new Cliente();
				ClienteDAO clientedao = DaoFactory.creteClienteDAO();
		
				
				rsResultado2 = clientedao.FindByCPF(cpfCLI);
				
				out.println("<table border='1'>");
				out.println("<tr>");
				out.println("<th>CPF</th>");
				out.println("<td>"+rsResultado2.getString("CPF")+"</td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<th>Nome</th>");
				out.println("<td>"+rsResultado2.getString("NOME")+"</td>"); 
				out.println("</tr>");
				out.println("<tr>");
				out.println("<th>Endereço</th>");
				out.println("<td>"+rsResultado2.getString("ENDERECO")+"</td>"); 
				out.println("</tr>");
				out.println("<tr>");
				out.println("<th>Agencia</th>");
				out.println("<td>"+rsResultado2.getString("AGENCIA")+"</td>"); 
				out.println("</tr>");
				out.println("<tr>");
				out.println("<th>Conta</th>");
				out.println("<td>"+rsResultado2.getString("CONTA")+"</td>"); 
				out.println("</tr>");
				out.println("<tr>");
				out.println("<th>Limite</th>");
				out.println("<td>"+rsResultado2.getString("LIMITE")+"</td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<th>Saldo</th>");
				out.println("<td>"+rsResultado2.getString("SALDO")+"</td>");
				out.println("</tr>");
				out.println("</table>");
				out.println("<br>");
	    	
	    	}catch (Exception e) {
					out.println(e);
	    	}
	    	
	    	out.println("</body>");
			out.println("</html>");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(tipooper == 1) {
			Float valor = Float.parseFloat(request.getParameter("valor"));
			PrintWriter out = response.getWriter();
			
			try{
				
				ResultSet rsResultado;
				Cliente cliente = new Cliente();
				ClienteDAO clientedao = DaoFactory.creteClienteDAO();
			
			
				cliente.setCpf(cpfCLI);
				
				rsResultado = clientedao.FindByCPF(cpfCLI);
				
				cliente.setLimiteLiberado(rsResultado.getFloat("LIMITELIBERADO"));
				cliente.setSaldo(Float.parseFloat(rsResultado.getString("SALDO")));
				cliente.setLimite(Float.parseFloat(rsResultado.getString("LIMITE")));
				
			
				
			
				
				
				
				out.println("<!DocType html>");
		    	out.println("<html>");
		    	out.println("<head>");
		    	out.println("<title>Deposito</title>");
		    	out.println("</head>");
		    	out.println("<body>");
		    	out.println(cliente.depositar(cliente, valor));
		    	out.println("<p>Limite atualizado");
		    	out.println(cpfCLI);
		    	out.print(cliente.getSaldo());
		    	out.println("</body>");
		    	out.println("</html>");
		    	clientedao.updateSaldo(cliente);
				
				
				
			}catch (Exception e) {
				out.println(e);
				
			}
			
		}

		if(tipooper == 2) {
			Float valor = Float.parseFloat(request.getParameter("valor"));
			PrintWriter out = response.getWriter();
			
			try{
				
				ResultSet rsResultado;
				Cliente cliente = new Cliente();
				ClienteDAO clientedao = DaoFactory.creteClienteDAO();
			
			
				cliente.setCpf(cpfCLI);
				
				rsResultado = clientedao.FindByCPF(cpfCLI);
				
				
				cliente.setSaldo(rsResultado.getFloat("SALDO"));
				cliente.setLimite(rsResultado.getFloat("LIMITE"));
				
				
			
							
				out.println("<!DocType html>");
		    	out.println("<html>");
		    	out.println("<head>");
		    	out.println("<title>Saque</title>");
		    	out.println("</head>");
		    	out.println("<body>");
		    	out.println(cliente.sacar(cliente, valor));
		    	out.println("<p>Saldo atualizado");
		    	out.println(cpfCLI);
		    	out.print(cliente.getSaldo());
		    	out.println("</body>");
		    	out.println("</html>");
		    	
		    	clientedao.updateSaldo(cliente);
		    	
				
				
				
			}catch (Exception e) {
				out.println(e);
				
			}
			
		}
		
	
	}


}
