package model.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.entities.Cliente;
import model.entities.Funcionario;
import db.DB;
import db.DbException;
import model.dao.AgenciaDAO;
import model.dao.ClienteDAO;
import model.dao.DaoFactory;
import model.dao.impl.ClienteDAOJDBC;

/**
 * Servlet implementation class inserirCliente
 */
@WebServlet("/inserirCliente")
public class inserirCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public inserirCliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession sessao = request.getSession();
		String statusSessao = (String) sessao.getAttribute("usuario_logado");
		 
		if(statusSessao.contentEquals("false") || statusSessao == null) {
			  response.sendRedirect("login.jsp");
		 }
		
		Integer agencia, conta;
		Float saldo, limite;
		String cpf;
		String nome, endereco;
		PrintWriter out;
		Funcionario gerente;
		
		

		nome = request.getParameter("nome");
		endereco = request.getParameter("endereco");
		cpf = request.getParameter("cpf");
		agencia = Integer.parseInt(request.getParameter("agencia"));
		conta = Integer.parseInt(request.getParameter("agencia"));
		conta +=1;
		limite = Float.parseFloat(request.getParameter("limite"));
		
		
		
		
		response.setContentType("text/html;charset=UTF-8");
		out = response.getWriter();
    	out.println("<!DocType html>");
    	out.println("<html>");
    	out.println("<head>");
    	out.println("<title>Calculo da área de uma circuferência</title>");
    	out.println("</head>");
    	out.println("<body>");
		
		try {
			out.println(nome);
			ClienteDAO sellerdao = DaoFactory.creteClienteDAO();
			AgenciaDAO agedao = DaoFactory.creteAgenciaDAO();
			
			ResultSet rsResultado = agedao.findByCOD(agencia);
			
			Integer funcionario = rsResultado.getInt("F_MATRICULA");
			
			float limiteLiberado = limite;
			
			
			Cliente cliente = new Cliente(nome, endereco, agencia, conta, limite, limiteLiberado, cpf, funcionario);
			
			sellerdao.insert(cliente);
							
			out.println("<h2>Usuário cadastrado</h2>");	
							
		}catch (Exception e) {
				out.println(e);
		}	
		
		out.println("</body>");
		out.println("</html>");
		
		}
	
	
		
	}
	


