angular.module('newsapp').factory('mynews',function($q, $http) {

    var mynews = {};

    var getMyNews = function(userID) {
        var deferred = $q.defer();
        $http({
            method: 'GET',
            url: 'http://localhost:8080/recommender/app/recommended-news/' + userID 
        }).success(function(data, status, headers, config) {
            deferred.resolve(data);
        }).error(function(data, status, headers, config) {
            deferred.resolve(false);
        });
        return deferred.promise;
    };

    mynews.getMyNews = getMyNews;
    
    return mynews;
});