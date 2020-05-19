package model.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.entities.Funcionario;
import model.dao.FuncionarioDAO;
import model.dao.impl.FuncionarioDAOJDBC;
import model.dao.DaoFactory;
import db.DB;


/**
 * Servlet implementation class inserirFuncionario
 */
@WebServlet("/inserirFuncionario")
public class inserirFuncionario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public inserirFuncionario() {
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
		
		Integer matricula;
		String nome, endereco, cpf;
		PrintWriter out;
		Funcionario gerente = null;
	

		nome = request.getParameter("nome");
		endereco = request.getParameter("endereco");
		cpf = request.getParameter("cpf");
		matricula = Integer.parseInt(request.getParameter("matricula"));
		
		
		
		
		response.setContentType("text/html;charset=UTF-8");
		out = response.getWriter();
    	out.println("<!DocType html>");
    	out.println("<html>");
    	out.println("<head>");
    	out.println("<title></title>");
    	out.println("</head>");
    	out.println("<body>");
		
		try {
			
			FuncionarioDAO newfuncDAO = DaoFactory.creteFuncionarioDAO();
			Funcionario newFunc = new Funcionario(nome, endereco, matricula, cpf);
			newfuncDAO.insert(newFunc);
							
			out.println("<h2>Funcionario Cadastrado</h2>");	
							
			}catch (Exception e) {
				out.println(e);
			}	
		
		out.println("</body>");
		out.println("</html>");
		
		}
		
		
	}


