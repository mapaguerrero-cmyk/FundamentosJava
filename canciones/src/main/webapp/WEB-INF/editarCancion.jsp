<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Actualizar Cancion</title>
	<link rel="stylesheet" href="/css/style.css">
</head>
	<body>
		<h1>Actualizar Cancion</h1>
		<form:form action="/canciones/procesa/editar/${cancion.id}" method="POST" modelAttribute="cancion">
			<input type="hidden" name="_method" value="PUT" />
			
			<form:label path="titulo">Título:</form:label>
			<form:input type="text" path="titulo" />
			<form:errors path="titulo"/>
			
			<form:label path="artista">Artista:</form:label>
			<form:input type="text" path="artista"/>
			<form:errors path ="artista"/>
			
			<form:label path="album">Album:</form:label>
			<form:input type="text" path="album"/>
			<form:errors path ="album"/>
			
			<form:label path="genero">Género:</form:label>
			<form:input type="text" path="genero"/>
			<form:errors path ="genero"/>
			
			<form:label path="idioma">Idioma:</form:label>
			<form:input type="text" path="idioma"/>
			<form:errors path ="idioma"/>
		
			<input type="submit" value="Actualizar Cancion">
		</form:form>
		<a href="/canciones">Volver a lista de canciones</a>
	</body>
</html>
