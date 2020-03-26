package model.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class index
 */
@WebServlet("/index")
public class index extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public index() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out;
		HttpSession sessao = request.getSession();
		response.setContentType("text/html");
		
		out = response.getWriter();
		
		out.println("<!DocType html>");
    	out.println("<html>");
    	out.println("<head>");
    	out.println("<title>Index</title>");
    	out.println("</head>");
    	out.println("<body>");
    	if (sessao.isNew()) {
    		out.println("<a href=\""+response.encodeURL("login.jsp")+"\">Entrar</a>");
    		
    	}else {
    		out.println("Usuário Logado!");
    		out.println("<form action='index' method='post'>");
    		out.println("<input type='submit' value='sair'>");
    		out.println("</form>");
    		
    	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out;
		response.setContentType("text/html");
		out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Cálculo de áreas de figuras geométricas</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<p>Sessão encerrada..</p>");
		out.println("<a href='index'> Voltar</a>");
		
		HttpSession sessao = request.getSession();
		sessao.setAttribute("usuario_logado", null);
		sessao.invalidate();
		
		
		
		
		out.println("</body>");
		out.println("</html>");
	
	}

}
