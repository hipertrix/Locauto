<%@ page import="com.locauto.model.Usuario"
%>
 <% Usuario user =  (Usuario) session.getAttribute("usuario"); %>
 
 
 <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Locauto</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/default.css">

</head>
<body>


<nav class="navbar navbar-default" role="navigation">
  <div class="container">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">LOCAUTO</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">      
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#"><%= user.getNome() %> | <%= user.getTipoUsuarioNome() %></a></li> 
        <li><a href="IndexControlador?acao=logout">Sair</a></li> 
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>



<div class="container">

 

<div class="row">
<div class="col-sm-3 left-area">

<ul class="nav nav-pills nav-stacked"> 

<% if(user.getTipo_usuario() == 0){ 

		// acesso de usuário CLIENTE
%>
  
  <li ><a href="locacao_new_client.jsp">Reservar Veículo</a></li>
  <li ><a href="LocacaoControlador?acao=minhasreservas">Minhas reservas</a></li> 
  
 

<% }else if(user.getTipo_usuario() == 1){ 

		// Acesso de usuário FUNCIONARIO
%>
 
  <li ><a href="LocacaoControlador?acao=search">Locações</a></li>
  <li ><a href="VeiculoControlador?acao=search">Veículos</a></li>
  <li ><a href="UserController?acao=pesquisa_usuarios">Usuários</a></li>
 

<% }else{ 
	// Acesso de admin
%>


  <li ><a href="LocacaoControlador?acao=search">Locações</a></li>
  <li ><a href="VeiculoControlador?acao=search">Veículos</a></li>
  <li ><a href="UserController?acao=pesquisa_usuarios">Usuários</a></li>
  

<% } %>
</ul>

</div>

<div class="col-sm-9">



