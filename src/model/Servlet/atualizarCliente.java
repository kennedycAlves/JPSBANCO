package model.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.entities.Cliente;
import db.*;
import model.dao.impl.ClienteDAOJDBC;
import model.dao.AgenciaDAO;
import model.dao.ClienteDAO;
import model.dao.DaoFactory;

/**
 * Servlet implementation class atualizarCliente
 */
@WebServlet("/atualizarCliente")
public class atualizarCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public atualizarCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sessao = request.getSession();
		String statusSessao = (String) sessao.getAttribute("usuario_logado");
		 
		if(statusSessao.contentEquals("false") || statusSessao == null) {
			  response.sendRedirect("login.jsp");
		 }

		String RecebeEndereco, RecebeAgencia, RecebeConta, RecebeLimite;
		PrintWriter out;
		
		
		
		String cpf = request.getParameter("cpf");
		RecebeEndereco = request.getParameter("endereco");
		RecebeAgencia = request.getParameter("agencia");
		RecebeConta = request.getParameter("conta");
		RecebeLimite =request.getParameter("limite");
		
		Integer agencia; 	
		Integer conta; 	
		Integer funcionario;
		Float limite;	
		Float limiteLiberado;
		
			
		response.setContentType("text/html");
		out = response.getWriter();
		out.println("<!DocType html>");
    	out.println("<html>");
    	out.println("<head>");
    	out.println("<title>Atualizar cliente</title>");
    	out.println("</head>");
    	out.println("<body>");
    	
    	out.println("          "+RecebeAgencia+"      ");
		
		
		try {
			//Bloco de validação dos campos vindo do formulário
			// rsResultado vai no banco e recupera do dados já salvo no baco e aloca nos parâmetros do objeto
			ResultSet rsResultado;
					

			ClienteDAO sellerdao = DaoFactory.creteClienteDAO();
			
			rsResultado = sellerdao.FindByCPF(cpf);
						
			
				
			if(RecebeEndereco == "") {
				RecebeEndereco = rsResultado.getString("ENDERECO");
			}
			
			
			
			if(RecebeAgencia == "") {
				agencia = rsResultado.getInt("AGENCIA");
				funcionario = rsResultado.getInt("F_MATRICULA");
			}else {
				agencia = Integer.parseInt(request.getParameter("agencia"));
				AgenciaDAO agedao = DaoFactory.creteAgenciaDAO();
				
				ResultSet rsResultado2 = agedao.findByCOD(agencia);
				funcionario = rsResultado2.getInt("F_MATRICULA");
			}
			
			
			
			if(RecebeConta == "") {
				conta = rsResultado.getInt("CONTA");
			}else {
				conta 	= Integer.parseInt(RecebeConta);
			}
			
			
			//if(RecebeLimite == "") {
				limite = rsResultado.getFloat("LIMITE");
			//}else {
			//	 limite = Float.parseFloat(RecebeLimite);		
			//}
			
			if(RecebeLimite == "") {
				limiteLiberado = rsResultado.getFloat("LIMITELIBERADO");
			}else {
				 limiteLiberado = Float.parseFloat(RecebeLimite);	
				
			}
			float recalc;
			if(limiteLiberado > limite) {
				 recalc = (limiteLiberado - limite) + limite;
			}else {
				recalc = limiteLiberado; 
			}
			
			//Termina valida e recuperação dos dados
			
			String nome =  null;
			
			//Com od dados recuperados e os novos dados vindo do formulario o update é feito
			Cliente cliente = new Cliente(nome, RecebeEndereco, agencia, conta, recalc, limiteLiberado, cpf, funcionario);
			sellerdao.update(cliente);
			
			out.println("<h2> Dados Atualizados</h2><br>");
			
			ResultSet rsResultado2;
			rsResultado2 = sellerdao.FindByCPF(cpf);
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
			out.println("<td>"+rsResultado2.getString("LIMITELIBERADO")+"</td>");
			out.println("<tr>");
			out.println("</table>");
			out.println("<br>");
			out.println("<a href=pesquisar_cliente.jsp>[Pesquisar novo usuário]</a>");
			out.println("<a href='editar_usuario.jsp?cpf="+cpf+"'>[Refazer atualizaçoes]</a>");
			
			
		
		}catch (Exception e) {
			out.println(e);
		}	
	
		
		
		out.println("</body>");
		out.println("</html>");
		
		
		
		
		
		
	}

}
