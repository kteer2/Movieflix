(function(){
  
  angular.module('plunker').controller('HomeCtrl', HomeController);
  
  function HomeController ($routeParams) {
    var hctrl = this;
    
    hctrl.params = $routeParams;
    console.log('home controller');
  }
})();