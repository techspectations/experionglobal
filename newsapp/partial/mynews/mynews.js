angular.module('newsapp').controller('MynewsCtrl',function($scope, mynews){
    
    var mn = this;

    var userID = localStorage.getItem('userId');

    mynews.getMyNews(userID).then(function(res){
        console.log(res);
        if(res){
            mn.mynews = res; 
        }else{
            console.log("Yikes, no data found!");
        }
    });
});