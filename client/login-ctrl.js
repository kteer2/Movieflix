(function() {

  angular.module('plunker').controller('LoginCtrl', LoginController);

  function LoginController($location) {
    var lctrl = this;

    lctrl.goToHome = function() {

      $location.path('/viewmovies');
    };
  }
})();