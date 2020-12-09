<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Ninja Gold</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>

<body>
	<div class="col-10 mx-auto my-4">
		<h1 class="text-center">Ninja Gold</h1>
		
		<div class="d-flex justify-content-start">
			<p>Your Gold: <c:out value="${gold}"/></p>
		</div>
		
		<div class="d-flex justify-content-around">
			<form action="/process" method="POST" class="border border-dark">
				<p>Farm</p>
				<p>(earns 10-20 gold)</p>
				<input type="hidden" name="whichform" value="farm">
				<button class="btn btn-warning">Find Gold!</button>
			</form>
			
			<form action="/process" method="POST" class="border border-dark">
				<p>Cave</p>
				<p>(earns 5-10 gold)</p>
				<input type="hidden" name="whichform" value="cave">
				<button class="btn btn-warning">Find Gold!</button>
			</form>
			
			<form action="/process" method="POST" class="border border-dark">
				<p>House</p>
				<p>(earns 2-5 gold)</p>
				<input type="hidden" name="whichform" value="house">
				<button class="btn btn-warning">Find Gold!</button>
			</form>
			
			<form action="/process" method="POST" class="border border-dark">
				<p>Casino</p>
				<p>(earns/takes 0-50 gold)</p>
				<input type="hidden" name="whichform" value="casino">
				<button class="btn btn-warning">Find Gold!</button>
			</form>
		</div>
		
		<p>Activities:</p>
		<div id="activity_log" class="border border-dark">
			<c:forEach items="${log}" var="display"><p class="text-success">${display}</p></c:forEach>
		</div>
	</div>
</body>
</html>