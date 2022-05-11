<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="Contents/headerTags.jsp"></jsp:include>
            <title>Aplicação BookStoreWeb</title>
        </head>
        <body>
            <div class="Container">
            <jsp:include page="Contents/cabecalho.jsp"></jsp:include>
            <div class="table-responsive">
            <table class="table table-hover">
                <caption><h2>List of Users</h2></caption>
                <tr>
                    <th>ID</th>
                    <th>Email</th>
                    <th>Password</th>
                    <th>Fullname</th>
                    <th>Ações</th>
                </tr>

                <c:forEach var="user" items="${listaUser}">
                    <tr>
                        <td><c:out value="${user.id}" /></td>
                        <td><c:out value="${user.email}" /></td>
                        <td><c:out value="${user.password}" /></td>
                        <td><c:out value="${user.fullname}" /></td>
                        <td><a href="<%=request.getContextPath()%>/users/edit?id=<c:out value='${user.id}' />">
                                <span class="glyphicon glyphicon-pencil"></span>
                            </a>
                            &nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="<%=request.getContextPath()%>/users/delete?id=<c:out value='${user.id}' />">
                                <span class="glyphicon glyphicon-trash"></span>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            </div>
            <jsp:include page="Contents/rodape.jsp"></jsp:include>
        </div>
    </body>
</html>