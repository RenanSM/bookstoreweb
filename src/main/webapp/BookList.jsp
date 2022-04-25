<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Aplicação BookStoreWeb</title>
    </head>
    <body>
        <h1>Aplicação BookStoreWeb</h1>
        <p><a href="<%=request.getContextPath()%>/new">Adicionar novo Livro</a></p>
        <p><a href="<%=request.getContextPath()%>/list">Lista todos Livros</a></p>

        <table border="1" cellpadding="5">
            <caption><h2>List of Books</h2></caption>
            <tr>
                <th>ID</th>
                <th>Titulo</th>
                <th>Autor</th>
                <th>Preco</th>
                <th>Ações</th>
            </tr>

            <c:forEach var="book" items="${listaBook}">
                <tr>
                    <td><c:out value="${book.id}" /></td>
                    <td><c:out value="${book.titulo}" /></td>
                    <td><c:out value="${book.autor}" /></td>
                    <td><c:out value="${book.preco}" /></td>
                    <td><a href="<%=request.getContextPath()%>/edit?id=<c:out value='${book.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="<%=request.getContextPath()%>/delete?id=<c:out value='${book.id}' />">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>