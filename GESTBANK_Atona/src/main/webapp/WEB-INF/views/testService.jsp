<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
<script>
	function leConseiller($scope, $http, $q) {

		//------------------------Declaration des variables

		var CLIENT_URI = 'http://localhost:8080/SpringAngularStartProject/client/';
		var CONS_URI = 'http://localhost:8080/SpringAngularStartProject/conseiller/';
		var CONNEXION_URI = "http://localhost:8080/SpringAngularStartProject/connexion/";
		var COMPTE_URI = "http://localhost:8080/SpringAngularStartProject/compte/";

		//------------------------ServiceClient-------------------------------------------

		$scope.getClientWithId = function(id) {
			var deferred = $q.defer();
			$http.get(CLIENT_URI + id).then(function(response) {
				deferred.resolve(response.data);
			}, function(errResponse) {
				console.error('Error while fetching Client' + id);
				deferred.reject(errResponse);
			});
			return deferred.promise;
		}

		$scope.getConseillerWithMle = function(mle) {
			var deferred = $q.defer();
			$http.get(CONS_URI + mle).then(function(response) {
				deferred.resolve(response.data);
			}, function(errResponse) {
				console.error('Error while fetching Conseiller' + mle);
				deferred.reject(errResponse);
			});
			return deferred.promise;
		}

		$scope.fetchAllClients = function() {
			if ($scope.cons !== undefined) {
				$http.get(CLIENT_URI, {
					params : {
						conseiller : $scope.cons.matricule
					}
				}).then(function(response) {
					$scope.clients = response.data;
					console.log(response.status)
				}, function(error) {
					console.log(error)
				})
			}
		}

		$scope.init = function() {
			$scope.getConseillerWithMle(1).then(function(reussite) {
				$scope.cons = reussite;
				$scope.fetchAllClients();
			}, function(error) {
				console.log("oops");
			})
		}

		//$scope.cons = {
		//	matricule : 1,
		//	nom : "Michel",
		//	prenom : "jeanne",
		//	identifiant : "JMichel"
		//};

		//$scope.client;
		//$scope.clients = [];

		$scope.submit = function() {
			$scope.client.conseiller = $scope.cons;
			$http.post(CLIENT_URI, $scope.client).then(function(response) {
				console.log("reussite");
				$scope.fetchAllClients();
			}, function(error) {
				console.log("erreur : " + error)
			})
		}

		///-------------------------Devise--------------------------	

		$scope.devises = [ "AUD", "BGN", "BRL", "CAD", "CHF", "CNY", "CZK",
				"DKK", "EUR", "GBP", "HKD", "HRK", "HUF", "IDR", "ILS", "INR",
				"JPY", "KRW", "MXN", "MYR", "NOK", "NZD", "PHP", "PLN", "RON",
				"RUB", "SEK", "SGD", "THB", "TRY", "USD", "ZAR" ];

		$scope.conversion = function() {

			if ($scope.base == $scope.symbols) {
				$scope.change = $scope.montant;
			} else {
				$http.get("http://api.fixer.io/latest", {
					params : {
						base : $scope.base,
						symbols : $scope.symbols
					}
				}).then(function(response) {
					$scope.rate = response.data.rates[$scope.symbols];
					$scope.change = $scope.montant * $scope.rate;
				}, function(error) {
					console.log("error " + error)
				})
			}
		}

		//-------------------------ServiceConnexion------------------------

		$scope.connexion = function() {
			$http.get(CONNEXION_URI, {
				params : {
					'pseudo' : $scope.pseudo,
					'mdp' : $scope.mdp
				}
			}).then(function(response) {
				var resp = response.data;
				console.log(typeof resp)
				if (resp.startsWith("Client")) {
					var id = resp.slice("Client".length)
					console.log(id)
					var connecte = $scope.getClientWithId(id);
					console.log(connecte)
				} else if (resp.startsWith("Conseiller")) {
					var id = resp.slice("Conseiller".length)
					console.log(id)
					var connecte = $scope.getConseillerWithMle(id);
					console.log(connecte)
				}
			}, function(error) {
				console.log("error")
				console.log(error)
			})
		}

		//-------------------------ServiceBanque------------------------
		
		$scope.month = new Date().getMonth();
		$scope.AfficheDetailCompte = function(){
			$http.get(COMPTE_URI+$scope.compte.noCompte+"/transaction/"+$scope.month)
			.then(
				function(reussite){
					console.log(reussite);
					$scope.credits= reussite.data[0];
					$scope.debits= reussite.data[1];
					//$scope.credits.forEach(transformDate);
				},
				function(error){
					console.log("error : "+error);
				}
			)
		}
		
		function transformDate(item) {
		    item.date= new Date(item.date)
		}

	};
	
	
	//--------------------------Declaration du module et du controller------------------
	angular.module("appTest", []).controller('ctrl', leConseiller);
	
