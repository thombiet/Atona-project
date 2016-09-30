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
	<script src="<c:url value='/static/js/controller/conseiller_controller.js' />"></script>
	<title>"Client Messagerie"</title>
</head>
<body ng-app="myApp">
	<div ng-controller="ClientController as clctrl">
		<div align="center">
			<input type="button" value="Accueil" OnClick="#" /> <input
				type="button" value="Mes Informations" OnClick="#" /> <input
				type="button" value="Mes Messages" OnClick="#" /> <input
				type="button" value="Déconnexion" />
		</div>
		<fieldset>
			<legend>
				<h1> Mes Messages</h1>
			</legend>
			<div><input type="button" name="bouton1" value="Nouvelle requete"></div>
			<div>
				<table align="center" border=1 cellspacing=1 cellpadding=10>
					<thead>
						<tr>
							<th>Date</th>
							<th>Message</th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="notif in cptctrl.listeNotification">
							<td><span ng-bind="notif.date"></span></td>
							<td><span ng-bind="notif.message"></span></td>
						</tr>
					</tbody>
				</table>
			</div>
		</fieldset>
	</div>
	<jsp:include page="PiedDePage.jsp"></jsp:include>
</body>
</html>
