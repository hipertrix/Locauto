<jsp:include page="/header_loged.jsp" />



<h1>Criar funcionário</h1>

<hr />

<div class="col-sm-6 col-sm-offset-3">

<form role="form"  action="UserController" method="post">

  <div class="form-group">
    <label for="nome">Nome</label>
    <input type="text" class="form-control" autofocus=true name="nome" id="nome" placeholder="Entre com o seu nome">
  </div>
  
   <div class="form-group">
    <label for="cpf">CPF</label>
    <input type="text" class="form-control" name="cpf" id="cpf" placeholder="Entre com o seu CPF">
  </div>
   
    
  <div class="form-group">
    <label for="email">Email </label>
    <input type="email" class="form-control" id="email" name="email" placeholder="Entre com seu e-mail">
  </div>
    
  <div class="form-group">
    <label for="senha">Senha</label>
    <input type="password" class="form-control" id="senha" name="senha" placeholder="Digite sua senha">
  </div>
   
  <button type="submit" class="btn btn-default">Enviar</button>
  <input type="hidden" name="acao" value="incluir_funcionario" /> 
  
				
</form>

</div>

<jsp:include page="/footer_loged.jsp" />
