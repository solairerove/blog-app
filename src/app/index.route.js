/**
 * Created by union on 16.05.16.
 */

(function () {
    'use strict';

    angular
        .module('blog')
        .config(routeConfig);

    function routeConfig($routeProvider) {
        $routeProvider
            .when('/', {
                templateUrl: 'app/components/main/main.html',
                controller: 'MainController'
            })
            .when('/about', {
                templateUrl: 'app/components/about/about.html',
                controller: 'AboutController'
            })
            .when('/posts/:id', {
                templateUrl: 'app/components/post/post.html',
                controller: 'PostController'
            })
            .otherwise({
                redirectTo: '/'
            });

    }

})();
