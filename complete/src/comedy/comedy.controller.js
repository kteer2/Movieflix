(function() {

  'use strict';
  angular.module('app')
    .controller('ComedyController', ComedyController);
  ComedyController.$inject = ['MovieService'];
  function ComedyController(MovieService) {

      MovieService.getUsers()
      .then(successFn, errorFn);

    function successFn(resp) {
      vm.users = resp;
      console.log("success");
          }

    function errorFn(resp) {
      console.log(resp);

    }

  }

  angular.module('app')
    .service('MovieService', MovieService);
  MovieService.$inject = ['$http'];

  function MovieService($http) {

    this.getUsers = function() {

      var config = {
        method: 'GET',
        url: 'src/moviesview/jsonfiles.html'
      }

      return $http(config)
        .then(function(resp) {
          return resp.data;
        }, function(err) {
          console.log(err)
          return err;
        });
    }

  }


})();
