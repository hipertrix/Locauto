<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="com.locauto.model.Locacao"  
    import="com.locauto.model.Usuario"  
    import="java.sql.ResultSet"    
%> 

 <jsp:include page="/header_loged.jsp" /> 
    <% Usuario user =  (Usuario) session.getAttribute("usuario"); %>
  
 <div class="row">
 	<div class="col-sm-4">
 		<h2>Locações
 		
 		</h2>
 	</div>
 	
 	<% if(user.getTipo_usuario() > 0){ %>
 	<div class="col-sm-2"><br />
 	<a href="locacao_new.jsp" class="btn btn-primary ">Nova locação</a>
 	</div>
 	<div class="col-sm-4"><br />
		 	<%
		session.setAttribute("search_path", "LocacaoControlador");
		session.setAttribute("acao", "search");
		%>
 	 	<jsp:include page="/search.jsp" /> 
 	</div>
 	<% } %>
 	
 	
 </div>
<hr />

	<% 
	ResultSet resultados = (ResultSet) session.getAttribute("locacoes");
	%>

 
 	<table class="table">
            <thead>
            <tr>          
           
 	<% if(user.getTipo_usuario() > 0){ %> <th width='3%' ></th> <% } %>
            <th width='20%'>PLACA</th>
            <th width='37%'>CLIENTE</th>
            <th width='20%'>DATA RETIRADA</th>
            <th width='20%'>DATA DEVOLUÇÃO</th>
            </tr>
            </thead>
            <tbody>
            
            <% 
            while(resultados.next()) { 
            	out.write("<tr>");

             	if(user.getTipo_usuario() > 0){ 
             		out.write("<td> <a href='LocacaoControlador?cod="+resultados.getInt("cod") +"&acao=find'><span class='glyphicon glyphicon-pencil'></i></a></td>" );
             	}
               	out.write("<td> " +  resultados.getString("veiculo")  + "</td>" );
            	out.write("<td> " + resultados.getString("usuario_nome")+ "</td>"  );
            	out.write("<td> " +  resultados.getString("data_locacao")+ "</td>"  );
            	out.write("<td> " +  resultados.getString("data_devolucao")+ "</td>"  ); 
            	out.write("</tr>");            	
            } 
            %>
            </tbody>           
            </table>    


<jsp:include page="/footer_loged.jsp" />