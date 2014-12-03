
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="com.locauto.dao.VeiculoDao"	 
    import="java.util.ArrayList"
    import="com.locauto.model.Usuario"
	%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
	
	<jsp:include page="/header_loged.jsp" /> 


     <jsp:useBean id="obj" class="com.locauto.model.VeiculosList" scope="page"/>     
     <jsp:useBean id="clients" class="com.locauto.model.ClientsList" scope="page"/>
  
   <% Usuario user =  (Usuario) session.getAttribute("usuario"); %>
  
<h1>Nova loca��o</h1>

<hr /> 
<div class="col-sm-6 col-sm-offset-3">

<form role="form"  action="LocacaoControlador" method="post">
 
      
      

  <div class="form-group">
     <label for="veiculo">Veiculo</label>
     

 <select name="veiculo"   id="veiculo" class="form-control"> 
       
                                <c:forEach var="placa" items="${obj.veiculos}">
                                 <option value="${placa[0]}">${placa[1]}, Ano: ${placa[2]}</option>
                                </c:forEach> 
                            
</select>
 
      
      </div>
      
      
      
   <div class="form-group">
    <label for="data_locacao">Data da Retirada</label>
      <div class='input-group date' id='datetimepicker5'>
					<input type='text'  name="data_locacao" id="data_locacao"
					  class="form-control" data-date-format="DD/MM/YYYY"/>
					<span class="input-group-addon">
						<span class="glyphicon glyphicon-calendar"></span>
					</span>
				</div>
				
				

  </div>
  
  <div class="form-group">
    <label for="data_devolucao">Data da Devolu��o</label>
      <div class='input-group date' id='datetimepicker6'>
					<input type='text'  name="data_devolucao" id="data_devolucao"
					  class="form-control" data-date-format="DD/MM/YYYY"/>
					<span class="input-group-addon">
						<span class="glyphicon glyphicon-calendar"></span>
					</span>
				</div>
				
				 
  </div>  
   
   <input type="hidden" name="acao" value="create" />
      
  <input type="hidden" name="total_diarias" value="25" />
  
  
      
  <input type="hidden" name="usuario" value="<%= user.getCpf() %>" /> 
  <input type="hidden" name="operador" value="<%= user.getCpf() %>" />    
  <button type="submit" class="btn btn-primary btn-lg">Salvar</button> 
				
</form>

</div>
 
     
<jsp:include page="/footer_loged.jsp" />


	<script type="text/javascript"  src="js/moment.js"></script>
	<script type="text/javascript" src="js/bootstrap-datetimepicker.js"></script>
  
		
 
    <script type="text/javascript">
    $(function () {
		$('#datetimepicker5').datetimepicker({
			pickTime: false
		});
		$('#datetimepicker6').datetimepicker({
			pickTime: false
		});
	});
    </script> 
     


