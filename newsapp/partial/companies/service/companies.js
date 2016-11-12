angular.module('newsapp').factory('companies',function($q, $http) {

    var companies = {};

    var getCompanies = function() {
        var deferred = $q.defer();
        $http({
            method: 'GET',
            url: 'https://developer.manoramaonline.com/api/editions/en/sections/business_companies/articles'
        }).success(function(data, status, headers, config) {
            deferred.resolve(data);
        }).error(function(data, status, headers, config) {
            deferred.resolve(false);
        });
        return deferred.promise;
    };

    companies.getCompanies = getCompanies;

    return companies;
});