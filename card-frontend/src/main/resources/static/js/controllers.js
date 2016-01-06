angular.module('card.controllers', ["ngResource", "spring-data-rest"])
    .controller('home', function($scope, $http, $resource, SpringDataRestAdapter) {
        $http.get('/resource').success(function(data) {
            $scope.greeting = data;
        });
        var response = $http.get('/decks').success(function(data) {
            $scope.test = angular.toJson(response, true);
        });
        SpringDataRestAdapter.process(response).then(function(data) {
            $scope.cards = data._embeddedItems;
        });
    });