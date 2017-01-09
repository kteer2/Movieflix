(function() {
// file 2

  angular.module('app')
    .service('MovieService', MovieService);


  MovieService.$inject = ['$http'];

  function MovieService($http) {

    this.getUsers = function() {

      var config = {
        method: 'GET',
        // uncomment this url if using backend services
        
        // url: 'http://localhost:2021/movieflix-0.0.1/api/titles'
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
