/**
 * Created by olegbryl on 18/10/2018.
 */

var cartApp = angular.module("cartApp", []);

cartApp.controller("cartCtrl", function ($scope, $http) {

    $scope.refreshCart = function () {
        $http.get("/rest/cart/" + $scope.cart_id).success(function (data) {
            $scope.cart = data;
            $scope.calGrandTotal();
        });
    };
    $scope.clearCart = function () {
        $http.delete('/rest/cart/' + $scope.cart_id).success($scope.refreshCart());
    };
    $scope.initCartId = function (cart_id) {
        $scope.cart_id = cart_id;
        $scope.refreshCart(cart_id);
    };
    $scope.addToCart = function (Book_id) {
        $http.put("/rest/cart/add/" + Book_id).success(function () {
            $scope.refreshCart();
        });
    };
    $scope.removeFromCart = function (Book_id) {
        $http.put("/rest/cart/remove/" + Book_id).success(function (data) {
            $scope.refreshCart();
        });
    };


});

