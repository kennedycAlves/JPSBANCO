<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
  %>
  
 <%@page import="java.sql.*"%>
 <%@page import="model.entities.Cliente"%>
 <%@page import="db.*"%>
 <%@page import="model.dao.*" %>
 <%@page import="model.dao.impl.ClienteDAOJDBC" %>
 <%@page import="model.entities.Agencia" %>
 <%@page import="model.dao.AgenciaDAO" %>
 <%@page import="model.dao.impl.AgenciaDAOJDBC" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table aling='center' border='1'>
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
out.println("<tr>");
out.println("<td><h3>Endereço atual: </h3>"+cliente.getEndereco()+"</td><td>Novo Endereco: <input name='endereco' type='text' maxlength='20' size='20'></td>");
out.println("</tr>");
out.println("<tr>");
out.print("<td><h3>Agencia atual: </h3>"+cliente.getAgencia()+"</td>");
out.print("<td>Selecione nova Agencia:  <SELECT name='agencia'>");


ResultSet rsResultado2;

try {
	
	
	AgenciaDAO newfuncDAO = DaoFactory.creteAgenciaDAO();
	
	Agencia agencia = new Agencia();
	
	rsResultado2 = newfuncDAO.findAll();
	
	out.println("<option></option>");
	
	while(rsResultado2.next()){
		
		out.print("<option value="+rsResultado2.getString("COD")+">"+rsResultado2.getString("COD")+"</option>");
	}
	out.print("</td></SELECT>");
}catch (Exception e) {
	out.println(e);
}	
out.println("<tr>");
out.println("<td><h3>Conta atual: </h3>"+cliente.getconta()+"</td><td>Nova Conta:<input name='conta' type='text' maxlength='20' size='20'></td>");
out.println("</tr>");
out.println("<tr>");
out.println("<td><h3>Limite atual: </h3>"+cliente.getLimite()+"</td><td>Novo Limite:<input name='limite' type='text' maxlength='20' size='20'></td>");
out.println("</tr>");
out.println("</table>");
out.println("<input name='btnConfirmar' value='Atualizar' type='submit'>");
out.println("</form>");
out.println("<br>");
out.println("<a href='executaLogin'>[Sair]</a>");




%>

<h2>Confirmar atulizações</h2>


</body>
</html>