<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script src="<c:url value='/static/js/app.js' />"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
<script src="<c:url value='/static/js/controller/administrateur_controller.js' />"></script>

<title>"Administrateur"</title>
</head>
<body ng-app="myApp">
  <div ng-controller="AdminController as actrl">
	<div align="center">
		<input type="button" value="Accueil" OnClick="#"/> 
		<input type="button" value="Déconnexion"/> 
	</div>
	<fieldset>
		<legend>
			<h1>Gestion des Conseillers</h1>
		</legend>
		<div align="center">
			<input type="search" name="recherche" value="Entrer numero ou nom "> 
			<input type="button" name="bouton1" value="Recherche"> 
			<input type="button" name="bouton2" value="Ajouter un nouveau conseiller">
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
					<tr ng-repeat="cons in actrl.clients">
						<td><span ng-bind="cons.matricule"></span></td>
						<td><span ng-bind="cons.name"></span></td>
						<td><span ng-bind="cons.email"></span></td>
						<td><span ng-bind="cons.telephone"></span></td>							
						<td><span ng-bind="cons.détails"></span></td>														
					</tr>
				</tbody>
			</table>
		</div>
		<br><br>
	</fieldset>
	<br>
	<fieldset>
		<legend>
			<h1>Gestion des Demandes d'Inscription</h1>
		</legend>
		<div align="center">
			<input type="search" name="recherche" value="Entrer numero ou nom "> 
			<input type="button" name="bouton1" value="Recherche"> 
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
				<tr ng-repeat="d in ctrl.demandes">
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
		<br><br>
	</fieldset>
	<br>
	</div>
	<jsp:include page="PiedDePage.jsp"></jsp:include>
</body>
</html>
