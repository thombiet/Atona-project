<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" href="static/css/style_PageAccueil.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
<script src="<c:url value='/static/js/app.js' />"></script>
<script
	src="<c:url value='/static/js/controller/conseiller_controller.js' />"></script>
<title>"Conseiller"</title>
</head>
<body ng-app="myApp">
	<div id="bloc_page">
		<header>

			<div id="Presentation">
				<h1>
					Bienvenue chez <br>Gest Bank
				</h1>
				&nbsp
				<h2>- &nbsp Bienvenue "Conseiller"</h2>
			</div>
			<div id="logo">
				<img src="<c:url value='/static/images/GestBank_logo.png' />"
					alt="Logo GestBank" height="120px" />
			</div>
		</header>
		<br />
		<div ng-controller="ConsController as cctrl">
			<div align="center">
				<input type="button" class="myButton" value="Accueil" OnClick="#" />
				<input type="button" class="myButton" value="Mes Informations"
					OnClick="#" /> <input type="button" class="myButton"
					value="Mes Messages" OnClick="#" /> <input type="button"
					class="myButton" value="Déconnexion" />
			</div>
			<br />
			
				<fieldset>
					<legend>
						<h2>Gestion des Clients</h2>
					</legend>
					<br />
					<div class="option1">
						<div align="center">
							<input type="search" class="input-sm" name="recherche"
								placeholder="Entrer Id Client"> <input type="button"
								class="myButton" name="bouton1" value="OK">
						</div>
						<div align="center">
							<input type="search" class="input-sm" name="recherche"
								placeholder="Entrer N° Compte"> <input type="button"
								class="myButton" name="bouton1" value="OK">
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
									<tr ng-repeat="c in ctrl.clients">
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
					</div>
					<br> <br>
				</fieldset>
				<br>
				<fieldset>
					<legend>
						<h2>Gestion des Demandes d'Ouverture Compte</h2>
					</legend>

					<br />
					<div class="option2">
						>
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
		</div>
	
	<jsp:include page="PiedDePage.jsp"></jsp:include>
</body>
</html>
