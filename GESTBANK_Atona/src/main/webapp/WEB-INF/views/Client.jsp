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

<title>"Client"</title>
</head>
<body ng-app="myApp">
<<<<<<< HEAD
<div id="bloc_page" ng-controller="CompteController as comptectrl">
<header>
=======
<div id="bloc_page">
	<header>
>>>>>>> branch 'master' of https://github.com/thombiet/Atona-project

<<<<<<< HEAD
      <div id="Presentation">
        <h1>
          Bienvenue chez <br>Gest Bank
        </h1>
        &nbsp
        <h2>- &nbsp Bienvenue "Client"</h2>
      </div>
      <div id="logo">
        <img src="<c:url value='/static/images/GestBank_logo.png' />"
          alt="Logo GestBank" height="120px" />
      </div>
    </header>
<br>
	<div>
		<div align="center">
			<input type="button" class="myButton" value="Accueil" ng-click="redirection('/Client')" /> 
			<input type="button" class="myButton" value="Mes Informations" OnClick="#" /> 
			<input type="button" class="myButton" value="Mes Messages" href="#/Messagerie" />
		 <input type="button" class="myButton" value="Déconnexion" />
=======
		<div id="Presentation">
			<h1>
				Bienvenue chez <br>Gest Bank
			</h1>
			&nbsp
			<h2>- &nbsp Bienvenue "Client"</h2>
>>>>>>> branch 'master' of https://github.com/thombiet/Atona-project
		</div>
<<<<<<< HEAD
		<div ng-view></div>
		<br />
		<fieldset>
			<legend>
				<h2>Mes Comptes</h2>
</legend>
			<br />
		<div class="option1">
				<table align="center" border=1 cellspacing=1 cellpadding=10>
					<thead>
						<tr>
							<th>Type</th>
							<th>Numero</th>
							<th>Solde</th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="compte in comptectrl.comptes">
							<td><span ng-bind="compte.type"></span></td>
							<td><span ng-bind="compte.numero"></span></td>
							<td><span ng-bind="compte.solde"></span></td>							
						</tr>
						<tr >
							<td>exemple cheque</td>
							<td>exemple 11111111111</td>
							<td>exemple +300,00</td>							
						</tr>
					</tbody>
				</table>
			</div>
			<br> <br>
		</fieldset>
=======
		<div id="logo">
			<img src="<c:url value='/static/images/GestBank_logo.png' />"
				alt="Logo GestBank" height="120px" />
		</div>
	</header>
	<br />


		<ng-view> </ngview>
>>>>>>> branch 'master' of https://github.com/thombiet/Atona-project
	</div>

</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
	<script src="<c:url value='/static/js/app.js' />"></script>
	<script src="<c:url value='/static/js/config.js' />"></script>
	<script
		src="<c:url value='/static/js/controller/TestRedirection_controller.js' />"></script>
	<script type="text/javascript"
		src="<c:url value='/static/bower_components/angular-route/angular-route.js' />"></script>
	<jsp:include page="PiedDePage.jsp"></jsp:include>
</body>

</html>
