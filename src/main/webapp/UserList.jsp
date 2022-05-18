<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>

            <jsp:include page="./Contents/headerTags.jsp"/>
            <title>Aplicação BookStoreWeb</title>
        </head>
        <body>
            <div class="Container" style="right: 50px">
            <jsp:include page="./Contents/cabecalhouser.jsp"/>

       
        <div class = "container mt-3" style="border: 1px black solid">
            <table class = "table table-striped">

                <caption><h2>Lista de usuários</h2></caption>
                <tr style="color: brown;">
                    <th>ID</th>
                    <th>Email</th>
                    <th>FullName</th>
                    <th>Password</th>
                    <th>Ações</th>
                </tr>

                <c:forEach var="user" items="${listaUsers}">
                    <tr>
                        <td><c:out value="${user.id}" /></td>
                        <td><c:out value="${user.email}" /></td>
                        <td><c:out value="${user.fullname}" /></td>
                        <td><c:out value="${user.password}" /></td>
                        
                        <td>
                            <a href="<%=request.getContextPath()%>/bsuser/edit?id=<c:out value='${user.id}'/>">
                                Edit
                            </a>&nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="<%=request.getContextPath()%>/bsuser/delete?id=<c:out value='${user.id}'/>">
                                Delete
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
            </div>
            

    </body>