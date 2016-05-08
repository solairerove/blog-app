/**
 * Created by union on 8/05/16.
 */

var blog = angular.module('blog', []);

blog.controller("PostCtrl", function ($scope, $http) {

    $http.get('http://localhost:8080/api/post/').success(function (data) {
        $scope.posts = data;
    });
});