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
app.controller("LessonController", function ($scope,$http) {
    $scope.lessons = [];
    $http.get('http://localhost:8080/api/lesson').then(function (response){
        $scope.lessons=response.data;
        console.log(response);
    });
});