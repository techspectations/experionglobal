angular.module('newsapp').factory('article',function($q, $http) {

    var article = {};

    var getArticle = function(articleID) {
        var deferred = $q.defer();
        $http({
            method: 'GET',
            url: 'https://developer.manoramaonline.com/api/editions/en/articles/' + articleID
        }).success(function(data, status, headers, config) {
            deferred.resolve(data);
        }).error(function(data, status, headers, config) {
            deferred.resolve(false);
        });
        return deferred.promise;
    };

    var postUserLike = function(data) {
        var deferred = $q.defer();
        $http({
            method: 'PUT',
            'Content-Type': 'application/json',
            url: 'http://52.66.159.145:8080/recommender/app/update-rate',
            data: data
        }).success(function(data, status, headers, config) {
            deferred.resolve(data);
        }).error(function(data, status, headers, config) {
            deferred.resolve(false);
        });
        return deferred.promise;
    };


    article.getArticle = getArticle;
    article.postUserLike = postUserLike;

    
    return article;
});