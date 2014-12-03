<jsp:include page="/header.jsp" />

<script>
	function enviar(acao) {
		document.frmIncluirLivro.acao.value = acao;
		document.frmIncluirLivro.submit();

	}
</script>

<h1>Cadastro de Veiculos</h1>

<hr />

<div class="col-sm-6 col-sm-offset-3">

<form role="form"  action="VeiculoControlador" method="get">

  <div class="form-group">
    <label for="placa">Placa</label>
    <input type="text" class="form-control" autofocus=true name="placa" id="placa" placeholder="Entre com a placa do veiculo">
  </div>
  
   <div class="form-group">
    <label for="marca">Marca</label>
    <input type="text" class="form-control" name="marca" id="marca" placeholder="Digite a marca">
  </div>
  
  
  <div class="form-group">
    <label for="modelo">Modelo</label>
    <input type="text" class="form-control" name="modelo" id="modelo" placeholder="Digite o modelo">
  </div>
    
  <div class="form-group">
    <label for="ano">Ano</label>
    <input type="text" class="form-control" id="ano" name="ano" placeholder="Digite o ano">
  </div>
  
  <div class="form-group">
    <label for="categoria">Categoria</label>
    <input type="text" class="form-control" id="categoria" name="categoria" placeholder="Digite a categoria">
  </div>
  
   <div class="form-group">
    <label for="status">Status</label>
    <input type="text" class="form-control" id="status" name="status" value="Disponivel">
  </div>
  
  <div class="form-group">
    <label for="valor_diaria">Valor da diaria</label>
    <input type="text" class="form-control" id="valor_diaria" name="valor_diaria" placeholder="Digite o valor da diaria" >
  </div>
  
  <button type="submit" class="btn btn-default" name="acao" value="incluir">Incluir</button>
  
  <button type="submit" class="btn btn-default" name="acao" value="consultar" >Consultar</button>
  
  <button type="reset" class="btn btn-default" name="acao" value="limpar">Limpar</button>
  
 
  <button type="submit" class="btn btn-default" name="acao" value="sair">Sair</button>
  
  
				
</form>

</div>

<jsp:include page="/footer.jsp" />
