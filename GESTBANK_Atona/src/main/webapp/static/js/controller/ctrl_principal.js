/**
 * 
 */
function MainController($location, $scope, $route) {

	var self = this;
	self.redirection= redirection;
	self.deconnexion=deconnexion;
	
	self.CurrentDate = new Date();
	
	self.user;
	

	 if (!$scope.role && !sessionStorage.role ){
	 self.deconnexion();
	 }
	 else if ($location.path()=='/')
	 {
	 self.deconnexion();
	}
	
	$scope.$watch(function() {
		return sessionStorage.role;
	}, function(newValue, oldValue) {
		this.role = newValue;
		$scope.role =  newValue;
		$scope.id = sessionStorage.idConnecte;
	})

	function redirection(path) {
		$location.path(path);
	}

	function deconnexion() {
		//console.log("MainController.deconnexion()")
		sessionStorage.idConnecte = null;
		sessionStorage.role = "Guest";
		sessionStorage.noCompte = null;
		self.user = null;
		this.redirection('/');
	}
	
	//------------------Prototype--------------------
}

App.controller("MainController", MainController);