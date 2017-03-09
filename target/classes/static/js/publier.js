 var Myapp=angular.module("Publication",[]);
  Myapp.controller("publier", function($scope,$http,$rootScope,$q){
	  
	  
	
	$scope.commentaire={}
	$scope.publication={};
	
	
	$scope.publicationC={};
	$scope.publicationA={};
	$scope.aime={};
	$scope.exception={message:null};
	$scope.button=[];
	
	//modifier le text de commentaire
	$scope.change=function(text)	
	{$scope.commentaire.text=text;
	}
	$scope.changes=function(publicationC)	
	{$scope.publicationC=publicationC;
	}
	
	
	//testamis
	var test=function(i)
	{$http.get("/testaime/"+$scope.publication[i].id)
		  .success(function(data){
			 $scope.button[i]=data;
			 
			 
			 
		    	
		  });}
	
	//afficher les publication 
	
	
$http.get("/publicationUser")
.success(function(data){
	
$scope.publication = data;
console
for(var i=0;i<=$scope.publication.length;i++)
			  { 
			test(i)
			
		 };
			});	

	
	 //afficher les commentaires
	$rootScope.afficherCommentaire=function(id)
	{
	$scope.publicationA=null;
	$http.get("/commentairepublication/"+id)
	  .success(function(data){
		  $scope.publicationC = data;		
		
		
		 });}
	  //afficher les aimes 
			
	  $scope.afficheraime=function(id)
		{
			$scope.publicationC=null;
		
			  
			 $http.get("/aimepublicationAime/"+id)
			  .success(function(data){
				  $scope.publicationA = data;
			
				    });}
  
		  
			  
	   
	   //delete les aimes 
			  
			  $scope.deleteaime=function(id)
			  
			  { 
				  var self = this;
				  $http.get("/aime/"+id)
				.success(function(data){
				   $scope.aime = data;
					
					 $http.delete("/aimepublication/"+$scope.aime.id)
					  .success(function(data){
						$scope.aime= data;
						
						    });
					
				})
  } ;
	
 
  
	  
	  //inserer j'aime
	  $scope.saveAimer=function(id){
		  
		  $scope.aime.id++
			
		  var self = this;
		  
		$http.get("/myPub/"+id)
		  .success(function(data){
			self.publication = data;
			
	       $scope.aime.publication=data;
	       
	       console.log(data);
	       
	       
		 
			$http.post("aimepublication",$scope.aime)
			
			
				  .success(function(data){
					  $scope.aime=data;
					  
					  
					})
			
			
			
		  });
			
			//$scope.buttom="ne pas aime ";
			
			
		  };
		  
	  
	  
	  
	  
	 
	
	/*$scope.commentaire={"publication":{"id":""}}*/

	  $scope.saveCommentaire=function(id){
		  
		  
		
		 $scope.commentaire.id++
		
		  var self = this;
		  
		$http.get("/myPub/"+id)
		  .success(function(data){
			self.publication = data;
			
			 $scope.commentaire.publication=data;
			
			console.log($scope.commentaire.publication);
		$http.post("commentaire",$scope.commentaire)
			  .success(function(data){
				  $scope.commentaire=data;
				  
				 
				});			
		  });	
		
		
		
		
	  }; 
	  //afficher Publication d'un user qui connecte
	  $scope.loadPublication=function()
	  {
	  $http.get("/publicationUser")
	  .success(function(data){
		  $scope.publication = data;
		 
			});		
	  }
	  //delete Publication d'un user qui connecte
	  $scope.deletePublication=function(id)
	  {
	  $http.delete("/deletePublication/"+id)
	  .success(function(data){
		$scope.publicationUser = data;
		 
			});		
	  }
	  
	  
	  
	  
	  
	  
	  
	 
	 
	  });
  
  
  Myapp.controller('home', function($http,$scope){
	  var self = this;
	 
	  $http.get("/getLogerUser/")
	  .success(function(data) {
	    self.user = data;
	    $http.get("/count/"+self.user.username)
		  .success(function(data){
			 $scope.count1=data;
			 
			 console.log($scope.count1);
			 
		    	
		  });
	    
	    
	    
	    
	   
	  })
	});
  
  
  
  
 