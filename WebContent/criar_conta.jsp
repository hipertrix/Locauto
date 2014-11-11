<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Locauto</title>
</head>
<body>


<form role="form"  action="IndexControlador" method="post">

  <div class="form-group">
    <label for="nome">Nome</label>
    <input type="text" class="form-control" autofocus=true name="nome" id="nome" placeholder="Entre com o seu nome">
  </div>
  
   <div class="form-group">
    <label for="cpf">CPF</label>
    <input type="text" class="form-control" name="cpf" id="cpf" placeholder="Entre com o seu CPF">
  </div>
  
  
  <div class="form-group">
    <label for="cnh">CNH</label>
    <input type="text" class="form-control" name="cnh" id="cnh" placeholder="Digite sua CNH">
  </div>
    
  <div class="form-group">
    <label for="email">Email address</label>
    <input type="email" class="form-control" id="email" name="email" placeholder="Entre com seu e-mail">
  </div>
  
  <div class="form-group">
    <label for="senha">Senha</label>
    <input type="password" class="form-control" id="senha" name="senha" placeholder="Digite sua senha">
  </div>
  
  <div class="checkbox">
    <label>
      <input type="checkbox"> Concordo com os termos do Locauto
    </label>
  </div>
  <button type="submit" class="btn btn-default">Enviar</button>
  <input type="hidden" name="acao" value="incluir" /> 
  
				
</form>

</body>
</html>