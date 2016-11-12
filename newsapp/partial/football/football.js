angular.module('newsapp').controller('FootballCtrl',function($scope, football){

    var fb = this;

    football.getFootball().then(function(res){
        console.log(res);
        if(res){
            fb.football = res;
        }else{
            console.log("Yikes, no data found!");
        }
    });
});