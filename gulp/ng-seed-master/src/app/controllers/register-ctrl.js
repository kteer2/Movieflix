(function() {


  angular.module('plunker').controller('Registerctrl', Registerctrl);

  function Registerctrl($location) {
    var rgctrl = this;

    rgctrl.goToLogin = function() {

      $location.path('/login');
    };


  }



})();/**
 * Created by Chinmay on 12/12/2016.
 */
