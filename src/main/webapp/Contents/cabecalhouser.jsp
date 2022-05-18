<%-- 
    Document   : cabecalhouser
    Created on : 16 de mai de 2022, 14:55:39
    Author     : devsys-b
--%>

<!-- Inicio cabecalho-->
<div style="text-align: center;" class="jumbotron"><h1 style="color: brown">Admin Page</h1><a style="" href="http://localhost:8080/bookstoreweb/logout">Logout</a></div>



<p style="padding: 5px;">
    <a href="<%=request.getContextPath()%>/bsuser/new" class="btn btn-primary">
        <span class="glyphicon glyphicon-plus"></span> Adicionar novo usuário</a>

        <a href="<%=request.getContextPath()%>/bsuser/list" class="btn btn-default">
        <span class="glyphicon glyphicon-th-list"></span>
         Lista de todos Usuários</a>
        

</p>

<!-- Fim cabecalho-->