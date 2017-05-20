/**
 * Created by Asus on 20.05.2017.
 */
var app = angular.module("laba3", []);
app.controller("BillController", function ($scope,$http) {
    $scope.bills = [];
    $http.get('http://localhost:8080/api/bill').then(function (response){
        $scope.bills=response.data;
        console.log(response);
    });
});