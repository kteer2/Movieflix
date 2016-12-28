(function() {

  angular.module('plunker').controller('LoginCtrl', LoginController);

  function LoginController($location) {
    var lctrl = this;

    lctrl.goToHome = function() {

      $location.path('/viewmovies');
    };

    lctrl.goToLogin = function() {

      $location.path('/login');
    };
    lctrl.goToAdmin = function() {

      $location.path('/adminlogin');
    };
    lctrl.goToRegister = function() {

      $location.path('/register');
    };
  }
})();