</script>
<title>TestServiceClient</title>
</head>
<body ng-app="appTest" ng-controller="ctrl" ng-init="init()">
	<h1>Action sur les clients</h1>
	<h2>Avec http://localhost:8080/SpringAngularStartProject/client/</h2>
	Avec le conseiller n°{{cons.matricule}} : {{cons.prenom}} {{cons.nom}}
	<div class="tablecontainer">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Id</th>
					<th>Nom</th>
					<th>Prenom</th>
					<th>Identifiant</th>
					<th>Liste de compte
					<th>
				</tr>
			</thead>
			<tbody>
				<tr ng-repeat="c in clients">
					<td><span ng-bind="c.identifiant"></span></td>
					<td><span ng-bind="c.nom"></span></td>
					<td><span ng-bind="c.prenom"></span></td>
					<td><span ng-bind="c.pseudo"></span></td>
					<td><span ng-repeat="cpt in c.listeComptes">{{cpt.noCompte}}<br></span></td>
				</tr>
			</tbody>
		</table>
	</div>
	<form ng_submit="submit()">
		<input type="text" ng_model="client.nom"> <input type="text"
			ng_model="client.prenom"> <input type="text"
			ng_model="client.pseudo"> <input type="submit">
	</form>
	<hr>
	<h1>Conversion de devise</h1>
	<h2>avec http://api.fixer.io/latest</h2>
	<form ng_submit="conversion()">
		<label>Montant à convertir : </label><input type="number"
			ng-model="montant"> de <select ng-model="base">
			<option ng-repeat="d in devises">{{d}}</option>
		</select> à <select ng-model="symbols">
			<option ng-repeat="d in devises">{{d}}</option>
		</select> <input type="submit">
	</form>
	le montant est de {{change}} {{symbols}}
	<br> avec un taux de {{rate}} {{symbols}} pour 1 {{base}}
	<hr>
	<h1>Connexion</h1>
	<h2>Avec http://localhost:8080/SpringAngularStartProject/connexion</h2>
	<form ng-submit="connexion()">
		Pseudo <input ng-model="pseudo"><br> Mot de passe <input
			ng-model="mdp"><br> <input type="submit"
			value="Connexion">

	</form>
	<hr>
	<h1>Service Banque</h1>
	<h2>avec http://localhost:8080/SpringAngularStartProject/compte et
		http://localhost:8080/SpringAngularStartProject/transaction</h2>
	<h3>Compte du client {{clients[0].nom}}</h3>
	<form ng-submit="AfficheDetailCompte()">
		<select ng-model="compte" ng-options="cpt.noCompte for cpt in clients[0].listeComptes"></select>
		<input type="submit" value="Choisir">
	</form>
	Detail du compte pour le mois de {{month}}
	<table  align="center" border=1 cellspacing=1 cellpadding=10>
		<tr ng-repeat="d in debits"><td>{{d.date}}</td><td>{{::d.libelle}}</td><td></td><td>-{{d.montant}}</td></tr>
		<tr ng-repeat="c in credits"><td>{{c.date}}</td><td>{{c.libelle}}</td><td>{{c.montant}}</td><td></td></tr>
	</table>
</body>
</html>