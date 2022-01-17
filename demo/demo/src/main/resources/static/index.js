angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/app';

    $scope.loadProducts = function () {
        $http({
                    url: contextPath + '/products',
                    method: 'GET',
                    params: {
                        minFilter: $scope.filter ? $scope.filter.min : null,
                        maxFilter: $scope.filter ? $scope.filter.max : null
                    }
                }).then(function (response) {
                    $scope.ProductsList = response.data;
                });
                }

    $scope.deleteProduct = function (productId) {
        $http.get(contextPath + '/product/delete/' + productId)
            .then(function (response) {
                $scope.loadProducts();
            });
    }


    $scope.loadProducts();
});