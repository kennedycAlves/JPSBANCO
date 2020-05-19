<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Buscar Clientes</title>
</head>
<body>
<%
HttpSession sessao = request.getSession();
String statusSessao = (String) sessao.getAttribute("usuario_logado");

if(!statusSessao.equals("true")){
	response.sendRedirect("executaLogin");
}
out.println("<form name='pesquisar' method='post' action='pesquisarUser'>");
out.println("<p>CPF do Cliente: <input name='cpf' type='text' maxlength='20' size='20'></p>");
out.println("<input type='submit' name='btrPesquisar' value='Pesquisar'/>");
out.println("</form>");
out.println("<br>");
out.println("<br>");

out.println("<form name='pesquisar' method='post' action='todos_clientes'>");
out.println("<input type='submit' name='btrPesquisarTodos' value='Pesquisar Todos os clientes'/>");
out.println("</form>");


%>

</body>
</html>