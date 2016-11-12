angular.module('newsapp').factory('cricket',function($q, $http) {

    var cricket = {};

    var getCricket = function() {
        var deferred = $q.defer();
        $http({
            method: 'GET',
            url: 'https://developer.manoramaonline.com/api/editions/en/sections/sports_cricket/articles'
        }).success(function(data, status, headers, config) {
            deferred.resolve(data);
        }).error(function(data, status, headers, config) {
            deferred.resolve(false);
        });
        return deferred.promise;
    };

    cricket.getCricket = getCricket;

    return cricket;
});