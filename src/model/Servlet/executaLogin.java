package model.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import db.DB;
import db.DbException;
import model.dao.ClienteDAO;
import model.dao.DaoFactory;
import model.entities.Cliente;
import model.entities.Funcionario;
import model.dao.FuncionarioDAO;

/**
 * Servlet implementation class executa_login
 */
@WebServlet(name = "executaLogin", urlPatterns = {"/executaLogin"})
public class executaLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public executaLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
    
    //Esse método, irá validar o login e senha fornecidos pelo formulário do login.jsp
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String validaTipo = (request.getParameter("TipoLogin"));
		Integer tipoLogin = Integer.parseInt(request.getParameter("TipoLogin"));
		
		
		if (tipoLogin == 1) {
			
		
			ResultSet rsResultado = null;
		
			PrintWriter out;
			String cpf;
			
			cpf = request.getParameter("cpf");
			
			HttpSession sessao = request.getSession();
			
			response.setContentType("text/html");
			
			out = response.getWriter();
			
			out.println("<!DocType html>");
	    	out.println("<html>");
	    	out.println("<head>");
	    	out.println("<title>Validar Login</title>");
	    	out.println("</head>");
	    	out.println("<body>");
			
			try {
				
							
				ClienteDAO clientedao = DaoFactory.creteClienteDAO();
	    		
	    		
				rsResultado = clientedao.login(cpf);
				
				
				if(request.getParameter("cpf").equals(rsResultado.getString("CPF")) && request.getParameter("senha").equals("123456")) {
					sessao.setAttribute("usuario_logado", "true");
					sessao.setAttribute("nome_usuario", rsResultado.getString("NOME"));
					out.println("<h2>Bem Vindo "+rsResultado.getString("NOME"));
					out.println("<br><br>");
					out.println("<a href='executaLogin'> Sair</a>");
					//out.println("<a href=\""+response.encodeURL("operacoes.jsp?cpf="+cpf+"")+"\">Realizar Operações</a>");
					//A linha abaixo torna o atributo CPF visivel todos os Servlets da aplicação.
					getServletContext().setAttribute("cpf", cpf);
					//out.println("<a href='operacoes.jsp'>Realizar Operações</a>");
					
					response.sendRedirect("operacoes.jsp");
				
				
				}else {
					out.println("<p>Usuário ou senhas inválidos</p>");
					out.println("<a href='login.jsp'>Tentar Novamente</a>");
				}	
				
	    	
			}catch(Exception e) {
				DbException var = new DbException("<p>Usuário ou senhas inválidos</p><a href='login.jsp'>Tentar Novamente</a>");
				//getServletContext().setAttribute("usuario_logado", "false");  
				out.print(var);
			}	
    	
			out.println("</body>");
			out.println("</html>");	
		}
		
		if (tipoLogin == 2) {
			
			ResultSet rsResultado = null;
		
			PrintWriter out;
			
			
			Integer matricula = Integer.parseInt(request.getParameter("cpf"));
			
			HttpSession sessao = request.getSession();
			
			response.setContentType("text/html");
			
			out = response.getWriter();
			
			out.println("<!DocType html>");
	    	out.println("<html>");
	    	out.println("<head>");
	    	out.println("<title>Validar Login</title>");
	    	out.println("</head>");
	    	out.println("<body>");
			
			try {
				
							
				FuncionarioDAO funciodao = DaoFactory.creteFuncionarioDAO();
	    		
	    		
				rsResultado = funciodao.login(matricula);
				
				
				if(matricula == rsResultado.getInt("MATRICULA") && request.getParameter("senha").equals("123456")) {
					sessao.setAttribute("usuario_logado", "true");
					sessao.setAttribute("nome_usuario", rsResultado.getString("NOME"));
					out.println("<h2>Bem Vindo "+rsResultado.getString("NOME"));
					out.println("<br><br>");
					out.println("<a href='executaLogin'> [Sair]</a>");
					//out.println("<a href=\""+response.encodeURL("operacoes.jsp?cpf="+cpf+"")+"\">Realizar Operações</a>");
					//A linha abaixo torna o atributo CPF visivel todos os Servlets da aplicação.
					//getServletContext().setAttribute("cpf", matricula);
					out.println("<a href='pesquisar_cliente.jsp'>[Gerenciar Clientes]</a>");
					out.println("<a href='cadastro.jsp'>[Cadastrar novo Cliente]</a>");
					out.println("<a href='cadastroFuncionario.html'>[Cadastrar novo Funcionário]</a><br>");
					out.println("<a href='cadastro-agencias.jsp'>[Cadastrar nova Agencia]</a>");
					
					
				
				
				}else {
					out.println("<p>Usuário ou senhas inválidos</p>");
					
					out.println("<a href='login.jsp'>Tentar Novamente</a>");
				}	
				
	    	
			}catch(Exception e) {
				DbException var = new DbException("<p>Usuário ou senhas inválidos</p><a href='login.jsp'>Tentar Novamente</a>");
				//getServletContext().setAttribute("usuario_logado", "false"); 
				out.print(var);
				 
				 
			}	
    	
			out.println("</body>");
			out.println("</html>");	
		}
		
		if (validaTipo.equals("")) {
			
			
		
			PrintWriter out;
			
			response.setContentType("text/html");
			
			out = response.getWriter();
			
			out.println("<!DocType html>");
	    	out.println("<html>");
	    	out.println("<head>");
	    	out.println("<title>Validar Login</title>");
	    	out.println("</head>");
	    	out.println("<body>");
	    	out.println("Error!!");
	    	out.println("Favor escolher o tipo de login (Cliente ou Funcionario)");
	    	out.println("<a href='login.jsp'>Tentar Novamente</a>");
	    	out.println("</body>");
			out.println("</html>");	

		}
	}
	
	
	
	
	//metodo para executar a finalização do login do usuário
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out;
		response.setContentType("text/html");
		out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title></title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<p>Sessão encerrada..</p>");
		out.println("<a href='login.jsp'> Voltar a tela de login</a>");
		
		HttpSession sessao = request.getSession();
		sessao.setAttribute("usuario_logado", "false");
		getServletContext().setAttribute("usuario_logado", "false");
		sessao.invalidate();
		
		out.println("</body>");
		out.println("</html>");
	}

}