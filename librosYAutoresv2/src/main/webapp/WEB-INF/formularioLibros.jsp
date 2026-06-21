<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Formulario libro</title>
	<link rel="stylesheet" href="/css/style.css">
</head>
	<body>
		<div class="container">
			<h1>Agregar libro</h1>
			<form action="/procesa/libro" method="POST">
				<div>
					<label for="nombre">Libro:</label>
					<input type="text" id="nombre" name="nombre">	
				</div>
				<div>
					<label for="autor">Autor:</label>
					<input type="text" id="autor" name="autor">
				</div>
				<button type="submit">Agregar libro</button>		
			</form>
			<a href="/libros" class="btn-volver">Volver</a>
		</div>
	</body>
</html>
