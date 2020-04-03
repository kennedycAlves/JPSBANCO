<%@page import="model.entities.Agencia"%>
<%@page import="model.dao.AgenciaDAO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="model.dao.DaoFactory"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.Import"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="model.entities.Cliente"%>
<%@page import="db.*" %>
<%@page import="model.entities.Funcionario" %>
<%@page import="model.dao.FuncionarioDAO" %>
<%@page import="model.dao.impl.FuncionarioDAOJDBC" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form   name="formCadastro" action="inserirCliente" method="post">

<h2  style="text-align: center;"> Cadastro</h2>
<table aling='center' border='1'>
<tr>
<td><p>Nome</p></td><td><input name="nome" size="20" maxlength="20" type="text"/></td>
</tr>
<tr>
<td><p>Endereco</p></td><td><input name="endereco" size="20" maxlength="20"  type="text"/></td>
</tr>
<tr>
<td><p>CPF</p></td><td><input name="cpf" size="20" maxlength="20" type="text"/><br></td>
</tr>
<tr>
<td><p>limite</p></td><td><input name="limite" size="20" maxlength="20" type="text"/></td>
</tr>
<tr>
<td><p>Agencia</p></td><td><SELECT name='agencia'>

<% 
ResultSet rsResultado;

try {
	
	
	AgenciaDAO newfuncDAO = DaoFactory.creteAgenciaDAO();
	
	Agencia agencia = new Agencia();
	
	rsResultado = newfuncDAO.findAll();
	
	out.println("<option> Selecione...</option>");
	while(rsResultado.next()){
		
		out.println("<option value="+rsResultado.getString("COD")+">"+rsResultado.getString("COD")+"</option>");
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