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
        <h1 ><font color="#179DFE">Productos</font></h1>
        <p align="left"><a href="Inicio?action=add">Nuevo registro</a></p>
        <table border="2" rules="cols" >
            <tr bgcolor="5FB0FF">
                <th><font color="E0EDFB">Id</font></th>
                <th><font color="E0EDFB">Descripcion</font></th>
                <th><font color="E0EDFB">Stock</font></th>
                <th></th>
                <th></th>
            </tr>
            <c:forEach var="item" items="${lista}">
                <tr>
                    <td><font color="red">${item.id}</font></td>
                    <td>${item.descripcion}</td>
                    <td>${item.stock}</td>
                    <td><a href="Inicio?action=edit&id=${item.id}">Editar</a></td>
                    <td><a href="Inicio?action=delete&id=${item.id}" onclick="return(confirm('Esta seguro de eliminar'))">Eliminar</a></td>
                </tr>
            </c:forEach>
        </table>
    </center>
    </body>
</html>
