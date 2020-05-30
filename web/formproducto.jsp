<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center>
        <h1>
            <font color="red">
            <c:if test="${prodc.id == 0}">Nuevo</c:if>
            <c:if test="${prodc.id != 0}">Editar</c:if>
            registro
            </font>
        </h1>
        <form action="Inicio" method="post">
            <input type="hidden" name="id" value="${aviso.id}" />
            <table>
                <tr>
                    <td><font color="blue">Descripcion</font></td>
                    <td><input type="text" name="descripcion" value="${aviso.descripcion}"></td>
                </tr>
                <tr>
                    <td><font color="blue">Stock</font></td>
                    <td><input type="text" name="stock" value="${aviso.stock}" ></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Enviar" /></td>
                </tr>
            </table>
        </form>
    </center>     
    </body>
</html>
