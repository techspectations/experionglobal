angular.module('newsapp').controller('LoginCtrl',function($scope, login, $state){
    var vm = this;
    vm.formData = {};
    var userId = localStorage.getItem('userId');
    if(userId){
        $state.go('home.topstories');
    }

    vm.login = function(){
        console.log(vm.formData);
        vm.formData['Content-Type'] = "application/json";

        login.doLogin(vm.formData).then(function(res){
            if(res.data){
                localStorage.setItem("userId", res.data.userId);
                $state.go('home.topstories');
            }else{
                // Handle error
            }
        });
    }

});