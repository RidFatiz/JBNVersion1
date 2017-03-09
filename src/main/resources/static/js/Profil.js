 var Myapp=angular.module("gestionProfil",[]);
 
 
 

 
  Myapp.controller("profilCandidat", function($scope,$http){
	  $scope.competence=[];
      $scope.items=[];
	  $scope.items.idCompetence;
	  $scope.diplome=[];
	  $scope.experience=[];
	  $scope.loisir=[];
	  
	  $scope.diplome.type=null;
	  $scope.competence.typeCompetence=null;
	  $scope.competence.description_Competence=null;
	  $scope.langue=[];
	  $scope.names = ["Emploi", "Stage"];
	 
	  
	  
    $scope.show=function()	  
	  { 
		  $http.get("/competence")
		  .success(function(data){
		  $scope.competence=data;
		})		
			/*items.splice($index, 1)*/		  
	  };
	$scope.deletet=function(item)	  
	  {
		  $http.delete("/competence/"+item.idCompetence)
		  .success(function(data){
			$scope.competence=data;
			})			
			/*items.splice($index, 1)*/		  
	  };
	 //ajouter competence
	  $scope.addCompetence=function(){		
		$scope.competence.idCompetence++
	    $scope.items.push($scope.competence)
		};
	  //ajouter diplome
	  $scope.addDiplome=function(){			
		 $scope.diplome.idDiplome++
		 $scope.items.push($scope.diplome)
		};
	 //ajouter experience
	  $scope.addExperience=function(){
		 $scope.experience.idExperience++
		 $scope.items.push($scope.experience)
		};
	 //ajouter langue
	  $scope.addLangue=function(){
		$scope.langue.idLangue++
		$scope.items.push($scope.langue)
		};
     //ajouter loisir
	 $scope.addLoisir=function(){
		$scope.loisir.idLoisir++
		$scope.items.push($scope.loisir)
		};	
	//enregitrer
	  $scope.saveDiplome=function()
	   {
		  $http.post("diplome",$scope.diplome)
		  .success(function(data){
			  
			$scope.diplome=data;
			})		  
	   };
    $scope.saveLangue=function()
	    {
		  $http.post("langue",$scope.langue)
		  .success(function(data){
			$scope.langue=data;
			})
	  };	  
	  $scope.saveExperience=function()
	  {
		  $http.post("experience",$scope.experience)
			.success(function(data){
			$scope.experience=data;
			})  
	  }; 
	  $scope.saveCompetence=function()
	  {
		  $http.post("competence",$scope.competence)
			.success(function(data){
			$scope.competence=data;
			})		  
	  };
	  $scope.saveLoisir=function()
	    {
		  $http.post("loisir",$scope.loisir)
		  .success(function(data){
			$scope.loisir=data;
			})
	  };
    });
  
  
  
  
 
  /*
  Myapp.controller('home', function($http) {
	  var self = this;
	  $http.get('/getLogerUser/').success(function(data) {
	    self.user = data;
	    
	  })
	});*/
  
  Myapp.controller('home', function($http,$scope) {
	  var self = this;
	  $scope.fichier={};
	  $http.get('/getLogerUser/').success(function(data) {
	    self.user = data;
	    
	    
	   
	  })
	});
  
 
		    
  
  
  