// var app = angular.module("Course",[]);
//
// app.controller("AppCtrl", function ($scope) {
//     $scope.lessons = [{
//         id: 1,
//         timeOfLesson: "7:20",
//         numberOfClassRoom: 243,
//         nameOfLesson:"Math"
//     }];
// });
//
var app = angular.module("laba3", []);

app.controller("AppCtrl", function($scope, $http) {
    $scope.lessons = [];

    $http.get('/api/lesson').then (function (data) {
        $scope.lessons=response.data;
        console.log(response);
    });
});