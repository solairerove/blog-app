/**
 * Created by union on 16.05.16.
 */

(function () {
    'use strict';

    angular
        .module('blog')
        .controller('MainController', MainController);

    function MainController($scope, MainFactory) {
        $scope.posts = MainFactory.query();
    }

})();
