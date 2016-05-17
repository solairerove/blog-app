/**
 * Created by union on 16.05.16.
 */

(function () {
    'use strict';

    angular
        .module('blog')
        .controller('PostController', PostController);

    function PostController($scope, $location, $routeParams, PostFactory) {
        PostFactory.get({id: $routeParams.id}, function (data) {
            $scope.post = data;
            $scope.content = $scope.post.content;
        });
    }

})();
