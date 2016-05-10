/**
 * Created by union on 8/05/16.
 */

var blog = angular.module('blog', ['ngRoute', 'ngSanitize']);

blog.config(['$routeProvider', function ($routeProvide) {

    $routeProvide
        .when('/', {
            templateUrl: 'template/home.html',
            controller: 'PostListCtrl'
        })
        .when('/about', {
            templateUrl: 'template/about.html',
            controller: 'AboutCtrl'
        })
        .when('/posts/:id', {
            templateUrl: 'template/post.html',
            controller: 'PostCtrl'
        })
        .otherwise({
            redirectTo: '/'
        });
}]);

blog.controller('PostListCtrl', ['$scope', '$http', '$location', function ($scope, $http, $location) {

    $http.get('http://localhost:8080/api/post/').success(function (data) {
        $scope.posts = data;
    });
}]);

blog.controller('AboutCtrl', ['$scope', '$http', '$location', function ($scope, $http, $location) {

}]);

blog.controller('PostCtrl', ['$scope', '$http', '$location', '$routeParams', function ($scope, $http, $location, $routeParams) {
    $scope.id = $routeParams.id;
    
    var url = 'http://localhost:8080/api/post/' + $routeParams.id;
    
    $http.get(url).success(function (data) {
        $scope.post = data;
        $scope.content = $scope.post.content;
    });
}]);