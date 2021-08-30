angular.module('springCloud', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8080/spring_cloud';

    $scope.getProducts = function(){
        $http({
            url: contextPath + '/client/products',
            method: 'GET',
        }).then(
              function successCallback(response) {
                  console.log(response);
                  $scope.products = response.data;
              },
              function errorCallback(response) {
                  alert(response.data.messages);
              }
          );
    };

    $scope.deleteProduct = function(id){
        $http({
            url: contextPath + '/client/products/' + id,
            method: 'DELETE',
        }).then(function(response){
            $scope.getProducts();
        });
    };

    $scope.findById = function(id){
        $http({
            url: contextPath + '/client/products/' + id,
            method: 'GET',
        }).then(function(response){
            console.log(response.data);
            $scope.product = response.data;
        });
    };

    $scope.getProducts();
});