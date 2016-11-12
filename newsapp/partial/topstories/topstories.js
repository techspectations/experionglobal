angular.module('newsapp').controller('TopstoriesCtrl',function($scope, topstories){

    var vm = this;

    topstories.getTopStories().then(function(res){
        console.log(res);
        if(res){
            vm.topstories = res;
        }else{
            console.log("Yikes, no data found!");
        }
    });

});