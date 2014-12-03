 


<jsp:include page="/header_loged.jsp" />

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="com.locauto.model.Veiculo"	
    import="com.locauto.model.StatusVeiculo"
	%>
<%
	Veiculo veiculo = (Veiculo) session.getAttribute("veiculo");
	%>


<h1>Editando veículo</h1>

<hr /> 
<div class="col-sm-6 col-sm-offset-3">

<form role="form"  action="VeiculoControlador" method="post">

  <div class="form-group">
    <label for="placa">Placa</label>
    <input type="text"  value="<%= veiculo.getPlaca() %>" class="form-control" autofocus name="placa" id="placa" >
  </div>
  
   <div class="form-group">
    <label for="marca">Marca</label>
    <input type="text"  value="<%= veiculo.getMarca() %>" class="form-control" name="marca" id="marca" >
  </div>
  
  
  <div class="form-group">
    <label for="modelo">Modelo</label>
    <input type="text" value="<%= veiculo.getModelo() %>"    class="form-control" name="modelo" id="modelo"  >
  </div>
    
  <div class="form-group">
    <label for="ano">Ano</label>
    <input type="text"  value="<%= veiculo.getAno() %>"   class="form-control" id="ano" name="ano" >
  </div>
  
  
    <div class="form-group">
     <label for="ano">Status</label>
      <select name="status" size="1" id="status" class="form-control"> 
        <% 
        String[] status = StatusVeiculo.getStatusVeiculo();    		
        for(int i =0; i < status.length; i ++ ){
            out.write("<option value='" + i + "'  " + ( Integer.parseInt(veiculo.getStatus()) == i ? "selected" : "") + "         >" + status[i] + "</option>");            	
         }
        %> 
      </select>  
      </div>
  
  
  
  <div class="form-group">
    <label for="valor_diaria">Valor da diária (R$)</label>
    <input type="text"  value="<%= veiculo.getValor_diaria() %>" class="form-control" id="valor_diaria" name="valor_diaria" >
  </div>
      
  <input type="hidden" name="acao" value="update" />    
  <button type="submit" class="btn btn-primary btn-lg">Salvar</button> 
				
</form>

</div>

<jsp:include page="/footer_loged.jsp" /> 