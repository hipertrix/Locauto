<jsp:include page="/header.jsp" />

<h1>Bem vindo</h1>

<hr />
 
<a href="criar_conta.jsp">Criar minha conta</a>

 
 <div class="row">
 <div class="col-sm-8">
 
 </div>
  <div class="col-sm-4">
 
 
  <% String error =  (String) session.getAttribute("error"); %>
	
<% if(!error.equals("")){ %>
	
	<div class="alert alert-danger">
	
	<%= error %>
	</div>


<% } %>

 
   

      <form class="form-signin" role="form"  action="IndexControlador" method="post">
        <h2 class="form-signin-heading">Login</h2>
        <label for="cpf" class="sr-only">CPF</label>
        <input type="text" name="cpf"  id="cpf" class="form-control" placeholder="CPF" required="" autofocus="">
        <label for="senha" class="sr-only">Senha</label>
        <input type="password" id="senha" name="senha" class="form-control" placeholder="Senha" required="">
        <input type="hidden" name="acao" value="login" /> 
        
        <button class="btn btn-lg btn-primary btn-block" type="submit">Entrar</button>
      </form>
 
    
    
    
 </div>
 </div>
 



   
  

<jsp:include page="/footer.jsp" />

 