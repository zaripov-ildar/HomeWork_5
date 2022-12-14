angular.module('store', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8081/store';
    $scope.loadProducts = function () {
        $http.get(contextPath + "/products")
            .then(function (response) {
                $scope.productList = response.data;
            })
    };
    $scope.deleteProduct = function (productId) {
        $http.get(contextPath + "/products/delete/" + productId)
            .then(function () {
                $scope.loadProducts();
            })

    };
    $scope.product = {
        id: null,
        name: null,
        price: null
    };
    $scope.addProduct = function (product) {
        $http.post(contextPath + "/products/saveOrUpdate", JSON.stringify(product))
            .then(function () {
                $scope.loadProducts();
            });
    };
    $scope.findById = function (id){
        $http.get(contextPath + "/products/find/" + id)
            .then(function (response){
            $scope.found_prod = response.data;
        })


    };

    $scope.loadProducts();
})
;