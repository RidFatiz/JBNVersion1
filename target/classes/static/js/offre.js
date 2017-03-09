var Myapp=angular.module("JobNetwork",[]);
Myapp.controller("gestiondeoffre", function($scope,$http){
	
	$scope.secteur=["Administration publique","Agriculture","Architecture et urbanisme","Assurrance","Automatismes Industriels","Banque","Biens de comsommetioms","Biens et équipements pour les entreprise","Centre de recherches","Chimie","Comptabilité","Design","Etude de marché","Formations à distance","Génie civil","Hôtellerie et hébergements","Immobilier","Industrie","Internet","Logiciels informatiques","Logistique et chaîne d'approvisionnement","Marketing et publicité","Matériel informatique","Média","Photographie","Presse","Réseaux informatique","Ressources humaines","Sécurité informatique et des réseaux","Télécommunications"];
	$scope.typecontrant=["CDI Plein temps","CDI Temps pariel","CDD","CDI Temps pariel","Bénévole"];
	
		  	  $scope.offre={}
		  	  //inserer offre
		  	  $scope.saveOffre=function()
		  	  {$http.post("offre",$scope.offre)
		  		.success(function(data){
		  			$scope.offre=data;
		  			})
		  			
		  	  };
		  	  $scope.afficher=function()
		  	  //afficher offre
		  	  {$http.get("/offre") 
		  		.success(function(data){
		  		 $scope.offre=data;
		  		 })
		  	  };
		  	  
		    });

Myapp.controller('home', function($http,$scope) {
	  var self = this;
	  $scope.fichier={};
	  $http.get('/getLogerUser/').success(function(data) {
	    self.user = data;
	    
	    
	   
	  })
	});  

  
