<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet"
	href="static/css/style_PageAccueil.css">
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
<script src="<c:url value='/static/js/app.js' />"></script>
<script src="<c:url value='/static/js/controller/conseiller_controller.js' />"></script>

<title>Administrateur</title>
</head>
<body ng-app="myApp">
<div id="bloc_page">
<header>

      <div id="Presentation">
        <h1>
          Bienvenue chez <br>Gest Bank
        </h1>
        &nbsp
        <h2>- &nbsp Bienvenue Administrateur</h2>
      </div>
      <div id="logo">
        <img src="<c:url value='/static/images/GestBank_logo.png' />"
          alt="Logo GestBank" height="120px" />
      </div>
    </header>
<br />

  <div class="tab" ng-controller="ConsController as consctrl">
	<div align="center">
		<input type="button" class="myButton" value="Accueil" OnClick="#"/> 
		<input type="button" class="myButton" value="Déconnexion"/> 
	</div>
	<br />
	<fieldset>
	
		<legend>
			<h2>Gestion des Conseillers</h2>
		</legend>
		<br />
		<div class="option1">
		<div align="center">
			<input type="search" class="input-sm" name="recherche" placeholder="Entrer numero ou nom "> 
			<input type="button" class="myButton" name="bouton1" value="Recherche"> 
			<input type="button" class="myButton" name="bouton2" value="Ajouter un nouveau conseiller">
		</div>
		<br><br>
		<div>
			<table align="center" border=1 cellspacing=1 cellpadding=10>
				<thead>
					<tr>
						<th>Matricule</th>
						<th>Nom</th>
						<th>Email</th>
						<th>Téléphone</th>
						<th>Détails</th>
					</tr>
				</thead>
				<tbody>
					<tr ng-repeat="cons in consctrl.conseiller">
						<td><span ng-bind="cons.matricule"></span></td>
						<td><span ng-bind="cons.name"></span></td>
						<td><span ng-bind="cons.email"></span></td>
						<td><span ng-bind="cons.telephone"></span></td>							
						<td><span ng-bind="cons.détails"></span></td>														
					</tr>
				</tbody>
			</table>
		</div>
		</div>
		<br><br>
	</fieldset>
	<br>
	<fieldset>
		<legend>
			<h2>Gestion des Demandes d'Inscription</h2>
		</legend>
		<br />
		<div class="option2">
		<div align="center">
			<input type="search" class="input-sm" name="recherche" placeholder="Entrer numero ou nom "> 
			<input type="button" class="myButton" name="bouton1" value="Recherche"> 
		</div>
		<br><br>
		<div>
			<table align="center" border=1 cellspacing=1 cellpadding=10>
				<thead>
					<tr>
						<th>Date Demande</th>
						<th>Nom</th>
						<th>Email</th>
						<th>Date d'Affectation</th>
						<th>Statut</th>
						<th>Conseiller</th>
					</tr>
				</thead>
				<tbody>
				<tr ng-repeat="d in dctrl.demandes">
					<td><span ng-bind="d.dateDemande"></span></td>
					<td><span ng-bind="d.firstname"></span></td>
					<td><span ng-bind="d.email"></span></td>							
					<td><span ng-bind="d.dateAffectation"></span></td>
					<td><span ng-bind="d.statut"></span></td>
					<td><span ng-bind="d.conseiller"></span></td>							
				</tr>
				</tbody>
			</table>
		</div>
		</div>
		<br><br>
	</fieldset>
	<br>
	</div>
	</div>
	<jsp:include page="PiedDePage.jsp"></jsp:include>
</body>
</html>
