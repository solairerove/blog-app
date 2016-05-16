/**
 * Created by union on 16.05.16.
 */

(function () {
    'use strict';

    angular
        .module('blog')
        .factory('MainFactory', MainFactory);

    function MainFactory($resource) {
        return $resource('http://localhost:8080/api/post/.', {});
    }

})();
