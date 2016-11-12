angular.module('newsapp').factory('login',function($q, $http) {

    var login = {};
    
    var doLogin = function(formData){
        var deferred = $q.defer();
        $http({
            method: 'POST',
            url: 'http://localhost:8080/recommender/app/login',
            headers: formData
        }).success(function(data, status, headers, config) {
            deferred.resolve(data);
        }).error(function(data, status, headers, config) {
            deferred.resolve(false);
        });
        return deferred.promise;
    }


    login.doLogin = doLogin;

    return login;
});