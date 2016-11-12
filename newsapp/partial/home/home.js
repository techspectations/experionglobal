angular.module('newsapp').controller('HomeCtrl',function($scope){
    var vm = this;


vm.logout = function(){
console.log("clicked");

localStorage.setItem("userId", "");
}
});

