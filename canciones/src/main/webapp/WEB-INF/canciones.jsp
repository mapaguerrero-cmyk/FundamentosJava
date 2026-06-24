<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Canciones</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
    <div class="container">
        <h1>Lista de Canciones</h1>
        
        <table>
            <thead>
                <tr>
                    <th>Titulo</th>
                    <th>Autor</th>
                    <th>Detalle</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="cancion" items="${listaCanciones}">
                    <tr>
                        <td>${cancion.titulo}</td>
                        <td>${cancion.artista}</td>
                        <td>
                            <a href="/canciones/detalle/${cancion.id}">Detalle</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href="/canciones/formulario/agregar" class="btn-agregar">Agregar Canción</a>
    </div>
</body>
</html>