(function() {

  angular.module('plunker', ['ngRoute']).config(moduleConfig);

  function moduleConfig($routeProvider) {
    $routeProvider
      .when('/login', {
        templateUrl: 'login.html',
        controller: 'LoginCtrl',
        controllerAs: 'lctrl'
      })
      .when('/home/:name/:city', {
        templateUrl: 'home.html',
        controller: 'HomeCtrl',
        controllerAs: 'hctrl'
      })
      .when('/viewmovies', {
        templateUrl: 'viewmovies.html',
        controller: 'Moviectrl',
        controllerAs: 'mVm',
      })
      .otherwise({
        redirectTo: '/login'
      })
      
      .when('/register', {
        templateUrl: 'register.html',
        controller: 'Registerctrl',
        controllerAs: 'rgctrl',
      })
      .otherwise({
        redirectTo: '/login'
      });


    function loadUser($http) {
      return $http({
        method: 'GET',
        url: 'http://jsonplaceholder.typicode.com/users/1'
      });
    }
    
    function loadUserPic($http) {
      return $http({
        method: 'GET',
        url: 'http://jsonplaceholder.typicode.com/photos/1'
      });
    }
  }

})();