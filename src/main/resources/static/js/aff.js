var App=angular.module("application",[]);


App.controller("gestiongroupe", function($scope,$http) {
	
	$scope.visiteurs={};
	
   
		 $http.get("/visite")
		 .success(function(data) {
		  		$scope.visiteurs=data;
		  		console.log(data);
			})
			

			
});

