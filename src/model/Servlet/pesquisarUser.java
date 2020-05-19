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

import org.eclipse.jdt.internal.compiler.ast.Clinit;

import com.mysql.fabric.Response;

import db.*;
import model.dao.ClienteDAO;
import model.dao.DaoFactory;
import model.entities.Cliente;


/**
 * Servlet implementation class pesquisarUser
 */
@WebServlet("/pesquisarUser")
public class pesquisarUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public pesquisarUser() {
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
		String cpf;
		
		cpf = request.getParameter("cpf");
		
		response.setContentType("text/html");
		out = response.getWriter();
		out.println("<!DocType html>");
    	out.println("<html>");
    	out.println("<head>");
    	out.println("<title>Calculo da área de uma circuferência</title>");
    	out.println("</head>");
    	out.println("<body>");
    	
    	try {
    		ClienteDAO clientedao = DaoFactory.creteClienteDAO();
    		
    		
    		rsResultado = clientedao.FindByCPF(cpf);
    		
    		if(rsResultado != null) {
    		
    			out.println(rsResultado.getString("CPF") +" "+ rsResultado.getString("NOME"));
    			out.println("<a href='editar_usuario.jsp?cpf="+cpf+"'>[Editar]</a>");
    			out.println("<a href='excluir_usuario.jsp?cpf="+cpf+"'>[Excluir]</a>");
    		}
    		else {
    			out.print("Usuario não encontrado");
    		}
    		DB.closeResultSet(rsResultado);
    		
    		
    		
    	}catch (Exception e) {
			out.println(e);
		}	
    	
    	out.println("</body>");
		out.println("</html>");
    	
		
		
		
		
		
	}

}
