angular.module('card.controllers', [])
    .controller('home', function($scope, $http) {
        $http.get('http://localhost:8082/resource').success(function(data) {
            $scope.greeting = data;
        })
    });