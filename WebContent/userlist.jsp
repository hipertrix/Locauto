<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="com.locauto.model.Usuario"
    import="java.sql.ResultSet"    
%> 



 <jsp:include page="/header_loged.jsp" /> 
 
 
 <div class="row">
 	<div class="col-sm-4">
 		<h2>Lista de usuários</h2>
 	</div>
 	<div class="col-sm-4"><br />
 	<%
session.setAttribute("search_path", "UserController");
session.setAttribute("acao", "pesquisa_usuarios");
%>
 	 	<jsp:include page="/search.jsp" /> 
 	</div>
 </div>

<hr />


 

	<%
		
	ResultSet resultados = (ResultSet) session.getAttribute("usuarios");
	%>

 
 	<table class="table">
            <thead>
            <tr>          
            <th width='3%' ></th>  
            <th width='2%' class="text-center">STATUS</th>
            <th width='50%'>NOME</th>
            <th width='15%'>CPF</th>
            <th width='15%'>CNH</th>
            <th width='15%'>TELEFONE</th>
            </tr>
            </thead>
            <tbody>
            
            <% 
            while(resultados.next()) { 
            	out.write("<tr>");
            	out.write("<td> <a href='UserController?cpf="+resultados.getString("cpf") +"&acao=edit_user'><span class='glyphicon glyphicon-pencil'></i></a></td>" );
            	
            	if(resultados.getInt("status")==1){
            		out.write("<td class='text-center'><span class='glyphicon glyphicon-ok text-success'></span></td>" );
            	}else{
            		out.write("<td class='text-center'><span class='glyphicon glyphicon-ban-circle text-danger'></span></td>" );
                	
            	}
            	 
            	
            	out.write("<td> " +  resultados.getString("nome")  + "</td>" );
            	out.write("<td> " + resultados.getString("cpf")+ "</td>"  );
            	out.write("<td> " +  resultados.getString("cnh")+ "</td>"  );
            	out.write("<td> " +  resultados.getString("telefone")+ "</td>"  ); 
            	out.write("</tr>");            	
            } 
            %>
            </tbody>           
            </table>           
                  


<a href='controlador?nmisbn="+ resultados.getString("isbn") + "&acao=consultar&objeto=livro'>


<jsp:include page="/footer_loged.jsp" />