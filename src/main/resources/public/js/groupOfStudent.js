/**
 * Created by Asus on 20.05.2017.
 */
var app = angular.module("laba3", []);
app.controller("GroupOfStudentController", function ($scope,$http) {
    $scope.groupOfStudents = [];
    $http.get('http://localhost:8080/api/groupOfStudent').then(function (response){
        $scope.groupOfStudents=response.data;
        console.log(response);
    });
});