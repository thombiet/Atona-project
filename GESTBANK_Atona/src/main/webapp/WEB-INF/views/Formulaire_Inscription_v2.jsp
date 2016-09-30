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
	href="static/css/style_Formulaire_Inscription_v2.css">

<title>Formulaire d'Inscription</title>


<body>
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
  <div class="form-style" >
    <h1>Formulaire d'Inscription<span>Tous les champs sont obligatoires</span></h1>
    <form name="myForm" ng-submit="ctrl.submit()">
      <div class="section"><span>1</span>Informations Générales</div>
      <div class="inner-wrap">

        <label>Nom <div class="entry">
         <input type="text" ng-model="ctrl.user.nom" name="nom" placeholder="Entrez votre nom" required/>
         </div></label>

         <label>Prénom<div class="entry">
           <input type="text" ng-model="ctrl.user.prenom" name="prenom" placeholder="Entrez votre prénom" required/>
           </div></label>

          <div id="genre">
           <label>Date de Naissance
            <div class="entry">
              <input type="date" name="dateNaissance" required>
            </div> </label>


            <label>Genre
              <div class="entry">
               <select name="genre" >
                <option>sexe</option>
                <option>Feminin</option>
                <option>Masculin</option></select>  </div></label>


              </div>

              <label>Pseudo<div class="entry">
               <input type="text" ng-model="ctrl.user.pseudo" name="pseudo" class="" placeholder="Choisissez un pseudo " required ng-minlength="4"/>
               </div></label>

              <label>Adresse<div class="entry">
               <input type="text" ng-model="ctrl.user.adresse" name="adresse" class="" placeholder="Entrez votre Adresse" required/>
               </div></label>
<div id="adresse">
              <label>Code Postal<div class="entry">
               <input type="number" ng-model="ctrl.user.code postal" name="code postal" class="" placeholder="XXXXX" required ng-minlength="5"/>
                </div></label>

              <label>Ville<div class="entry">
               <input type="text" ng-model="ctrl.user.adresse" name="adresse" class="" placeholder="Ville" required/>
               </div></label>
</div>
              <label>Email <div class="entry">
                <input type="email" ng-model="ctrl.user.email" name="email"
                class="email form-control input-sm"
                placeholder="Entrez votre Email" required />
              
              </div></label>

              <label>n°téléphone <input type="tel" name="tèl" required ng-minlength="10"/></label>
            </div>


            <div class="section"><span>2</span>Informations Supplémentaires</div>
            <div class="inner-wrap" >

              <label>Revenu Mensuel<div class="entry">
               <input type="number" ng-model="ctrl.user.revenu" name="revenu mens" class="" placeholder="indiquez votre revenu mensuel moyen" required />
               </div></label>

              <label id="choix">Autorisation découvert
                <div class="entry">
                  <input type="checkbox" name="decouvert" class="input-sm">
                </div></label>
                <div class="entry">
                  <label id="files">Documents justificatifs
                    <input type="file" id="mesFichiers" multiple="multiple">
                  </div></label><br />

                  <div class="button-section">
                   <input type="submit" 
                   ng-disabled="monForm.$invalid"
                   ng-class="{ 'btn-warning' : myForm.$invalid , 'btn-success' : myForm.$valid }">
                   &nbsp
                   <button type="reset" 
                   aria-disabled="false">Annuler</button> 
                 </div>
               </form>
             </div>
             <br />
			<jsp:include page="PiedDePage.jsp"></jsp:include>
           </body>
           </html>
