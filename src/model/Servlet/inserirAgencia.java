package model.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.entities.Agencia;
import model.dao.AgenciaDAO;
import model.dao.DaoFactory;
import model.dao.impl.AgenciaDAOJDBC;

/**
 * Servlet implementation class inserirAgencia
 */
@WebServlet("/inserirAgencia")
public class inserirAgencia extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public inserirAgencia() {
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
		
		Integer cod, gerente;
		String endereco;
		Integer qtdContas = 0;
		PrintWriter out;
		RequestDispatcher rd = null;
		
		cod = Integer.parseInt(request.getParameter("cod"));
		gerente = Integer.parseInt(request.getParameter("gerente"));
		endereco = request.getParameter("endereco");
		
		response.setContentType("text/html;charset=UTF-8");
		out = response.getWriter();
    	out.println("<!DocType html>");
    	out.println("<html>");
    	out.println("<head>");
    	out.println("<title>Calculo da área de uma circuferência</title>");
    	out.println("</head>");
    	out.println("<body>");
    	out.println(statusSessao);
		
		try{
			Agencia agn = new Agencia(endereco, cod, gerente, qtdContas);
		
		
			AgenciaDAO newagn = DaoFactory.creteAgenciaDAO();
			
			newagn.insert(agn);
			
			out.println("<h3>Agencia cadastrada com sucesso</h3>");	
			out.println("<br><p>Cadastre novas agências se desejar..</p>");
			
			rd = request.getRequestDispatcher("/cadastro-agencias.jsp");
			//rd.forward(request, response);
			rd.include(request,response);
			
		}catch (Exception e) {
				out.println(e);
		}	
		
		out.println("</body>");
		out.println("</html>");
		
		}
		
}


