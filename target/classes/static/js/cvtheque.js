var Myapp=angular.module("JobnetWork",["ngRoute"])
.config(function ($routeProvider,$locationProvider) {
		       $routeProvider
		       .when("/CvTheque.html", {
		         	  
		         	  templateUrl: "cvthequeroute/afficherCvtheque.html",
		         	  controller: "gestionController1"
		         	  
		           })
		          
		          
		            .when("/candidatt/:username", {
		         	  
		         	  templateUrl: "cvthequeroute/profilCvtheque.html",
		         	  controller: "Controller12"
		         	  
		         	  
		           })
		         .otherwise({
		         	  redirectTo : "/CvTheque.html"
		           })
		           
		           
		        
		 })
		      
		         .controller("gestionController1", function($scope,$http) {
		        	 $scope.Candidat={};
		        	 $scope.u=null;
		        		 $http.get("/candidat")
		        		 .success(function(data){ 
		        		  $scope.Candidat=data;
		        		  
		        		 
		        		 
		        		 })	;
		            
		 		
		 })


		 .controller('home', function($http,$scope) {
		 	  var self = this;
		 	  $scope.fichier={};
		 	  $http.get('/getLogerUser/').success(function(data) {
		 	    self.user = data;
		 	    
		 	   
		 	  })
		 	})

		 .controller("Controller12", function($scope,$http,$location,$routeParams) {
			 $scope.Candidat={};
			 $scope.username=$routeParams.username;
	         
				 $http.get("/u/"+$scope.username)
				 .success(function(data){
				   
					   $scope.Candidat=data;
					   
					   $scope.u="fff";
					   console.log($scope.Candidat )
					   
				 })	;
				 


		 })
		 /*.controller("Postulation",function($scope,$http){
		 	$scope.postuleroffre={}
		 	$scope.id_Offre;
		 	$scope.postulation=null;
		 	
		 	$scope.postuler=function(){
		 		$http.post("postuleoffre?idOffre="+$scope.id_Offre)
		 		.success(function(data){
		 			 $scope.offre=data;
		 		 })
		 			
		 	}
		 });

		 */




