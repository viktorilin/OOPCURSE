var app = angular.module("Start",[]);

app.controller("FirstController", function ($scope) {
    $scope.lessons = [{
        id: '1',
        timeOfLesson: '7:20',
        numberOfClassRoom: '243',
        nameOfLesson:"Math"
    }];
});