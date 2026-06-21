<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Detalles del Libro</title>
	<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<div class="container">
		<c:choose>
			<c:when test="${not empty libro}">
				<h1>${libro}</h1>
				<h2>Su autor es: ${autor}</h2>
			</c:when>
			<c:otherwise>
				<p>${mensajeError}</p>
			</c:otherwise>
		</c:choose>
		<a href="/libros" class="btn-volver">Volver lista de libros</a>	
	</div>
</body>
</html>
