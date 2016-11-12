angular.module('newsapp').controller('MusicCtrl',function($scope, music){

var ms = this;

    music.getMusic().then(function(res){
        console.log(res);
        if(res){
            ms.music = res;
        }else{
            console.log("Yikes, no data found!");
        }
    });

});