var Myapp = angular.module('sample', []);


Myapp.controller("Test",function($scope,$http,$location) {
	
		$scope.tests={};
		$scope.questions=[];
		$scope.reponses=[];
		$scope.items=[];
		$scope.items.id;
		$scope.visiteurs={};

		 $scope.test={};
		 //publierTest
		 
		 $scope.creertest=function(){
	   	  
	 		 $http.post("test",$scope.test)
	 		 .success(function(data){
	 			$scope.test=data;
	 		
	 			console.log($scope.test.id);
	 			console.log(data);
	 			$location.path("")
	 		   
	                 });
	      }
		 
     
		
		
		
		
		
		
      $scope.addLoisir=function(){
  		$scope.questions.id++;
  		$scope.items.push($scope.questions)
  		
  		};	
      $scope.creerQuestion=function(id1,id2){
    	  $scope.contenu;
          $scope.active;
          
  		 $http.post("question/"+id1+"/"+id2,$scope.questions)
  		 .success(function(data){
  			$scope.questions=data;
  			  });
       }
      
      $scope.ajouter=function(){
    		 $http.post("visite/khadija",$scope.visiteurs)
    	     .success(function(data){
    	     $scope.visiteurs=data;
    	     console.log(data);
    		 
    	    })
    		 }
      
      
});

