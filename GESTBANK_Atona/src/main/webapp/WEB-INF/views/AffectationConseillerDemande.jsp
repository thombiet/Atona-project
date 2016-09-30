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
  <div ng-controller="AdminController as ctrl">
	<fieldset>
		<legend>
			<h1>Choix du Conseiller à Affecter</h1>
		</legend>

		<br><br>
		<div>
			<table align="center" border=1 cellspacing=1 cellpadding=10>
				<thead>
					<tr>
						<th>Matricule</th>
						<th>Nom</th>
						<th>Email</th>
						<th>Affectation</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><a href="#">12</a></td>
						<td>Aby</td>
						<td>aby.faye@atona.com</td>
						<td><input type="button" name="bouton1" value="Choisir"></td>
					</tr>
					<tr>
						<td><a href="#">20</a></td>
						<td>Nathalie</span></td>
						<td>nathalie.maissiat@atona.com</td>
						<td><input type="button" name="bouton2" value="Choisir"></td>
					</tr>
					<tr>
						<td><a href="#">30</a></td>
						<td>Thomas</span></td>
						<td>thoms.biet@atona.com</td>
						<td><input type="button" name="bouton3" value="Choisir"></td>
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
