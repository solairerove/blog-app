/**
 * Created by union on 23.06.16.
 */
(function (global) {

    var map = {
        'app': 'app',
        'rxjs': 'lib/rxjs',
        'angular2': 'lib/angular2'
    };

    var packages = {
        'app': {main: 'main.js', defaultExtension: 'js'},
        'rxjs': {defaultExtension: 'js'}
    };

    var packageNames = [
        'angular2/'
    ];

    packageNames.forEach(function (pkgName) {
        packages[pkgName] = {defaultExtension: 'js'};
    });

    var config = {
        map: map,
        packages: packages
    };

    if (global.filterSystemConfig) {
        global.filterSystemConfig(config);
    }

    System.config(config);

})(this);