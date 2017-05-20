/**
 * Created by Asus on 20.05.2017.
 */
var app = angular.module("laba3", []);
app.controller("TeacherController", function ($scope,$http) {
    $scope.teachers = [];
    $http.get('http://localhost:8080/api/teacher').then(function (response){
        $scope.teachers=response.data;
        console.log(response);
    });
});