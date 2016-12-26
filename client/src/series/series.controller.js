(function() {

  'use strict';
  // file 1
  angular.module('app')
    .controller('SeriesController', SeriesController);
  SeriesController.$inject = ['$scope','MovieService'];
  function SeriesController($scope,MovieService) {
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
    /*   angular.module('app')
     .filter('startFrom', function () {
     return function (input, start) {
     if (input) {
     start = +start;
     return input.slice(start);
     }
     return [];
     };
     });

     $scope.currentPage = 1;
     $scope.totalItems = 72;
     $scope.entryLimit = 8; // items per page
     $scope.noOfPages = Math.ceil($scope.totalItems / $scope.entryLimit);

     // $watch search to update pagination
     $scope.$watch('search', function (newVal, oldVal) {

     $scope.totalItems = 72;
     $scope.noOfPages = Math.ceil($scope.totalItems / $scope.entryLimit);
     $scope.currentPage = 1;
     }, true);*/

    MovieService.getUsers()
      .then(successFn, errorFn);

    function successFn(resp) {
      vm.users = resp;
    }

    function errorFn(resp) {
      console.log(resp);
    }

  }


  /*  angular.module('app')
   .filter('newMovieFilter', imdbratings);

   function imdbratings(imdbratings) {

   if(vm.users.imdbRating > 9.0) {
   return true;

   }
   }*/

  // file 2

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
  angular.module('app')
    .factory('PagerService', PagerService);

  function PagerService() {
    // service definition
    var service = {};

    service.GetPager = GetPager;

    return service;

    // service implementation
    function GetPager(totalItems, currentPage, pageSize) {
      // default to first page
      currentPage = currentPage || 1;

      // default page size is 10
      pageSize = pageSize || 10;

      // calculate total pages
      var totalPages = Math.ceil(totalItems / pageSize);

      var startPage, endPage;
      if (totalPages <= 10) {
        // less than 10 total pages so show all
        startPage = 1;
        endPage = totalPages;
      } else {
        // more than 10 total pages so calculate start and end pages
        if (currentPage <= 6) {
          startPage = 1;
          endPage = 10;
        } else if (currentPage + 4 >= totalPages) {
          startPage = totalPages - 9;
          endPage = totalPages;
        } else {
          startPage = currentPage - 5;
          endPage = currentPage + 4;
        }
      }

      // calculate start and end item indexes
      var startIndex = (currentPage - 1) * pageSize;
      var endIndex = Math.min(startIndex + pageSize - 1, totalItems - 1);

      // create an array of pages to ng-repeat in the pager control
      var pages = _.range(startPage, endPage + 1);

      // return object with all pager properties required by the view
      return {
        totalItems: totalItems,
        currentPage: currentPage,
        pageSize: pageSize,
        totalPages: totalPages,
        startPage: startPage,
        endPage: endPage,
        startIndex: startIndex,
        endIndex: endIndex,
        pages: pages
      };
    }
  }

})();
