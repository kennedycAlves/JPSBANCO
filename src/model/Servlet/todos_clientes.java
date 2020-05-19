package model.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.*;
import model.entities.Cliente;
import model.dao.ClienteDAO;
import model.dao.DaoFactory;

/**
 * Servlet implementation class todos_clientes
 */
@WebServlet("/todos_clientes")
public class todos_clientes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public todos_clientes() {
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
		
		ResultSet rsResultado = null;
		
		PrintWriter out;
				
		response.setContentType("text/html");
		out = response.getWriter();
		out.println("<!DocType html>");
    	out.println("<html>");
    	out.println("<head>");
    	out.println("<title></title>");
    	out.println("</head>");
    	out.println("<body>");
    	
    	try {
    		ClienteDAO clientedao = DaoFactory.creteClienteDAO();
    		
    		
    		rsResultado = clientedao.findAll();
    		
    		out.println("<table aling='center' border='1' >");
    		out.println("<tr>");
    		out.println("<th>Ações</th><th>CPF</th><th>Nome</th><th>Endereço</th><th>Agencia</th><th>Conta</th><th>Saldo</th><th>Limite</th>");
    		out.println("</tr>");
    		while(rsResultado.next()) {
    			
    			List<String> cpf = new ArrayList();
    			cpf.add(rsResultado.getString("CPF"));
    			for(String numCPF : cpf) {
    				out.println("<tr>");
    				out.println("<td><a href='editar_usuario.jsp?cpf="+numCPF+"'>[Editar]</a><a href='excluir_usuario.jsp?cpf="+numCPF+"'>[Excluir]</a></td>");
    				out.println("<td>"+rsResultado.getString("CPF")+"</td> ");
    				out.println("<td>"+rsResultado.getString("NOME")+"</td>");
    				out.println("<td>"+rsResultado.getString("ENDERECO")+"</td>");
    				out.println("<td>"+rsResultado.getInt("AGENCIA")+"</td>");
    				out.println("<td>"+rsResultado.getInt("CONTA")+"</td>");
    				out.println("<td>"+rsResultado.getFloat("SALDO")+"</td>");
    				out.println("<td>"+rsResultado.getFloat("LIMITE")+"</td>");
    				out.println("</tr>");
    			}	
    		}
    		
    		out.println("</table>");
    		out.println("<a href='executaLogin'>[Sair]</a>");
    		out.println("<a href='pesquisar_cliente.jsp'> [Nova Pesquisa]</a>");
    		
    		
    		
    		
		
    	}catch (Exception e) {
    		out.println(e);
    	}
    	
    	out.println("</body>");
		out.println("</html>");

	}
}
