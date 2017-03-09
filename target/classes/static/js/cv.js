 
var Myapp=angular.module("JobnetWork",[]);
Myapp.controller('home', function($http,$scope,$rootScope,$filter) {
	  var self = this;
	 
	  
	  $scope.id=null;
	  $scope.dateFormat=$filter('date')(new Date(),'yyyy');
	  $scope.date=null;
	 
	$http.get('/getLogerUser/')
	  .success(function(data) {
	    self.user = data;
	    $scope.date=$filter('date')(self.user.dateNaissance,'yyyy');
	    
	    $scope.id= self.user.username;
	   
	    $http.get("/competence/"+$scope.id)
		  .success(function(data) {
			  self.competence = data;
			  
			  });
	    
	    
	    $http.get("/langue/"+$scope.id)
		  .success(function(data) {
			  self.langue = data;
			  
			  });
	    
	    $http.get("/loisir/"+$scope.id)
		  .success(function(data) {
			  self.loisir = data;
			  
			  });
	    
	    $http.get("/experience/"+$scope.id)
		  .success(function(data) {
			  self.experience= data;
			  
			  });
	    
	    $http.get("/diplome/"+$scope.id)
		  .success(function(data) {
			  self.diplome = data;
			  
			  });
	  });
	
	
		 
		 
		  
		  
		 
		    
	 
	});
  