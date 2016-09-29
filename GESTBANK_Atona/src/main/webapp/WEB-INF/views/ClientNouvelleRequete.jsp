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
	<title>"Requete Client"</title>
</head>
<body ng-app="myApp">
	<div ng-controller="ClientController as clctrl">
		<fieldset>
			<legend>
				<h1> Nouvelle Requete</h1>
			</legend>
			<div>
			<label >Type de Requete</label>
				<div>
					<select name="Typerequete" ng-repeat="r in TypeRequete">
						<option>r</option>
					</select>
			</div>
			</div>
		</fieldset>
	</div>
	<jsp:include page="PiedDePage.jsp"></jsp:include>
</body>
</html>
