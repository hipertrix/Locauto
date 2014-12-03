<%@page import="java.util.concurrent.ExecutionException"%>
<jsp:include page="/header.jsp" />


 
 <div class="row">
 <div class="col-sm-8">
  
 
 </div>
  <div class="col-sm-4">
 
 

 
   

      <form class="form-signin" role="form"  action="IndexControlador" method="post">
        <h2 class="form-signin-heading">Login</h2>
        <label for="cpf" class="sr-only">CPF</label>
        <input type="text" name="cpf"  id="cpf" class="form-control" placeholder="CPF" required="" autofocus="">
        <label for="senha" class="sr-only">Senha</label>
        <input type="password" id="senha" name="senha" class="form-control" placeholder="Senha" required="">
        <input type="hidden" name="acao" value="login" /> 
        
        <button class="btn btn-lg btn-primary btn-block" type="submit">Entrar</button>
        
        ou 
        
        <a href="criar_conta.jsp" class="btn btn-lg btn-danger btn-block">Criar conta</a>
        
      </form>
 
    
    
    
 </div>
 </div>
 
 <h1 class="msg-home">Alugue um veículo agora, com muita facilidade!</h1>
 
 



   
  

<jsp:include page="/footer.jsp" />

 