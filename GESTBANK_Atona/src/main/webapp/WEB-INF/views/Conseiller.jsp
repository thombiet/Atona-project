<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script src="<c:url value='/static/js/app.js' />"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
<script
	src="<c:url value='/static/js/controller/conseiller_controller.js' />"></script>
<title>"Conseiller"</title>
</head>
<body ng-app="myApp">
	<div ng-controller="ConsController as cctrl">
		<div align="center">
			<input type="button" value="Accueil" OnClick="#" /> <input
				type="button" value="Mes Informations" OnClick="#" /> <input
				type="button" value="Mes Messages" OnClick="#" /> <input
				type="button" value="Déconnexion" />
		</div>
		<fieldset>
			<legend>
				<h1>Gestion des Clients</h1>
			</legend>
			<div align="center">
				<input type="search" name="recherche" value="Entrer Id Client">
				<input type="button" name="bouton1" value="OK">
			</div>
			<div align="center">
				<input type="search" name="recherche" value="Entrer N° Compte">
				<input type="button" name="bouton1" value="OK">
			</div>
			<br> <br>
			<div>
				<table align="center" border=1 cellspacing=1 cellpadding=10>
					<thead>
						<tr>
							<th>Id</th>
							<th>Prenom</th>
							<th>Nom</th>
							<th>Email</th>
							<th>Fiche Client</th>
							<th>Liste des Comptes</th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="c in cctrl.clients">
							<td><span ng-bind="c.id"></span></td>
							<td><span ng-bind="c.firstname"></span></td>
							<td><span ng-bind="c.lastname"></span></td>							
							<td><span ng-bind="c.email"></span></td>
							<td>
								<button type="button" ng-click="ctrl.edit(u.id)"
									class="btn btn-success custom-width">Modifier</button>
								<button type="button" ng-click="ctrl.remove(u.id)"
									class="btn btn-danger custom-width">Supprimer</button>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			<br> <br>
		</fieldset>
		<br>
		<fieldset>
			<legend>
				<h1>Gestion des Demandes d'Ouverture Compte</h1>
			</legend>

			<div>
				<table align="center" border=1 cellspacing=1 cellpadding=10>
					<thead>
						<tr>
							<th>Date demande</th>
							<th>Proprietaire</th>
							<th>Type Compte</th>
							<th>Statut</th>
							<th>Date Ouverture</th>
							<th>Valider/Gerer</th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="daff in cctrl.demandes">
							<td><span ng-bind="daff.dateDemande"></span></td>
							<td><span ng-bind="daff.firstname"></span></td>
							<td><span ng-bind="daff.typecompte"></span></td>							
							<td><span ng-bind="daff.statut"></span></td>
							<td><span ng-bind="daff.dateOuverture"></span></td>
							<td><span ng-bind="daff.aFaire"></span></td>							
						</tr>
					</tbody>
				</table>
			</div>
			<br> <br>
		</fieldset>
	</div>
	<jsp:include page="PiedDePage.jsp"></jsp:include>
</body>
</html>
