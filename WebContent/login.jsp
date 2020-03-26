<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
<%@page import="javax.servlet.http.*" %>

<%


HttpSession sessao = request.getSession();

//verifica se o uauário está logado, caso o parẽmtro usuario_logado for nulo, ele seta o parâmetro false//
if(sessao.getAttribute("usuario_logado") == null){
	sessao.setAttribute("usuario_logado", "false");
}//Caso o usuário estiver com parâmetro setado como false, o programa irá abrir o formulário de login, para que o usuário logue.
if (sessao.isNew() || sessao.getAttribute("usuario_logado").equals("false")){
	out.println("<form action='executaLogin' method='post'>");
	out.println("Usuário<input type='text' name='cpf' size='20' maxlength='20'><br>");
	out.println("Senha<input type='password' name='senha' size='20' maxlength='20'><br>");
	out.println("<p>Tipo de login:</p>");
	out.println("<input name='TipoLogin' value='1' type='radio'/>Cliente");
	out.println("<input name='TipoLogin' value='2' type='radio'/>Funcionarios<br>");
	out.println("<br><input type='submit' value='entrar'>");
	out.println("</form>");
	String cpf = request.getParameter("cpf");
	sessao.setAttribute("cpf", cpf);
	
	
			
}else{//se o usuário estiver com parãmetro true ele já estará logado
	out.println("<h2>Olá "+sessao.getAttribute("nome_usuario")+"</h2>");
	out.println("<a href='executaLogin'> Sair</a>");
	out.println("<a href='operacoes.jsp'>Realizar Operações</a>");
}
%>

</body>
</html>
