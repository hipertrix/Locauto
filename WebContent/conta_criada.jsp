<%@ page import="com.locauto.model.Usuario"
%>

 <jsp:include page="/header.jsp" />

 
 
 
 <div class="row">

 <% String error =  (String) session.getAttribute("error"); %>
	
<% if(error.equals("")){ %>


 
<h1>Parabéns</h1>

<hr />

<div class="col-sm-6 col-sm-offset-3">
 
 
<div class="panel panel-success">  
 <div class="panel-body"> 
  <p>Seu cadastro foi realizado com sucesso!
 </p>
 <p>
 Sua conta ainda precisa ser ATIVADA para você fazer suas locações. 
 <br />Aguarde um e-mail com a ativação da sua conta.
 </p>
  </div>
</div>
</div>

<% } else { %>


 
<h1>OPA!</h1>

<hr />

<div class="col-sm-6 col-sm-offset-3">
 
 
 <div class="panel panel-danger"> 
 <div class="panel-body"> 
   <%= error %>
  </div>
</div>


</div>
<% } %>

</div>

<br />

<a href="index.jsp">Voltar para a página inicial</a>



 <jsp:include page="/footer.jsp" />

