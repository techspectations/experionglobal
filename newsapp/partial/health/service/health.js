angular.module('newsapp').factory('health',function($q, $http) {

    var health = {};
     var getHealth = function() {
        var deferred = $q.defer();
        $http({
            method: 'GET',
            url: 'https://developer.manoramaonline.com/api/editions/en/sections/wellness_health/articles'
        }).success(function(data, status, headers, config) {
            deferred.resolve(data);
        }).error(function(data, status, headers, config) {
            deferred.resolve(false);
        });
        return deferred.promise;
    };

    health.getHealth = getHealth;
    return health;
});