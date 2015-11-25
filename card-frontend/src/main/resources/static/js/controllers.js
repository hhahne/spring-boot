angular.module('card.controllers', ["ngResource", "spring-data-rest"])
    .controller('home', function($scope, $http, $resource, SpringDataRestAdapter) {
        $http.get('http://localhost:8082/resource').success(function(data) {
            $scope.greeting = data;
        });
        var response = $http.get('http://localhost:8083/decks').success(function(data) {
            $scope.test = angular.toJson(response, true);
        });
        SpringDataRestAdapter.process(response).then(function(data) {
            $scope.cards = data._embeddedItems;
        });
    });