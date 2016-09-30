<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">

<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
<script src="<c:url value='/static/js/app.js' />"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
	<link href='http://fonts.googleapis.com/css?family=Bitter' rel='stylesheet' type='text/css'>
<link rel="stylesheet"
	href="static/css/style_Formulaire_Inscription.css">

<title>Formulaire d'Inscription</title>

<style>
.nom.ng-valid {
	background-color: lightgreen;
}

.nom.ng-dirty.ng-invalid-required {
	background-color: red;
}

.username.ng-dirty.ng-invalid-minlength {
	background-color: yellow;
}

.email.ng-valid {
	background-color: lightgreen;
}

.email.ng-dirty.ng-invalid-required {
	background-color: red;
}

.email.ng-dirty.ng-invalid-email {
	background-color: yellow;
}
</style>
</head>
<body ng-app="myApp">
	<div id="bloc_page">
		<header>

			<div id="Presentation">
				<h1>
					Bienvenue chez <br>Gest Bank
				</h1>
				&nbsp
				<h2>- &nbsp Inscription Nouveau Membre</h2>
			</div>
			<div id="logo">
				<img src="<c:url value='/static/images/GestBank_logo.png' />"
					alt="Logo GestBank" height="120px" />
			</div>
		</header>
		<br />
		<form ng-submit="ctrl.submit()" name="monForm">
				<div class="form-style-10">
				<h1>Formulaire d'Inscription</h1>
			<fieldset>
				<legend>
					<h3>Tous les champs sont obligatoires</h3>
				</legend>
				<br> <br>
				
    			<div class="inner-wrap">
					<label id="text">Nom</label>
					<div class="entry">
						 <input type="text" ng-model="ctrl.user.username" name="uname" class="username form-control input-sm" placeholder="Entez votre nom" required ng-minlength="3"/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.uname.$error.required">Champ Obligatoire</span>
                                      <span ng-show="myForm.uname.$invalid">Ce champ est invalide </span>
                                  </div>
					
				</div>
			
					<label id="text">Prénom</label>
					<div class="entry">
						<input type="text" name="prenom" class="input-sm">
					</div>
				
				
					<label id="email">Email</label>
					<div class="entry">
						<input type="email" ng-model="ctrl.user.email" name="email"
							class="email form-control input-sm"
							placeholder="Entrez votre Email" required />
						<div class="has-error" ng-show="myForm.$dirty">
							<span ng-show="myForm.email.$error.required">Ce champ est obligatoire</span>
						    <span ng-show="myForm.email.$invalid">Ce champ est invalide</span>
						</div>
					</div>
				
					<label id="text">Adresse</label>
					<div class="entry">
						<input type="text" name="adresse" class="input-sm">
					</div>
			
					<label id="numeric">Code postal</label>
					<div class="entry">
						<input type="numeric" name="codePostal" class="input-sm">
					</div>
				
					<label id="text">Ville</label>
					<div class="entry">
						<input type="text" name="ville" class="input-sm">
					</div>
				
					<label id="date">Date de Naissance </label>
					<div class="entry">
						<input type="date" name="date" class="input-sm">
					</div>
				
					<label id="tel">Telephone</label>
					<div class="entry">
						<input type="tel" name="telephone" class="input-sm">
					</div>
				
					<label id="genre">Genre</label>
					<div class="entry">
						<select name="genre" class="input-sm">
							<option>sexe</option>
							<option>Feminin</option>
							<option>Masculin</option>
						</select>
					</div>
				</div>
				<br>

				<div class="form-group col-md-12">
					<label id="choix">Autorisation découvert</label>
					<div class="entry">
						<input type="checkbox" name="decouvert" class="input-sm">
					</div>
				</div>
				<br>

				<div class="form-group col-md-12">
					<label id="numeric">Revenus mensuels</label>
					<div class="entry">
						<input type="numeric" name="revenus" class="input-sm">
					</div>
				</div>
				<br>

				<div class="form-group col-md-12">
					<label id="files">Documents justificatifs</label>
					<div class="entry">
						<input type="file" id="mesFichiers" multiple="multiple">
					</div>
				</div>
				<br>
				<div id="btn_validation">
					<div class="form-group col-md-12">
						<input type="submit" class="myButton"
							ng-disabled="monForm.$invalid"
							ng-class="{ 'btn-warning' : monForm.$invalid , 'btn-success' : monForm.$valid }">
					</div>
					<div class="form-group col-md-12">
						<button type="submit" class="myButton" role="button"
							aria-disabled="false">
							Annuler</input>
					</div>
				</div>
			</fieldset>
			</div>
		</form>

	</div>
	<jsp:include page="PiedDePage.jsp"></jsp:include>
</body>
</html>
