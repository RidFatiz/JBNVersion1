var Myapp = angular.module('Inscription', []);



Myapp.controller("gererinscription",function($scope,$http,$location) {
	
		$scope.user={};
		$scope.candidat={};
		$scope.errors=null;
		$scope.exception={message:null};
		$scope.ex=null;
      $scope.inscritUser=function(){
    	  
 		 $http.post("user",$scope.user)
 		 .success(function(data){
 		   if(!data.errors){
 			   
 			   $scope.user=data;
 			   $scope.errors=null;
 			   alert( "nous avons envoyé un mail de confirmation a votre boite mail!" );
 			   
 			   console.log("hh");
 		   }
 		   else{
 			   $scope.errors=data;
 		   }
 		 })	
 		.error(function(data){
 			$scope.exception.message=data.message;
 			
 			
 			$scope.ex=alert("email déja utilisé");
 			
 			
 		});
 				           
       };
       //completer compte de candidat
       
              $scope.saveCandidat=function(){
      	          $http.post("candidat",$scope.home.user)
      	          .success(function(data){
      		      $scope.home.user=data;
      			 });			
                 }; 
                 
                 
                 
                 $scope.saveRecruteur=function(){
         	          $http.post("recruteur",$scope.home.user)
         	          .success(function(data){
         		      $scope.home.user=data;
         			 });			
                    }; 
                 
         
             $scope.deletePhoto=function(id){
            	 $http.post("/deletephoto/"+id)
     	          .success(function(data){
     		      $scope.home.user=data;
     			 });
            	 
            	 
                 }
             
             
             
             
             $scope.updatepassword=function()
                 	{
            	 $scope.old;
            	 $scope.news;
            	 
            	
            	 $http.post("updatePassword?old="+$scope.old+"&new="+ $scope.news)
    	          .success(function(data){
    	        	  
    	        	  if(data=="valid")
    	        		  {
    	        		  $scope.user=data;
        	        	  alert("votre password est changé")
    	        		  }
    	        	  else 
    	        		  alert("votre password n'est pas changé");
    	        		  
    	        	  
    			 })
    			 .error(function(data){
    		 			$scope.exception.message=data.message;
    		 			
    		 			
    		 			alert("vous avez une erreur");
    		 			
    		 			
    		 		}); 
                 	}
             
             $scope.updateGmail=function()
          	{
     	 $scope.oldGmail;
     	 $scope.newsGmail;
     	 
     	
     	 $http.post("updateGmail?OldGmail="+$scope.oldGmail+"&NewGmail="+$scope.newsGmail)
	          .success(function(data){
	        	  
	        	  if(data=="valid")
	        		  {
	        		  $scope.user=data;
 	        	  alert("votre Gmail est changé")
	        		  }
	        	  else 
	        		  alert("votre avez oublié votre email ");
			 })
			 .error(function(data){
		 			$scope.exception.message=data.message;
		 			
		 			
		 			alert("changer un  email ");
		 			
		 			
		 		}); 
          	}
             
             

});



Myapp.controller('home', function($http,$scope) {
	$scope.secteur=["Administration publique","Agriculture","Architecture et urbanisme","Assurrance","Automatismes Industriels","Banque","Biens de comsommetioms","Biens et équipements pour les entreprise","Centre de recherches","Chimie","Comptabilité","Design","Etude de marché","Formations à distance","Génie civil","Hôtellerie et hébergements","Immobilier","Industrie","Internet","Logiciels informatiques","Logistique et chaîne d'approvisionnement","Marketing et publicité","Matériel informatique","Média","Photographie","Presse","Réseaux informatique","Ressources humaines","Sécurité informatique et des réseaux","Télécommunications"];
	  var self = this;
	  $http.get("/getLogerUser/")
	  .success(function(data) {
	    self.user = data;
	    
	   
	  })
	});
Myapp.controller("page",function($scope,$http,$location){
	$scope.postulation={};
$http.get("/users")
.success(function(data){
	$scope.user = data;
	console.log(data)
	 
		});		
	
});
