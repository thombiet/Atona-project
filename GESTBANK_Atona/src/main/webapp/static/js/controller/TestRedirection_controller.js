'use strict';

App.controller('MyController', ['$scope', '$location', function($scope, $location) {
      

	 $scope.firstName = "John",
	    $scope.lastName = "Doe"
	    $scope.myVar = false;
	    $scope.toggle = function() {
	        $scope.myVar = !$scope.myVar;
	    }
	    
	    
	    

}]);
