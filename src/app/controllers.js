/**
 * Created by union on 8/05/16.
 */

var blog = angular.module('blog', ['ngRoute', 'ngSanitize', 'ngResource']);

/* Factory */
blog.factory('PostList', ['$resource', function ($resource) {
    return $resource('http://localhost:8080/api/post/.', {});
}]);

blog.factory('Post', ['$resource', function ($resource) {
    return $resource('http://localhost:8080/api/post/:id', {id: '@id'});
}]);

/* Controllers */
blog.controller('PostListCtrl', ['$scope', 'PostList',
    function ($scope, PostList) {
        $scope.posts = PostList.query();
    }]);

blog.controller('PostCtrl', ['$scope', '$location', '$routeParams', 'Post',
    function ($scope, $location, $routeParams, Post) {

        Post.get({id: $routeParams.id}, function (data) {
            $scope.post = data;
            $scope.content = $scope.post.content;
        });
    }]);