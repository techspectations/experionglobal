angular.module('newsapp').factory('music',function($q, $http) {

    var music = {};
      var getMusic = function() {
        var deferred = $q.defer();
        $http({
            method: 'GET',
            url: 'https://developer.manoramaonline.com/api/editions/en/sections/entertainment_music/articles'
        }).success(function(data, status, headers, config) {
            deferred.resolve(data);
        }).error(function(data, status, headers, config) {
            deferred.resolve(false);
        });
        return deferred.promise;
    };

    music.getMusic = getMusic;
    return music;
});