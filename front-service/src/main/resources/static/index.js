angular.module('springCloud', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:5555/product-service/api/v1/products';

    $scope.getProducts = function(){
        $http({
            url: contextPath,
            method: 'GET'

        }).then(function (response) {
              console.log(response);
              $scope.products = response.data;
        });
    };

//    $scope.deleteProduct = function(id){
//        $http({
//            url: contextPath + '/' + id,
//            method: 'DELETE',
//        }).then(function(response){
//            $scope.getProducts();
//        });
//    };
//
//    $scope.findById = function(id){
//        $http({
//            url: contextPath + '/' + id,
//            method: 'GET',
//        }).then(function(response){
//            console.log(response.data);
//            $scope.product = response.data;
//        });
//    };

    $scope.getProducts();
});