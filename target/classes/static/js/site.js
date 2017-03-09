
'use strict';
angular.module('plunker', [])
.controller('AirplanesCtrl', function($scope, $http,$location,$log,$stateParams) {
 $scope.states=$http.get("/users").success(function(data) {
			$scope.states=data;
		});

	
	$scope.startsWith = function(state, viewValue) {
		  return state.substr(0, viewValue.length).toLowerCase() == viewValue.toLowerCase();
		} 
    
	$scope.username=$stateParams.username;
	
	
	$http.get("/u/"+$scope.username)
     .success(function(data){
	 $scope.user=data;
	 
	 console.log( $scope.user)
    
	 
    })
	


	
	
	
	
});












