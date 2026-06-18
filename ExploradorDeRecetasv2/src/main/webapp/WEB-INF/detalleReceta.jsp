<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Detalle Receta</title>
	<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<div class="container">
		<c:choose>
			<c:when test="${not empty receta}">
				<h1>${receta}</h1>
				<h2>Ingredientes:</h2>
				<ul>
					<c:forEach var="ingrediente" items="${ingredientes}">
					<li class="ingrediente">${ingrediente}</li>
					</c:forEach>
				</ul>
			</c:when>
			<c:otherwise>
				<p class="error">${mensajeError}</p> 
			</c:otherwise>
		</c:choose>		
		 <a href="/recetas" class="btn-volver">Volver lista de recetas</a>
	</div>
</body>
</html>