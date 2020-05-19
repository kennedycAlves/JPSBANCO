<%@page import="model.dao.DaoFactory"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.entities.Agencia" %>
<%@ page import="model.dao.AgenciaDAO" %>
<%@ page import="model.dao.impl.AgenciaDAOJDBC" %>
<%@ page import="db.DB"%>
<%@ page import="model.entities.Funcionario" %>
<%@ page import="model.dao.FuncionarioDAO" %>
<%@ page import="model.dao.impl.FuncionarioDAOJDBC" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
HttpSession sessao = request.getSession();
String statusSessao = (String) sessao.getAttribute("usuario_logado");

if(!statusSessao.equals("true")){
	response.sendRedirect("executaLogin");
}
%>
<form   name="formCadastro" action="inserirAgencia" method="post">

<h2  style="text-align: center;"> Cadastro</h2>
<table aling='center' border='1'>
<tr>
<td><p>Códido da Agencia</p></td><td><SELECT name='cod'>
<% 
ResultSet RsResultado2;
Integer cod = 0, novaAgencia;
try{
	AgenciaDAO slcAgencia = DaoFactory.creteAgenciaDAO();
	
	Agencia agencia = new Agencia();
	
	RsResultado2 = slcAgencia.findAll();
	
	out.println("<option> Selecione...</option>");
	
	while(RsResultado2.next()){
		cod = RsResultado2.getInt("COD");
	
	}
	novaAgencia = cod + 1;
	out.println("<option value="+novaAgencia+">"+novaAgencia+"</option>");

	out.println("</td></SELECT>");

}catch (Exception e) {
	out.println(e);	
	}	

%>
</tr>
<tr>
<td><p>Endereco</p></td><td><input name="endereco" size="20" maxlength="20"  type="text"/></td>
</tr>
<tr>
<td><p>Gerente</p></td><td><SELECT name='gerente'>
<%
ResultSet rsResultado;

try{ 
	FuncionarioDAO newfunc = DaoFactory.creteFuncionarioDAO();
	Funcionario func = new Funcionario();
	
	rsResultado = newfunc.findAll();
	
	

	out.println("<option> Selecione...</option>");
	while(rsResultado.next()){
	
		out.println("<option value="+rsResultado.getString("MATRICULA")+">"+"Matricula: "+rsResultado.getString("MATRICULA")+ " Gerente:"+rsResultado.getString("NOME")+"</option>");
	}
	out.println("</td></SELECT>");
}catch (Exception e) {
	out.println(e);	
	}	

%>
</tr>
</table>
<br>
<input name="btnConfirmar" value="Confirmar" type="submit">
</form>
</body>
</html>