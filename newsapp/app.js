angular.module('newsapp', ['ui.bootstrap', 'ui.router', 'ngAnimate', 'angular-input-stars']);


angular.module('newsapp').factory('httpRequestInterceptor', function () {
  return {
    request: function (config) {
      config.headers['Authorization'] = 'eca7290f-248f-53e1-aee1-c8b651533e54';
      config.headers['Accept'] = 'application/json;odata=verbose';
      return config;
    }
  };
});

angular.module('newsapp').config(function ($httpProvider) {
  $httpProvider.interceptors.push('httpRequestInterceptor');
});

angular.module('newsapp').config(function($stateProvider, $urlRouterProvider) {

    $stateProvider.state('home', {
        url: '/home',
        templateUrl: 'partial/home/home.html',
        controller: 'HomeCtrl',
        controllerAs: 'hm'
    });
    $stateProvider.state('signup', {
        url: '/signup',
        templateUrl: 'partial/signup/signup.html',
        controller: 'SignupCtrl',
        controllerAs: 'sg'
    });
    $stateProvider.state('login', {
        url: '/login',
        templateUrl: 'partial/login/login.html',
        controller: 'LoginCtrl',
        controllerAs: 'lg'
    });


    $stateProvider.state('home.topstories', {
        url: '/topstories',
        templateUrl: 'partial/topstories/topstories.html',
        controller:'TopstoriesCtrl',
        controllerAs:'ts'
    });
    $stateProvider.state('home.cricket', {
        url: '/cricket',
        templateUrl: 'partial/cricket/cricket.html',
        controller:'CricketCtrl',
        controllerAs:'ck'
    });
    $stateProvider.state('home.article', {
        url: '/article/:articleID',
        templateUrl: 'partial/article/article.html',
        controller:'ArticleCtrl',
        controllerAs:'at'
    });
    $stateProvider.state('home.mynews', {
        url: '/mynews',
        templateUrl: 'partial/mynews/mynews.html',
        controller:'MynewsCtrl',
        controllerAs:'mn'
    });
  
    $stateProvider.state('home.football', {
        url: '/football',
        templateUrl: 'partial/football/football.html',
        controller:'FootballCtrl',
        controllerAs:'fb'
    });
    $stateProvider.state('home.health', {
        url: '/health',
        templateUrl: 'partial/health/health.html',
        controller:'HealthCtrl',
        controllerAs:'hl'
    });
    $stateProvider.state('home.music', {
        url: '/music',
        templateUrl: 'partial/music/music.html',
        controller:'MusicCtrl',
        controllerAs:'ms'
    });
    $stateProvider.state('home.companies', {
        url: '/companies',
        templateUrl: 'partial/companies/companies.html',
        controller:'CompaniesCtrl',
        controllerAs:'cp'
    });
    $stateProvider.state('home.gadgets', {
        url: '/gadgets',
        templateUrl: 'partial/gadgets/gadgets.html',
        controller:'GadgetsCtrl',
        controllerAs:'gg'
    });
    /* Add New States Above */
    $urlRouterProvider.otherwise('/home');

});

angular.module('newsapp').run(function($rootScope, $state) {


    $rootScope.safeApply = function(fn) {
        var phase = $rootScope.$$phase;
        if (phase === '$apply' || phase === '$digest') {
            if (fn && (typeof(fn) === 'function')) {
                fn();
            }
        } else {
            this.$apply(fn);
        }
    };

    $rootScope.article = function(articleID){
        if(articleID){
            $state.go('home.article', {articleID:articleID});
        }else{
            // 
        }
    };


    if($state.current.name != 'login' && $state.current.name != 'signup' ){
        var userId = localStorage.getItem('userId');
        if(!userId){
            $state.go('login');
        }
    }

});
