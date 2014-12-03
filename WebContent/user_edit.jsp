<jsp:include page="/header_loged.jsp" />


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="com.locauto.model.Usuario"
 
	
	%>

<%
	Usuario usuario = (Usuario) session.getAttribute("tmp_usuario");
	%>


<h1>editando usuário</h1>

<hr />

<div class="col-sm-6 col-sm-offset-3">

<form role="form"  action="UserController" method="post">

  <div class="form-group">
    <label for="nome">Nome</label>
    <input type="text" value="<%= usuario.getNome() %>" class="form-control" autofocus name="nome" id="nome" placeholder="Entre com o seu nome">
  </div>
  
   <div class="form-group">
    <label for="cpf">CPF</label>
    <input type="text" value="<%= usuario.getCpf() %>"  class="form-control" name="cpf" id="cpf" placeholder="Entre com o seu CPF">
  </div>
  
  
  <div class="form-group">
    <label for="cnh">CNH</label>
    <input type="text"  value="<%= usuario.getCnh() %>"   class="form-control" name="cnh" id="cnh" placeholder="Digite sua CNH">
  </div>
    
  <div class="form-group">
    <label for="telefone">Telefone</label>
    <input type="tel"  value="<%= usuario.getTelefone() %>" class="form-control" id="telefone" name="telefone" placeholder="Entre com telefone">
  </div>
  
  
  <div class="form-group">
    <label for="email">E-mail</label>
    <input type="email"  value="<%= usuario.getEmail() %>"   class="form-control" id="email" name="email" placeholder="Entre com seu e-mail">
  </div>
   
  <div class="form-group">
    <label for="status">
    
    <input type="checkbox" name="status" id="status" value="1" <%= (usuario.getStatus() == 1 ? "checked" : "") %>     > 
    &nbsp; Liberado
     </label>
  
    </div>
  
  
  <input type="hidden" name="acao" value="update_user" /> 
   
  <button type="submit" class="btn btn-primary btn-lg">Salvar</button> 
				
</form>

</div>

<jsp:include page="/footer_loged.jsp" />
