<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Lista de libros</title>
	<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<div class="container">
		<h1>Lista de Libros</h1>
		<ul>
			<c:forEach var="libro" items="${libros}">
				<li>
					<a href="/libros/${libro}">${libro}</a>
				</li>
			</c:forEach>	
		</ul>
		 <a href="/libros/formulario" class="btn-agregar">Agregar nuevo libro</a>
	</div>
</body>
</html>
