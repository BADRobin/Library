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
    $scope.addToCart = function (product_id) {
        $http.put("/rest/cart/add/" + product_id).success(function () {
            $scope.refreshCart();
        });
    };
    $scope.removeFromCart = function (product_id) {
        $http.put("/rest/cart/remove/" + product_id).success(function (data) {
            $scope.refreshCart();
        });
    };
    $scope.calGrandTotal = function () {
        var grandTotal = 0;
        if (typeof($scope.cart) !== 'undefined') {
            for (var i = 0; i < $scope.cart.cart_items.length; i++) {
                grandTotal += $scope.cart.cart_items[i].total_price;
            }
            return grandTotal;
        }else {
            return 0;
        }

    }

});

