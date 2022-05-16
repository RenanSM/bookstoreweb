<%-- 
    Document   : cabecalhouser
    Created on : 16 de mai de 2022, 14:55:39
    Author     : devsys-b
--%>

<!-- Inicio cabecalho-->
<div class="jumbotron"><h1>BookStoreWeb</h1></div>



<p>
    <a href="<%=request.getContextPath()%>/bsuser/new" class="btn btn-primary">
        <span class="glyphicon glyphicon-plus"></span>Adicionar novo usuário</a>

        <a href="<%=request.getContextPath()%>/bsuser/list" class="btn btn-default">
        <span class="glyphicon glyphicon-th-list"></span>
        Lista todos Usuários</a>
</p>

<!-- Fim cabecalho-->