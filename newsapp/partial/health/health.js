angular.module('newsapp').controller('HealthCtrl',function($scope, health){

    var hl = this;

    health.getHealth().then(function(res){
        console.log(res);
        if(res){
            hl.health = res;
        }else{
            console.log("Yikes, no data found!");
        }
    });

});