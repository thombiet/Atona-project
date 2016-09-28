<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
<script src="<c:url value='/static/js/app.js' />"></script>
<script src="<c:url value='/static/js/service/convert_service.js' />"></script>


<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" href="static/css/style_Accueil_guest.css">

<title>GestBank - Accueil/Guest</title>


</head>

<body ng-app="myApp">
	<div id="bloc_page">
		<header>
		<div id="Presentation">
			<h1>
				Bienvenue chez <br>Gest Bank
			</h1>
		</div>
		<div id="logo">
			<img src="<c:url value='/static/images/GestBank_logo.png' />"
				alt="Logo GestBank" height="100px" />
		</div>
		<div id="Identification" >
			<form>
				<p>
					<input type="text" id="Identifiant" placeholder="Identifiant" /> <input
						type="text" id="mdp" placeholder="Mot de Passe" /> <a href="#"
						class="myButton">Connexion</a>
				</p>
			</form>
			<p>
				Pas encore de compte? &nbsp <a href="#" class="myButton">Inscrivez-vous</a>
			</p>
		</div>

		</header>
		<br>
		<div id="contact">
			<div id="aide">
				<p>
					<a href="#" class="myButton">Nous contacter</a> <a href="#"
						class="myButton">?</a>
				</p>
			</div>
			<div id="social">
				<p>
					<a href="https://facebook.com"><img
						src="<c:url value='static/images/Facebook.png' />" alt="Facebook" /></a>
					<a href="https://plus.google.com"><img
						src="<c:url value='static/images/Google+.png' />" alt="Google+" /></a>
					<a href="https://twitter.com"><img
						src="<c:url value='static/images/Twitter.png' />" alt="Twitter" /></a>
				</p>
			</div>
		</div>
		<br> <br> <br>
		<div id="convertisseur">
			<div id="convertisseur_banniere">
				<h2>Convertisseur en Ligne</h2>
			</div>

		</div>
		<div id="convert">
		<select ng-model="base">
       <option 
           ng-repeat="symbol in devises" >{{symbol}}</option>
    </select>
    <input type="button" value="Convertir"
			onClick="conversion();"></input> </div>
		<footer>
		<div id="infoBank">
			<h1>Actu Gest Bank</h1>
			<p>blabla</p>
			<p>blabla</p>
		</div>
		<div id="Offres">
			<h1>Offres Promotionnelles</h1>
			<p></p>
		</div>
		<div id="Pub">
			<h1>Publicités</h1>
			<iframe src="https://www.tripadvisor.fr/" width="250" height="300"></iframe>
		</div>
		</footer>
	</div>


	<jsp:include page="PiedDePage.jsp"></jsp:include>
</body>


</html>
