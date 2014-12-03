<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="com.locauto.model.Veiculo"
    import="com.locauto.model.StatusVeiculo"
    import="java.sql.ResultSet"    
%> 

 <jsp:include page="/header_loged.jsp" /> 
  
 <div class="row">
 	<div class="col-sm-4">
 		<h2>Lista de veículos
 		
 		
 		</h2>
 	</div>
 	<div class="col-sm-2"><br />
 	<a href="veiculos_new.jsp" class="btn btn-primary ">Cadastrar veículo</a>
 	</div>
 	<div class="col-sm-4"><br />
 	<%
session.setAttribute("search_path", "VeiculoControlador");
session.setAttribute("acao", "search");
%>
 	 	<jsp:include page="/search.jsp" /> 
 	</div>
 </div>

<hr />
 

	<%
    StatusVeiculo status = new StatusVeiculo();
	
	ResultSet resultados = (ResultSet) session.getAttribute("veiculos");
	%>

 
 	<table class="table">
            <thead>
            <tr>          
            <th width='3%' ></th>  
            <th width='2%' class="text-center">STATUS</th>
            <th width='50%'>PLACA</th>
            <th width='15%'>MODELO</th>
            <th width='15%'>MARCA</th>
            <th width='15%'>ANO</th>
            </tr>
            </thead>
            <tbody>
            
            <% 
            while(resultados.next()) { 
            	out.write("<tr>");
            	out.write("<td> <a href='VeiculoControlador?placa="+resultados.getString("placa") +"&acao=find'><span class='glyphicon glyphicon-pencil'></i></a></td>" );
            	
            	switch(resultados.getInt("status")){
            	case 0 : 
            		out.write("<td class='text-center text-success'>" + status.getStatusVeiculoByIndex(resultados.getInt("status")) +"</td>" );
                    break;
            	case 1 :             		
        			out.write("<td class='text-center text-danger'>" + status.getStatusVeiculoByIndex(resultados.getInt("status")) +"</td>" );
        			break; 
            	default: 
            		out.write("<td class='text-center text-danger'>" + status.getStatusVeiculoByIndex(resultados.getInt("status")) +"</td>" );
            	}            	 
            	
            	out.write("<td> " +  resultados.getString("placa")  + "</td>" );
            	out.write("<td> " + resultados.getString("modelo")+ "</td>"  );
            	out.write("<td> " +  resultados.getString("marca")+ "</td>"  );
            	out.write("<td> " +  resultados.getString("ano")+ "</td>"  ); 
            	out.write("</tr>");            	
            } 
            %>
            </tbody>           
            </table>    


<jsp:include page="/footer_loged.jsp" />