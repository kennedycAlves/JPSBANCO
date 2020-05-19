<%@page import="model.dao.DaoFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="db.DB" %>
<%@page import="model.entities.Cliente" %>
<%@page import="model.dao.impl.ClienteDAOJDBC" %>
<%@page import="model.dao.ClienteDAO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Excluir Cliente</title>
</head>
<body>
<%
HttpSession sessao = request.getSession();
String statusSessao = (String) sessao.getAttribute("usuario_logado");

if(!statusSessao.equals("true")){
	response.sendRedirect("executaLogin");
}
String cpf = request.getParameter("cpf");

try{
	ClienteDAO clientedao =  DaoFactory.creteClienteDAO();
	
	
	
	clientedao.deleteByCpf(cpf);
	
	out.println("<h3>Conta vinculada ao CPF "+cpf+" excluída com sucesso</h3>");
	out.println("<br>");
	out.println("<a href='pesquisar_cliente.jsp'>[Pesquisar novo usuário]</a>");
	//out.println("<a href='excluir_usuario.jsp?cpf="+cpf+"'>[Excluir]</a>");
	
}catch(Exception e){
	out.println(e);
	
}



%>

</body>
</html>