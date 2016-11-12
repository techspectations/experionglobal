angular.module('newsapp').controller('GadgetsCtrl',function($scope, gadgets){
    var gg = this;

    gadgets.getGadgets().then(function(res){
        console.log(res);
        if(res){
            gg.gadgets = res;
        }else{
            console.log("Yikes, no data found!");
        }
    });
});