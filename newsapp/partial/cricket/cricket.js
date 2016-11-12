angular.module('newsapp').controller('CricketCtrl',function($scope, cricket){

    var ck = this;

    cricket.getCricket().then(function(res){
        console.log(res);
        if(res){
            ck.cricket = res;
        }else{
            console.log("Yikes, no data found!");
        }
    });

});