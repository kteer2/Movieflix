(function () {
    'use strict';

    angular
        .module('app', ['ngRoute','ui.bootstrap','ngCookies'])
        .config(config)
        .run(run);

    config.$inject = ['$routeProvider', '$locationProvider'];
    function config($routeProvider, $locationProvider) {
        $routeProvider
            .when('/', {
                controller: 'HomeController',
                templateUrl: 'src/home/home.view.html',
                controllerAs: 'vm'
            })

            .when('/movies', {
                controller: 'MovieController',
                templateUrl: 'src/moviesview/movies.view.html',
                controllerAs: 'vm'
            })
            .when('/login', {
                controller: 'LoginController',
                templateUrl: 'src/login/login.view.html',
                controllerAs: 'vm'
            })
          .when('/reviews', {
            controller: 'ReviewsController',
            templateUrl: 'src/reviews/reviews.html',
            controllerAs: 'vm'
          })
          .when('/series', {
            controller: 'SeriesController',
            templateUrl: 'src/series/series.view.html',
            controllerAs: 'vm'
          })
          .when('/comedy', {
            controller: 'ComedyController',
            templateUrl: 'src/comedy/comedy.html',
            controllerAs: 'vm'
          })
            .when('/register', {
                controller: 'RegisterController',
                templateUrl: 'src/register/register.view.html',
                controllerAs: 'vm'
            })
            .when('/admin', {
                controller: 'AdminController',
                templateUrl: 'src/Admin/admin.view.html',
                controllerAs: 'vm'
            })

            .otherwise({ redirectTo: '/login' });
    }

    run.$inject = ['$rootScope', '$location', '$cookies', '$http'];
    function run($rootScope, $location, $cookies, $http) {
        // keep user logged in after page refresh
        $rootScope.globals = $cookies.getObject('globals') || {};
        if ($rootScope.globals.currentUser) {
            $http.defaults.headers.common['Authorization'] = 'Basic ' + $rootScope.globals.currentUser.authdata;
        }

        $rootScope.$on('$locationChangeStart', function (event, next, current) {
            // redirect to login page if not logged in and trying to access a restricted page
            var restrictedPage = $.inArray($location.path(), ['/login', '/register']) === -1;
            var loggedIn = $rootScope.globals.currentUser;
            if (restrictedPage && !loggedIn) {
                $location.path('/login');
            }
        });
    }

})();
