/**
 * 
 */
function MainController($location, $scope) {

	this.CurrentDate = new Date();

	$scope.$watch(function() {
		return sessionStorage.role;
	}, function(newValue, oldValue) {
		this.role = newValue;
		$scope.role =  newValue;
		$scope.id = sessionStorage.idConnecte;
	})

	this.redirection = function(path) {
		$location.path(path);
	}

	this.deconnexion = function() {
		//console.log("MainController : deconnexion")
		sessionStorage.idConnecte = null;
		sessionStorage.role = "Guest";
		sessionStorage.noCompte = null;
		this.redirection('/');
	}
}

App.controller("MainController", MainController);