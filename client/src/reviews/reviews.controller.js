

(function() {

  'use strict';
  // file 1
  angular.module('app')
    .controller('ReviewsController', ReviewsController);
  ReviewsController.$inject = ['$scope','MovieService'];

  function ReviewsController($scope,MovieService) {

    this.rating1 = 5;
    this.rating2 = 2;
    this.isReadonly = true;
    this.rateFunction = function(rating) {
      console.log('Rating selected: ' + rating);
    };
  }

  function starRating() {
    return {
      restrict: 'EA',
      template:
      '<ul class="star-rating" ng-class="{readonly: readonly}">' +
      '  <li ng-repeat="star in stars" class="star" ng-class="{filled: star.filled}" ng-click="toggle($index)">' +
      '    <i class="fa fa-star"></i>' + // or &#9733
      '  </li>' +
      '</ul>',
      scope: {
        ratingValue: '=ngModel',
        max: '=?', // optional (default is 5)
        onRatingSelect: '&?',
        readonly: '=?'
      },
      link: function(scope, element, attributes) {
        if (scope.max == undefined) {
          scope.max = 5;
        }
        function updateStars() {
          scope.stars = [];
          for (var i = 0; i < scope.max; i++) {
            scope.stars.push({
              filled: i < scope.ratingValue
            });
          }
        };
        scope.toggle = function(index) {
          if (scope.readonly == undefined || scope.readonly === false){
            scope.ratingValue = index + 1;
            scope.onRatingSelect({
              rating: index + 1
            });
          }
        };
        scope.$watch('ratingValue', function(oldValue, newValue) {
          if (newValue) {
            updateStars();
          }
        });
      }
    };
  MovieService.getUsers()
    .then(successFn, errorFn);

  function successFn(resp) {
    vm.users = resp;
  }

  function errorFn(resp) {
    console.log(resp);
  }

}
  angular.module('app')
  .directive('starRating', starRating);

// file 2

angular.module('app')
  .service('MovieService', MovieService);
MovieService.$inject = ['$http'];
function MovieService($http) {
  this.getUsers = function () {
    var config = {
      method: 'GET',
      url: 'src/moviesview/jsonfiles.html'
    }
    return $http(config)
      .then(function (resp) {
        return resp.data;
      }, function (err) {
        console.log(err)
        return err;
      });
  }
}
})();
