angular.module('newsapp').controller('CompaniesCtrl',function($scope, companies){

    var cp = this;

    companies.getCompanies().then(function(res){
        console.log(res);
        if(res){
            cp.companies = res;
        }else{
            console.log("Yikes, no data found!");
        }
    });

});