<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" />
<link rel="stylesheet" href="static/css/style_PageAccueil.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
<script src="<c:url value='/static/js/app.js' />"></script>
<script
	src="<c:url value='/static/js/controller/client_controller.js' />"></script>
<script src="<c:url value='/static/js/service/client_service.js' />"></script>
<title>"Conseiller"</title>
</head>
<body ng-app="myApp">
	<div id="bloc_page" ng-controller="ClientController as clientctrl">
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
		<div>
			<div align="center">
				<input type="button" class="myButton" value="Accueil" OnClick="#" />
				<input type="button" class="myButton" value="Mes Informations"
					OnClick="#" /> <input type="button" class="myButton"
					value="Mes Messages" OnClick="#" /> <input type="button"
					class="myButton" value="Déconnexion" />
			</div>
			<br>

			<fieldset>
				<legend>
					<h2>Gestion des Clients</h2>
				</legend>
				<br />
				<div class="option1">
					<div align="center">

						<input type="text" class="input-sm" ng-model="identifiant" placeholder="Entrer Id Client">
						<button class="myButton" name="findcli" ng-click="clientctrl.fetchClientById(identifiant)">OK</button>
						<br>Identifiant: {{identifiant}}

						<div align="center">
							<input type="search" class="input-sm" ng-model="noCompte"
								placeholder="Entrer N° Compte">
							<button class="myButton" name="bouton1"
								ng-click="fetchCompteById(noCompte)">OK</button>
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
									<tr ng-repeat="c in clientctrl.clients">
										<td><span ng-bind="c.identifiant"></span></td>
										<td><span ng-bind="c.nom"></span></td>
										<td><span ng-bind="c.prenom"></span></td>
										<td><span ng-bind="c.email"></span></td>
										<td><a href="#" title="affichage"
											ng-click="afficheClient(c)">Afficher</a> <!--button ng-click="clientctrl.afficheClient(c)">Afficher</button-->
											<button type="button" name="bouton1"
												ng-click="updateClient(c,c.identifiant)">Modifier</button>
											<button type="button" name="bouton1"
												ng-click="deleteClient(c.identifiant)">Supprimer</button></td>
										<td align="center" ng-repeat="compte in c.listeComptes">
											<a href="#" ng-bind="compte.noCompte"></a>
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
							<tr ng-repeat="daff in dctrl.demandes">
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
