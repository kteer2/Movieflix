(function() {

        // file 1
    angular.module('app')
        .controller('AdminController', AdminController);


    AdminController.$inject = ['$scope','AdminService'];

    function AdminController($scope,AdminService) {
        var vm = this;

        AdminService.getUsers()
            .then(successFn, errorFn);

        function successFn(resp) {
            vm.users = resp;
        }

        function errorFn(resp) {
            console.log(resp);
        }
        $scope.sortType     = 'Title'; // set the default sort type
        $scope.sortReverse  = false;  // set the default sort order
        $scope.searchFish   = '';     // set the default search/filter term

        $scope.addNew = function(personalDetail){

            $scope.vm.users.push({
                'Title': "",
                'Year': "",
                'Type': "",
            });

        };

        $scope.remove = function(){
            var newDataList=[];
            $scope.selectedAll = false;
            angular.forEach($scope.vm.users, function(selected){
                if(!selected.selected){
                    newDataList.push(selected);
                }
            });
            $scope.vm.users = newDataList;
        };

        $scope.checkAll = function () {
            if (!$scope.selectedAll) {
                $scope.selectedAll = true;
            } else {
                $scope.selectedAll = false;
            }
            angular.forEach($scope.vm.users, function(personalDetail) {
                personalDetail.selected = $scope.selectedAll;
            });
        };


    }


    // file 2

    angular.module('app')
        .service('AdminService', AdminService);
    AdminService.$inject = ['$http'];
    function AdminService($http) {
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
})();
