<%@ page import="com.locauto.model.Usuario"
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Locauto</title>
</head>
<body> 	
	<% 
		Usuario u = (Usuario) session.getAttribute("usuario");
	%>	
	
	
	<div class="alert">
	
	<h1>
	<%= u.getNome() %> </h1>
	
	<%= (String) session.getAttribute("mensagem") %>
	
	
	 </div>
	
	
</body>
</html>