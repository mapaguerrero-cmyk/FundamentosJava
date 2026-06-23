<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Detalle cancion</title>
		<link rel="stylesheet" href="/css/style.css">
	</head>
	<body>
		<div class="container">
			<h1>${cancion.titulo} ${cancion.artista}</h1>
			<p>Album: ${cancion.album}</p>
			<p>Género: ${cancion.genero}</p>
			<p>Idioma: ${cancion.idioma}</p>
			<a href="/canciones" class="btn-volver">Volver a lista de canciones</a>
		</div>
	</body>
</html>