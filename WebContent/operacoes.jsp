<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="model.entities.Cliente"%>
<%@page import="db.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Operações</title>
</head>
<body>
<%
String cpf = (String) request.getAttribute("cpf");
out.println("<form  name='formCalculoAreas' method='get' action='Operacoes'>");

out.println("<h2  style='text-align: center;'> Operações</h2>");
out.println("<p>");
out.println("<input name='TipoOperacao' value='1' type='radio'/>Realizar Deposito");
out.println("<input name='TipoOperacao' value='2' type='radio'/>Realizar Saque");
out.println("<input name='TipoOperacao' value='3' type='radio'/>Transferir Dinheiro<br>");
//out.println("<input name='cpf' value='"+cpf+"' type='hidden'/>");
out.println("<input  type='submit'  value='Realizar'/>");

out.println("</p>");
out.println("</form>");
out.println(cpf);
out.println("<br><br>");
out.println("<a href='executaLogin'>Sair</a>");




%>

</body>
</html>