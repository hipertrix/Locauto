<form role="form"  action="<%= session.getAttribute("search_path") %>" method="post">
  <div class="input-group">
      <input type="text" name="search" id="search" class="form-control">
      <span class="input-group-btn">
        <button class="btn btn-default" type="submit"  ><i class='glyphicon glyphicon-search'></i></button>
      </span>
  </div>
  <input type="hidden" name="acao" value="<%= session.getAttribute("acao") %>" />				
</form> 