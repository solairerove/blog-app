/**
 * Created by union on 8/05/16.
 */

var blog = angular.module('blog', ['ngRoute', 'ngSanitize', 'ngResource']);

/* Controllers */
blog.controller('PostListCtrl', ['$scope', 'MainFactory',
    function ($scope, MainFactory) {
        $scope.posts = MainFactory.query();
    }]);

blog.controller('PostCtrl', ['$scope', '$location', '$routeParams', 'PostFactory',
    function ($scope, $location, $routeParams, PostFactory) {

        PostFactory.get({id: $routeParams.id}, function (data) {
            $scope.post = data;
            $scope.content = $scope.post.content;
        });
    }]);
