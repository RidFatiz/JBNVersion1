var app=angular.module("GestionOffre",["ngRoute"])
.config(function ($routeProvider,$locationProvider) {
      $routeProvider
      .when("/afficherAllOffre.html", {
        	  templateUrl: "offreRoute/afficheroffre.html",
        	  controller: "gestionController1"  
      }).when("/offre/:id_Offre", {
        	  templateUrl: "offreRoute/postuleroffre.html",
        	  controller: "Controller12"  
      })
        .otherwise({
        	  redirectTo : "/afficherAllOffre.html"
          })
})
     
        .controller("gestionController1", function($scope,$http) {
	
	        $scope.offre={};
	        $scope.pageCourant=0;
	   	    $scope.size=6;
	   	    $scope.pageoffre=[]
	   	    $scope.pages=[]
	   	    $scope.ville=null;
	   	    $scope.secteur=null
	   	    $scope.poste=null;
	  
	  $http.get("/offre?page="+$scope.pageCourant+"&size="+$scope.size) 
		 .success(function(data){
			$scope.offre=data;
			$scope.pages=new Array(data.totalPage)
		 })
		  $scope.goTopage=function(p){
		  $scope.pageCourant=p;
		  $http.get("/offre?page="+$scope.pageCourant+"&size="+$scope.size) 
				.success(function(data){
					$scope.offre=data;
					$scope.pages=new Array(data.totalPage)
				});
		     }
	  
	  
	  $scope.findOffre=function()
		 { 
		  if($scope.poste!=null || $scope.secteur!=null ||  $scope.ville!=null ){ 
			  $http.get("/offres1?ville="+$scope.ville+"&secteur="+$scope.secteur+"&poste="+$scope.poste+"&page="+$scope.pageCourant+"&size="+$scope.size)
				  .success(function(data){
					   $scope.offre=data;
					   $scope.pageoffre=data;
					   $scope.pages=new Array(data.totalPage);
						console.log("hh1");
					 });	  	
			} 
			 if(($scope.ville!=null && $scope.secteur!=null) || ($scope.poste!=null && $scope.secteur!=null) || ($scope.poste!=null && $scope.ville!=null )){					
				 $http.get("/offres2?ville="+$scope.ville+"&secteur="+$scope.secteur+"&poste="+$scope.poste+"&page="+$scope.pageCourant+"&size="+$scope.size)
					  .success(function(data){
						  $scope.offre=data;
						  $scope.pageoffre=data;
							$scope.pages=new Array(data.totalPage);
							console.log("hh2");
							
							
							
						  
					  } );
					  
			 }
				
			 
             if($scope.poste!=null && $scope.secteur!=null && $scope.ville!=null ){
            	 $http.get("/offres3?ville="+$scope.ville+"&secteur="+$scope.secteur+"&poste="+$scope.poste+"&page="+$scope.pageCourant+"&size="+$scope.size)
           		  .success(function(data){
           			  $scope.offre=data;
           			  $scope.pageoffre=data;
           				$scope.pages=new Array(data.totalPage);
           				console.log("hh3");
           				
           				
           				
           			  
           		  } );
           		  	
				} 
		 
		 
			
		  
		  
		
		  
		  
		  $scope.goTopage=function(p){
			  $scope.pageCourant=p;
				
				$http.get("/offres?ville="+$scope.ville+"&secteur="+$scope.secteur+"&poste="+$scope.poste+"&page="+$scope.pageCourant+"&size="+$scope.size)
						  
						 .success(function(data){
							 $scope.offre=data;
							  $scope.pageoffre=data;
							 $scope.pages=new Array(data.totalPage)
							 
						 });
		 
				
			}
		  /*$http.get("/offres?ville="+$scope.ville+"&secteur="+$scope.secteur+"&poste="+$scope.poste+"&page="+$scope.pageCourant+"&size="+$scope.size)
		  
			 .success(function(data){
				 $scope.offre=data;
				  $scope.pageoffre=data;
				 $scope.pages=new Array(data.totalPage)
				 
			 });

	
}
		  
		 
*/		  
		 };
		 
		 
	
        
	   
})


.controller('home', function($http,$scope) {
	  var self = this;
	  
	  $http.get('/getLogerUser/').success(function(data) {
	    self.user = data;
	    
	   
	  })
	})

.controller("Controller12", function($scope,$http,$routeParams) {
	 $scope.offre={};
	$scope.id_Offre=$routeParams.id_Offre;
    $scope.postule={};
    
    
	$http.get("/offreId/"+$scope.id_Offre)
       .success(function(data){
	 $scope.offre=data;
	 
	 console.log(data);
    })

$scope.postuler=function(){
		$http.post("postuleoffre?idOffre="+$scope.id_Offre)
		.success(function(data){
			
			console.log(data);
			if(data="false"){
				
			alert("vous étes déja bien   postulé"	);
				console.log(data);
				
			}
			else if(data="true") {
			alert("vous étes  postulé");
				console.log(data);
				
			}
			$scope.postule=data;	
			 
		 })
			
	}
 

})
;






























