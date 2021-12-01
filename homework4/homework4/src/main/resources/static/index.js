angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/app';

    $scope.showProduct = function () {  // scope - хранит данные
        $http.get(contextPath + '/products')  //формирование запроса
            .then(function (response) {   //когда получен ответ
                $scope.ProductList = response.data;   // получение данных из тела ответа
            });
    };

    $scope.deleteProduct = function (productId) {
        $http.get(contextPath + '/product/delete/' + productId)
            .then(function (response) {
                $scope.showProduct();
            });
    }



    $scope.showProduct();
});