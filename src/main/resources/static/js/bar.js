'use strict';

/* Controllers Module for studentDetailApp application*/
var studentControllerModule =  angular.module('application', ['ui.bootstrap']);

/*StudentController: controller for  students*/
studentControllerModule.controller('noteProfil', function( $scope,$http) {  


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