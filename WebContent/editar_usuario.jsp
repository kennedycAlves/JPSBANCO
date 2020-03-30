<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
  %>
  
 <%@page import="java.sql.*"%>
 <%@page import="model.entities.Cliente"%>
 <%@page import="db.*"%>
 <%@page import="model.dao.*" %>
 <%@page import="model.dao.impl.ClienteDAOJDBC" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String cpf = request.getParameter("cpf");


ResultSet rsResultado;

Cliente cliente = new Cliente();


ClienteDAO clientedao = DaoFactory.creteClienteDAO();


rsResultado = clientedao.FindByCPF(cpf);

cliente.setNome(rsResultado.getString("NOME"));
cliente.setAgencia(rsResultado.getInt("AGENCIA"));
cliente.setConta(rsResultado.getInt("CONTA"));
cliente.setEndereco(rsResultado.getString("ENDERECO"));
cliente.setLimite(rsResultado.getFloat("LIMITE"));

out.println("<h2> Edição cliente "+cliente.getNome()+"</h2>");
out.println("<form name='Atulizar Dados' method='post' action='atualizarCliente?cpf="+cpf+"'");
out.println("<p>Endereço atual: "+cliente.getEndereco()+"<br> Novo Endereco: <input name='endereco' type='text' maxlength='20' size='20'></p>");
out.println("<p>Agencia atual: "+cliente.getAgencia()+"<br> Nova Agencia: <input name='agencia' type='text' maxlength='20' size='20'></p>");
out.println("<p>Conta atual: "+cliente.getconta()+" <br> Nova Conta:<input name='conta' type='text' maxlength='20' size='20'></p>");
out.println("<p>Limite atual: "+cliente.getLimite()+"<br> Novo Limite:<input name='limite' type='text' maxlength='20' size='20'></p>");
out.println("<br>");
out.println("<input name='btnConfirmar' value='Atualizar' type='submit'>");
out.println("</form>");
out.println("<a href='executaLogin'>[Sair]</a>");




%>

<h2>Confirmar atulizações</h2>
<% 

%>

</body>
</html>