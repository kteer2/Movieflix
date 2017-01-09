(function(){

    describe('movieservice', function(){
        beforeEach(module('app'));

        var movieservice, httpBackend;
        beforeEach(inject(function(_MovieService_,_$httpBackend_){
             restaurantservice = _MovieService_;
            httpBackend = _$httpBackend_;

        }));

        describe('loads service' ,function(){
            it('loads api call',function(){
                httpBackend.when('GET', 'http://localhost:2021/movieflix-0.0.1/api/titles')
                    .respond({ trolled: 'true' });

            });
            $httpBackend.flush();
        });


    })

})();
