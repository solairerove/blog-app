/**
 * Created by union on 8/05/16.
 */

var blog = angular.module('blog', ['ngRoute', 'ngSanitize', 'ngResource']);

blog.factory('Post', ['$resource', function ($resource) {
    return $resource('http://localhost:8080/api/post/:id', {id: '@id'});
}]);

/* Controllers */
blog.controller('PostListCtrl', ['$scope', 'MainFactory',
    function ($scope, MainFactory) {
        $scope.posts = MainFactory.query();
    }]);

blog.controller('PostCtrl', ['$scope', '$location', '$routeParams', 'Post',
    function ($scope, $location, $routeParams, Post) {

        Post.get({id: $routeParams.id}, function (data) {
            $scope.post = data;
            $scope.content = $scope.post.content;
        });
    }]);