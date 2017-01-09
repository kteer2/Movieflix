(function(){

    describe('MovieController', function() {
        var moviectrl;
        beforeEach(module('app'));
        beforeEach(inject(function(_$controller_){
          moviectrl = _$controller_('MovieController');
        }));

        describe('controller initiation', function(){

            it('loads controller', function() {
                console.log(moviectrl);
            });

           
        });


    });


})();
