var App=angular.module("application",['ui.bootstrap','ui.bootstrap.typeahead' ,"ngRoute"]);

App.config(function($routeProvider,$locationProvider){
	$routeProvider
	.when('/CompleterProfil',{
		templateUrl:'/completerProfil.html',
		controller:'gererinscription'
	   }).when('/perso',{
		templateUrl:'/perso',
		controller:'gererinscription'
	   }).when('/formations',{
			templateUrl:'/formations',
			controller:'profilCandidat'
	   }).when('/loisirs',{
			templateUrl:'/loisirs',
			controller:'profilCandidat'
	    }).when('/langues',{
			templateUrl:'/langues',
			controller:'profilCandidat'
		}).when('/competences',{
			templateUrl:'/competences',
			controller:'profilCandidat'
		}).when('/ProfilRecruteur',{
			templateUrl:'/completerProfilRecruteur.html',
			controller:'gererinscription'
		}).when('/alertePostulation',{
			templateUrl:'/alertePostulation.html',
		})
	      .when('/cvLettre',{
			templateUrl:'/cvLettre.html',
		}).when('/alerteAnnonce',{
			templateUrl:'/alerteAnnonce.html',
			controller:'gestionAlerte'
		}).when('/activerAlerte',{
			templateUrl:'/activerAlerte.html',
		}).when('/changerEmail',{
			templateUrl:'/changerEmail.html',
			controller:'gererinscription'
		}).when('/desactiverCompte',{
			templateUrl:'/desactiverCompte.html',
		}).when('/changerPassword',{
			templateUrl:'/changerPassword.html',
			controller:'gererinscription'
		}).when('/publicationUser',{
			templateUrl:'/pubCandidat.html',
			controller:'publierAmis'
		}).when('/myPub',{
			templateUrl:'/afficherMyPublicationC.html',
			controller:'MyPublication'
		})
		.when('/publicationUserR',{
			templateUrl:'/pubRecruteur2.html',
			controller:'publierAmis'
		}).when('/myPubR',{
			templateUrl:'/afficherPublicationR.html',
			controller:'MyPublication'
		})
		.when('/postulation',{
			templateUrl:'/PagePostuler.html',
			controller:'GererPostulation'
		})
		
		.when('/annonce',{
			templateUrl:'/annonce.html',
			controller: "gestionController1"
		}).when('/Myannonce',{
			templateUrl:'/AfficherOffreRecruteur.html',
			controller: "gestiondeoffre"
		}).when('/pubAnnonce',{
			templateUrl:'/pubAnnonce.html',  
			controller:'gestiondeoffre'
		}).when('/profilC',{
			templateUrl:'/ProfilC.html',
			controller:'home'
		}).when('/profilE',{
			templateUrl:'/completerProfilEntreprise.html',
			controller:'home'
		}).when('/profilR',{
			templateUrl:'/ProfilR.html',
			controller:'home'
		}).when("/u/:username", {
      	  controller: "ProfilAmi",   
      	  templateUrl: "/PageCandidat.html"

        })
		.when('/confirmModal_modal_postdelete',{
			templateUrl:'/final.html#/pub#/confirmModal_modal_postdelete'
		}).when('/confirmModal_modal_commentdelete',{
			templateUrl:'/confirmModal_modal_commentdelete'
		})
		
		.when('/confirmModal_modal_profileimagedelete',{
			templateUrl:'/confirmModal_modal_profileimagedelete'
		})
		.when("/offre/:id_Offre", {
        	  templateUrl: "offreRoute/postuleroffre.html",
        	  controller: "Controller12"  
        })
      
		.when('/404',{
			templateUrl:'/404.html'
		})
		.when('/groupe',{
		templateUrl:'/creergroupe.html',
		controller:'gestiongroupe'
	   })
	   .when("/groupe2/:idGroupe", {
      	  controller: "AffichagePublicationGroupe",   
      	  templateUrl: "/PublicationGroupe.html"

        })
        .when("/groupe3/:idGroupe", {
      	  controller: "AffichagePublicationGroupe",   
      	  templateUrl: "/PageGroupe.html"

        })
        
        .when('/formation',{
		templateUrl:'/PageFormation.html',
		controller:'gestionformation'
	   })
	   .when('/Voirformation',{
		templateUrl:'/afficherFormation.html',
		controller:'gestionformation'
	   })
	   .when('/LancerTest',{
		templateUrl:'/affichageTest.html',
		controller:'gestionTest'
	   })
	    .when('/creerTest',{
		templateUrl:'/CreerTest.html',
		controller:'gestionTest'
	   })
	   
	   .when("/test12/:idTest", {
      	  controller: "AfficherTestQuestion",   
      	  templateUrl: "/PageTest.html"

        })
         .when("/test4/:idTest", {
      	  controller: "AfficherTestQuestion",   
      	  templateUrl: "/test3.html"

        })
		.otherwise({
			redirectTo:'/'
		});
});

