<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Aplicação Books Store</title>
    </head>
<body>

            <br>
            <jsp:include page="./Contents/cabecalhouser.jsp"/>

            <jsp:include page="./Contents/headerTags.jsp"/>

            <div align="left">
                <c:if test="${user != null}">
                    <form action="update" method="post">
                    </c:if>
                    <c:if test="${user == null}">
                        <form action="insert" method="post">
                        </c:if>
                        <div class = "container mt-3">
                            <table class = "table table-striped">
                                <caption>
                                    <h2 style = text-decoration: none;>
                                        <c:if test="${user != null}">
                                            Editar Usuário
                                        </c:if>
                                        <c:if test="${user == null}">
                                            Adicionar novo Usuário
                                        </c:if>
                                    </h2>
                                </caption>
                                <c:if test="${user != null}">
                                    <input type="hidden" name="formId" value="<c:out value='${book.id}' />" />
                                </c:if>
                                <tr>
                                    <th>Email: </th>
                                    <td>
                                        <input type="text" name="formEmail" size="45" value="<c:out value='${book.email}' />"/>
                                    </td>
                                </tr>
                                <tr>
                                    <th>Password: </th>
                                    <td>
                                        <input type="text" name="formPassword" size="5" value="<c:out value='${book.fullname}' />"/>
                                    </td>
                                </tr>
                                <tr>
                                    <th>FullName: </th>
                                    <td>
                                        <input type="text" name="formFullname" size="45" value="<c:out value='${book.password}' />"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="2" align="center">
                                        <input type="submit" value="Enviar" />
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </form>
            </div>

            <jsp:include page="./Contents/rodape.jsp"/> 
        </div>
    </body>
</html>