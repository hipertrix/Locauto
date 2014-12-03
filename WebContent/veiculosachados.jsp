<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.sql.ResultSet"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Controle de Veiculos - Consulta</title>
<style>
	th{text-align:left}
</style>
</head>
<body>

	<%
		ResultSet resultados = (ResultSet) session
				.getAttribute("veiculosachados");
		out.write("<table>");
		out.write("<tr><th>Placa</th><th>Marca</th><th>Modelo</th><th>Ano</th><th>Categoria</th><th>Status</th></tr>");
		
		while (resultados.next()) {
			out.write("<tr><td><a href=\"VeiculoControlador?placa="+resultados.getString("placa")+"&acao=consultar&objeto=veiculo\" target=\"_blank\">");
			out.write(resultados.getString("placa"));
			out.write("</a></td><td>");

			out.write(resultados.getString("marca"));
			out.write("</td><td>");

			out.write(resultados.getString("modelo"));
			out.write("</td><td>");

			out.write(resultados.getString("ano"));
			out.write("</td><td>");

			out.write(resultados.getString("categoria"));
			out.write("</td></tr>");
			
			out.write(resultados.getString("status"));
			out.write("</td></tr>");

		}
	%>

</body>
</html>