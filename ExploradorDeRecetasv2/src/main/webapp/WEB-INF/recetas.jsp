<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Recetas</title>
	<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<div class="container">
		<h1>Lista de recetas</h1>
		<ul class="recetas-lista">
    		<c:forEach var="receta" items="${recetas}">
	        	<li>${receta}</li>
    		</c:forEach>
		</ul>
	</div>
</body>
</html>