App.controller("MyPublication", function($scope,$http,$rootScope,$q){
	$scope.commentaire={}
	
	
	$scope.users={"publication":{}}
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
	 
	 //delete Publication d'un user qui connecte
	  $scope.deletePublication=function(id)
	  {
	  $http.delete("/deletePublication/"+id)
	  .success(function(data){
		$scope.publicationUser = data;
		 
			});		
	  }
	  
	 });
  





App.controller("publierAmis", function($scope,$http,$rootScope,$q){
	$scope.commentaire={}
	
	
	$scope.users={"publication":{}}
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
$http.get("/publication")
	  .success(function(data){
		$scope.publication = data;
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
	 
	 //delete Publication d'un user qui connecte
	  $scope.deletePublication=function(id)
	  {
	  $http.delete("/deletePublication/"+id)
	  .success(function(data){
		$scope.publicationUser = data;
		 
			});		
	  }
	  
	 });
  App.controller("gererinscription",function($scope,$http,$location) {
		
		$scope.user={};
		$scope.candidat={};
		$scope.errors=null;
		$scope.exception={message:null};
		$scope.ex=null;
		$scope.secteur=["Administration publique","Agriculture","Architecture et urbanisme","Assurrance","Automatismes Industriels","Banque","Biens de comsommetioms","Biens et équipements pour les entreprise","Centre de recherches","Chimie","Comptabilité","Design","Etude de marché","Formations à distance","Génie civil","Hôtellerie et hébergements","Immobilier","Industrie","Internet","Logiciels informatiques","Logistique et chaîne d'approvisionnement","Marketing et publicité","Matériel informatique","Média","Photographie","Presse","Réseaux informatique","Ressources humaines","Sécurité informatique et des réseaux","Télécommunications"];
    $scope.inscritUser=function(){
  	  
		 $http.post("user",$scope.user)
		 .success(function(data){
		   if(!data.errors){		   
			   $scope.user=data;
			   $scope.errors=null;
			   alert( "nous avons envoyé un mail de confirmation a votre boite mail!" );
		   }
		   else{
			   $scope.errors=data;
		   }})	
		.error(function(data){
			$scope.exception.message=data.message;
			$scope.ex=alert("email déja utilisé");
		});				           
     };
   //completer compte de candidat 
     $scope.savepasswordforget=function(){
	          $http.post("updatepasswordforget",$scope.home.user)
	          .success(function(data){
		      $scope.home.user=data;
			 });			
        }; 
        
     
     //completer compte de candidat 
            $scope.saveCandidat=function(){
    	          $http.post("candidat",$scope.home.user)
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
                 
    //completer compte de Recruteur          
               $scope.saveRecruteur=function(){
       	          $http.post("recruteur",$scope.home.user)
       	          .success(function(data){
       		      $scope.home.user=data;
       		      alert("vous avez enregistré votre compte avec succès ")
       			 })
       			 .error(function(data){
     	 			$scope.exception.message=data.message;
    	 			alert("Répeter cette opération ");
    	 		}); 
                  }; 
               
       
           $scope.deletePhotoEntreprise=function(id){
          	 $http.post("/deletephotoEntreprise/"+id)
   	          .success(function(data){
   		      $scope.home.user=data;
   			 });
          	}
           $scope.deleteCv=function(id){
            	 $http.post("/deletecv/"+id)
     	          .success(function(data){
     		      $scope.home.user=data;
     			 });
            	}
           
           $scope.deleteLettre=function(id){
            	 $http.post("/deletelettre/"+id)
     	          .success(function(data){
     		      $scope.home.user=data;
     			 });
            	}
           
           
           
           $scope.goemail=function()
          	{
     	             $scope.mail;
     	           $scope.password;
     	 $http.post("MailUpdatePassword?mail="+$scope.email)
           .success(function(data){
         	  
         	  if(data==true)
         		  {
   	        	  alert("nous avons envoyé un mail")
         		  }
         	  else 
         		  alert("ce compte n'existe pas");
   		 });
   		  
          	}
           
           $scope.passwordforget=function()
       	{
  	             $scope.mail;
  	           $scope.password;
  	 $http.post("MailUpdatePassword?mail="+$scope.mail+"&password="+$scope.password)
        .success(function(data){
      	  
      	  if(data==true)
      		  {
	        	  alert("nous avons envoyé un mail")
      		  }
      	  else 
      		  alert("ce compte n'existe pas");
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

 $scope.newsGmail;
 

 $http.post("updateGmail?NewGmail="+$scope.newsGmail)
     .success(function(data){
   	  

   		  $scope.user=data;
    	  alert("votre Gmail est changé")
    	  }).error(function(data){
			$scope.exception.message=data.message;
			
			
			alert("changer un  email ");
			
			
		}); 
 	}
           

});

  App.controller("profilCandidat", function($scope,$http){
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
			console.log(data);
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
  
  App.controller("gestiondeoffre", function($scope,$http){
		

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
			  	  
			  	  $scope.afficherOffre=function(){
			  		  
			  		  $http.get("/OffreRecruteur") 
			  		.success(function(data){
			  		 $scope.offre=data;
			  		 console.log(data);
			  		 });
			  	  }
			  
			  	  
			    });  
  App.controller('gestionAlerte', function($scope,$http) {
	  $scope.secteur=["Administration publique","Agriculture","Architecture et urbanisme","Assurrance","Automatismes Industriels","Banque","Biens de comsommetioms","Biens et équipements pour les entreprise","Centre de recherches","Chimie","Comptabilité","Design","Etude de marché","Formations à distance","Génie civil","Hôtellerie et hébergements","Immobilier","Industrie","Internet","Logiciels informatiques","Logistique et chaîne d'approvisionnement","Marketing et publicité","Matériel informatique","Média","Photographie","Presse","Réseaux informatique","Ressources humaines","Sécurité informatique et des réseaux","Télécommunications"];
	  $scope.region=["Rabat","Marrakech","Casablanca","Fès","Tanger","Agadir","Essaouira","Meknès","Oujda","Ouarzazate","Tétouan","Chefchaouen","El Jadida","Salé","Ifrane","Nador","Larache","Kénitra","Béni Mallal","Mohammédia","Safi","Al Hoceîme","Assilah","Taroudan","Azrou","Berrechid","Azemmour","Tafraout","Taza","Province d'Errachidia","Moulay Ali Cherif","Zagora","Inezgane","Guelmim","Sidi Slimane","OULAD Teîma","Sidi Ifni","Bouznika","Oualidia","Tan-Tan","Laâyoune"];
	  
		$scope.alert={};
	
		//inserer alertes
		$scope.savealerte=function(){		
			$http.post("alert",$scope.alert)
			 .success(function(data){			   
				   $scope.alert=data;
			alert("vous avez envoyé votre alerte avec succées ")
			})
			.error(function(data){
	 			alert("réssayer l'opération");
	 		}); 
			
		}});



App.controller('home', function($http,$scope) {
	
	var self=this;
	 $scope.secteur=["Administration publique","Agriculture","Architecture et urbanisme","Assurrance","Automatismes Industriels","Banque","Biens de comsommetioms","Biens et équipements pour les entreprise","Centre de recherches","Chimie","Comptabilité","Design","Etude de marché","Formations à distance","Génie civil","Hôtellerie et hébergements","Immobilier","Industrie","Internet","Logiciels informatiques","Logistique et chaîne d'approvisionnement","Marketing et publicité","Matériel informatique","Média","Photographie","Presse","Réseaux informatique","Ressources humaines","Sécurité informatique et des réseaux","Télécommunications"];
	 $http.get("/getLogerUser/")
	  .success(function(data) {
	   self.user = data;
	    
	   $http.get("/count/"+self.user.username)
		  .success(function(data){
			 $scope.countpublication=data;
			 
			 console.log($scope.countpublication);
			 
		    	
		  });
	   
	   $http.get("/CountPostulationUser/"+self.user.username)
		  .success(function(data){
			 $scope.countpostulation=data;
			 
			 console.log($scope.countpostulation);
			 
		    	
		  });
	   $http.get("/countAmis/"+self.user.username)
		  .success(function(data){
			 $scope.countAmis=data;
			 
			 console.log(countAmis);
			 
		    	
		  });
	   
	   
	   
	    
	   
	   
	  })
	});


App.controller("GererPostulation",function($scope,$http,$location){
	$scope.postulation={};
$http.get("/getpostuleoffre")
.success(function(data){
	$scope.postulation = data;
	console.log(data)
	 
		});		
	
});
App.controller('noteProfil', function( $scope,$http) {  


	$scope.noteDiplome=null;
	$scope.noteCompetence=null;
	$scope.noteLoisir=null;
	$scope.noteExperience=null;
	$scope.noteLangue=null;
	$scope.noteProfil=null;

	$http.get("/noteDiplome")
	.success(function(data){
	$scope.noteDiplome=data;
	console.log($scope.noteDiplome);
	});

	$http.get("/notecompetence")
	.success(function(data){
	$scope.noteCompetence=data;	
	console.log($scope.noteCompetence);
	});  
	$http.get("/noteExperience").success(function(data){
	$scope.noteExperience=data;
	});
	$http.get("/noteLangue").success(function(data){
	$scope.noteLangue=data;
	});
	$http.get("/noteLoisir").success(function(data){
	$scope.noteLoisir=data;
	});
	$http.get("/noteProfil").success(function(data){
	$scope.noteProfil=data;
	});   
	    
	    
	    

	});


App.controller("gestionController1", function($scope,$http) {

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
   			 });
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
       };
 })
 ;
 App.controller("Controller12", function($scope,$http,$routeParams) {
	 $scope.offre={};
	$scope.id_Offre=$routeParams.id_Offre;
    $scope.postuleroffre={};
    
    
	$http.get("/offreId/"+$scope.id_Offre)
       .success(function(data){
	 $scope.offre=data;
	 
	 console.log(data);
    })

    $scope.postuler=function(){
		$http.post("postuleoffre?idOffre="+$scope.id_Offre)
		.success(function(data){
			console.log(data);
			
			if(data=='false'){
				
			alert("vous avez déja postulé");
			console.log(data);
			}
			else if(data=='true'){
			alert("vous avez bien  postulé");
			console.log(data);
							
			} 
			
			
			
			
		 })

	}
});
 App.controller("gestioninvitation",function($scope,$http){
		
		$scope.invitation={};
		$scope.recommendations={};
		$scope.invitationEnvoyee={};
		$scope.invitationRecue={};
		$scope.amis={};
		$scope.user={};
		$scope.idInvitation;
		$scope.myVar;
		$scope.search;
		$scope.visiteurs={};
		
		$scope.username
		$scope.envoyerInvitation=function(id){
			
		      $http.post("invitation/"+id,$scope.invitation)
		          .success(function(data){
			          $scope.invitation=data;
			          //$scope.myVar = "Annuler";
			          
		           });
		     };
		     
		     
		     $scope.envoyerRecommendation=function(id){
		    	 
			      $http.post("recommendation/"+id,$scope.recommendations)
			          .success(function(data){
				          $scope.recommendations=data;
				          console.log(data)
				          //$scope.myVar = "Annuler";
				          
			           });
			     };
			     
			 $scope.accepterInv=function(i){
				      $http.put( "/amis/accepter/"+i)
				          .success(function(data){
					          $scope.invitation=data;				          
				           });
				     };
			$scope.annulerInv=function(i){
			      $http.delete( "/invitation/"+i)
			          .success(function(data){
				          $scope.invitation=data;
				          //$scope.myVar = "Inviter";
				          
			           });
			     };
			     
		    
			  		 $http.get("/invitation/send") 
			  		    .success(function(data){
			  			 $scope.invitationEnvoyee=data;
			  		 })
			  	   
			 	   
			
			  		 $http.get("/invitation/receive") 
			  		    .success(function(data){
			  			 $scope.invitationRecue=data;
			  		 })
			  	
			  		 $http.get("/amis") 
			  		    .success(function(data){
			  			 $scope.amis=data;
			  	  })
			  
			  	
			  	
			  	var test=function(i)
				{
			  		
			  		$http.get("/test/"+$scope.user[i].username)
					  .success(function(data){
						 $scope.myVar=data;
						 console.log($scope.myVar);
						});}
				
			
			  	$scope.states=$http.get("/users").success(function(data) {
			  		$scope.states=data;
				})
				
				$scope.groupeall=$http.get("/GroupeAll").success(function(data) {
			  		$scope.groupeall=data;
				})
				$scope.onSelect = function ($item, $model, $label) {
				    $scope.$item = $item;
				    $scope.$model = $model;
				    $scope.$label = $label;
				    console.log($scope.$item.username);
				    console.log($scope.$model);
				    console.log( $scope.$label);
				    
				    $http.post("visite/"+$scope.$item.username,$scope.visiteurs)
				    .success(function(data){
				    $scope.visiteurs=data;
				    console.log("hh");
					 
				   })
				    
				    
				};
				
				
				
				
			
});
 
 
 
 App.controller("ProfilAmi", function($scope,$http,$routeParams){
	
	 $scope.users={};
	 $scope.myVar;
	$scope.username=$routeParams.username;
	$scope.recommendation={};
	$scope.visiteurs={};
	$scope.vd={};
	
	$http.get("/u/"+$scope.username)
     .success(function(data){
	 $scope.users=data;
	 
    })
    
	 
    $http.get('/test/'+$scope.username).success(function(data) {
		   $scope.myVar= data;	
		  console.log($scope.myVar);
			});

	 $http.get("/recommendation/"+$scope.username) 
	    .success(function(data){
	    	$scope.recommendation=data;
		 });
	
	 $http.get("/visite").success(function(data) {
	  		$scope.visiteurs=data;
	  		console.log(data);
		})
		
	
});


 App.controller("gestiongroupe", function($scope,$http) {
 	$scope.groupes={};
 	$scope.groupe={};
 	$scope.findgroupe={};
 	$scope.groupemembre={};
 	
 			
 			$scope.envoyer=function(){
 			      $http.post("Groupe",$scope.groupes)
 			          .success(function(data){
 			        	  $scope.groupes=data;
 				          //$scope.myVar = "Annuler";
 			        	  
 			        	
 				          
 			           });
 			     };
 			     
 			     
 			    $http.get("/findUser")
		          .success(function(data){
		        	  $scope.groupemembre=data;
			          //$scope.myVar = "Annuler";
		        	  
		        	
			          
		           });
 			   $http.get("/Groupe")
		          .success(function(data){
		        	  $scope.groupe1=data;
			          //$scope.myVar = "Annuler";
		        	
		           });
			    
 			    
 			    $http.get("/GroupeAll")
 		          .success(function(data){
 		        	  $scope.groupeall=data;
 			          //$scope.myVar = "Annuler";
 		        	  
 		        	 
 			          
 		           });
 			    
 			   
 			    
 			     $scope.envoyerInvitationGroupe=function(id)
 			     {
 			    	 $http.post("Groupeuser/"+id,$scope.groupeuser)
 			          .success(function(data){
 			        	  $scope.groupeuser=data;
 				          //$scope.myVar = "Annuler";
 			        	  
 			        	
 			           }); 
 			    	 
 			     }
 			     
 			     $scope.Accepter=function(id)
 			     {
 			    	 $http.put("/AccepterGroupeUser/"+id)
 			          .success(function(data){
 			        	  $scope.groupeuser=data;
 				          //$scope.myVar = "Annuler";
 			        	
 				          
 			           }); 
 			    	 
 			     }
 			   //publier dans groupe
 			     $scope.publierPublication=function(id)
 			     {
 			    	 $http.post("publicationgroupe/"+id,$scope.publicationsgroupe)
 			          .success(function(data){
 			        	  $scope.publicationsgroupe=data;
 				          //$scope.myVar = "Annuler";
 			        	 
 			           }); 
 			    	 
 			     }
 			     
 			    	 $scope.deleteInvitation=function(id){
 			    	 $http.delete("/deleteInvitation/"+id)
 			          .success(function(data){
 			        	  $scope.groupeuser=data;
 				          //$scope.myVar = "Annuler";
 			        	 
 			           }); 
 			    	 }
 			   
 			     
 			     
 			     
 			     
 			 
 });


 App.controller("AffichagePublicationGroupe", function($scope,$http,$routeParams) {
	 	
	 	$scope.groupe2={};
	 	$scope.idGroupe=$routeParams.idGroupe;
	 	
	 			console.log($scope.idGroupe);
	 			
	 			    $http.get("/GroupeId/"+$scope.idGroupe)
	 		          .success(function(data){
	 		        	  $scope.groupe2=data;
	 			          //$scope.myVar = "Annuler";
	 		        	  
	 		        	
	 		           });
	 			    
	 			    
	 			   $scope.envoyerInvitationGroupe=function(id)
				     {
				    	 $http.post("Groupeuser/"+id,$scope.groupeuser)
				          .success(function(data){
				        	  $scope.groupeuser=data;
					          //$scope.myVar = "Annuler";
				        	
				           }); 
				    	 
				     }
	 			    //tester groupe 
	 			  $http.get("/groupeInvitation/"+$scope.idGroupe)
 		          .success(function(data){
 		        	  $scope.testInvitation=data;
 			          //$scope.myVar = "Annuler";
 		        	 
 		           });
	 			   
	 			    
	 			    
	 			   //publier dans groupe
	 			     $scope.publierPublication=function(id)
	 			     {
	 			    	 $http.post("publicationgroupe/"+id,$scope.publicationsgroupe)
	 			          .success(function(data){
	 			        	  $scope.publicationsgroupe=data;
	 				          //$scope.myVar = "Annuler";
	 			        	  
	 			           }); 
	 			    	 
	 			     }
	 			     
	  });
	 
 App.controller("AfficherTestQuestion", function($scope,$http,$routeParams) {
	 	
	 	$scope.idTest=$routeParams.idTest;
	 	$scope.tests={};
		$scope.questions=[];
		$scope.reponses=[];
		$scope.items=[];
		$scope.items.id;
		$scope.visiteurs={};
		$scope.questions.active=false;
		
		
		 $scope.addReponse=function(){
	  		$scope.questions.id++;
	  		$scope.items.push($scope.questions)
	  		
	  		};	
	 	 $scope.creerQuestion=function(id){
	    	  $scope.contenu;
	          $scope.active;
	          console.log($scope.questions.active)
	          
	  		 $http.post("question/"+$scope.idTest+"/"+id,$scope.questions)
	  		 .success(function(data){
	  			$scope.questions=data;
	  			  });
	       }
	 			
	 			   
	  }); 
	 
 App.controller('gestionformation', function($scope,$http) {
	 $scope.FormationsRecruteur={};
		
		$scope.ville=["Rabat","Marrakech","Casablanca","Fès","Tanger","Agadir","Essaouira","Meknès","Oujda","Ouarzazate","Tétouan","Chefchaouen","El Jadida","Salé","Ifrane","Nador","Larache","Kénitra","Béni Mallal","Mohammédia","Safi","Al Hoceîme","Assilah","Taroudan","Azrou","Berrechid","Azemmour","Tafraout","Taza","Province d'Errachidia","Moulay Ali Cherif","Zagora","Inezgane","Guelmim","Sidi Slimane","OULAD Teîma","Sidi Ifni","Bouznika","Oualidia","Tan-Tan","Laâyoune"];
		//publier dans groupe
	    $scope.saveformation=function()
	    {
	   	 $http.post("formationEntreprise",$scope.formations)
	         .success(function(data){
	        	 $scope.formations=data;
		          //$scope.myVar = "Annuler";
	       	  
	       	  
	          }); 
	   	 
	    }
	   //get formation de recruteur amis
	    $http.get("/PubFormation")
	    .success(function(data){
	  	  $scope.findFormations=data;
	        //$scope.myVar = "Annuler";
	  	 
	        
	     }); 
	  //get formation de recruteur 
	    $http.get("/FormationRecruteur")
	    .success(function(data){
	  	  $scope.FormationsRecruteur=data;
	        //$scope.myVar = "Annuler";
	  	 
	        
	     }); 
	    
	    
	});
 App.controller('gestionTest', function($scope,$http,$location) {
		
	 $scope.tests={};
	 $scope.test={};
	 //publierTest
	 
	 $scope.creertest=function(){
   	  
 		 $http.post("test",$scope.test)
 		 .success(function(data){
 			$scope.test=data;
 		
 			console.log($scope.test);
 			console.log(data.idTest);
 	
 			 window.location.href = "/FinalR.html#/test12/"+data.idTest;
 		   
                 });
      }
	 
	 $http.get("/testRecruteur")
	 .success(function(data){
			$scope.tests=data;
		   
              });
  
      $scope.addTest=function(){
  		$scope.questions.id++;
  		$scope.items.push($scope.questions)
  		
  		};	
      $scope.creerQuestion=function(id){
    	  $scope.contenu;
          $scope.active;
          
  		 $http.post("question/1/"+id,$scope.questions)
  		 .success(function(data){
  			$scope.questions=data;
  			  });
       }
	    
      $scope.deleteTest=function(id){
    	 
  		 $http.delete("/TestDelete/"+id)
  		 .success(function(data){
  			$scope.ty=data;
  			  });
       }
	    
	    
	});

 