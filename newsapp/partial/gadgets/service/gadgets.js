angular.module('newsapp').factory('gadgets',function($q, $http) {

    var gadgets = {};
    var getGadgets = function() {
        var deferred = $q.defer();
        $http({
            method: 'GET',
            url: 'https://developer.manoramaonline.com/api/editions/en/sections/business_gadgets/articles'
        }).success(function(data, status, headers, config) {
            deferred.resolve(data);
        }).error(function(data, status, headers, config) {
            deferred.resolve(false);
        });
        return deferred.promise;
    };

    gadgets.getGadgets = getGadgets;
    return gadgets;
});