(function() {

    'use strict';
    // file 1
    angular.module('app')
        .controller('MovieController', MovieController);
    MovieController.$inject = ['$scope','MovieService'];
    function MovieController($scope,MovieService) {
        var vm = this;
        $scope.sortType     = 'Title'; // set the default sort type
        $scope.sortReverse  = false;  // set the default sort order
        $scope.searchFish   = 'imdbRating';     // set the default search/filter term


      $scope.currentPage = 1;
      $scope.itemsPerPage = 8;

      $scope.setItemsPerPage = function(num) {
        $scope.itemsPerPage = 8;
        $scope.currentPage = 1; //reset to first paghe
      }


      MovieService.getUsers()
            .then(successFn, errorFn);

        function successFn(resp) {
            vm.users = resp;
        }

        function errorFn(resp) {
            console.log(resp);
        }

    }






})();
