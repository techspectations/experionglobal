angular.module('newsapp').factory('topstories',function($q, $http) {

    var topstories = {};
    
    var getTopStories = function() {
        var deferred = $q.defer();
        $http({
            method: 'GET',
            url: 'https://developer.manoramaonline.com/api/editions/en/sections/top-stories/articles'
        }).success(function(data, status, headers, config) {
            deferred.resolve(data);
        }).error(function(data, status, headers, config) {
            deferred.resolve(false);
        });
        return deferred.promise;
    };

    topstories.getTopStories = getTopStories;

    return topstories;
});