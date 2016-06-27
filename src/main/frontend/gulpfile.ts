/**
 * Created by union on 23.06.16.
 */
const gulp = require("gulp");
const del = require("del");
const tsc = require("gulp-typescript");
const sourcemaps = require('gulp-sourcemaps');
const tsProject = tsc.createProject("tsconfig.json");
const tslint = require('gulp-tslint');

gulp.task('clean', (cb) => {
    return del(["../webapp"], {force: true}, cb);
});

gulp.task("compile", () => {
    var tsResult = gulp.src("src/**/*.ts")
        .pipe(sourcemaps.init())
        .pipe(tsc(tsProject));
    return tsResult.js
        .pipe(gulp.dest("../webapp"));
});

gulp.task("resources", () => {
    return gulp.src(["src/**/*", "!**/*.ts"])
        .pipe(gulp.dest("../webapp"))
});

gulp.task("libs", () => {
    return gulp.src([
        'systemjs/dist/system-polyfills.js',
        'systemjs/dist/system.src.js',

        'jquery/dist/jquery.min.js',
        'bootstrap/dist/css/bootstrap.min.css',
        'bootstrap/dist/js/bootstrap.min.js',

        'angular2/bundles/angular2-polyfills.js',
        'angular2/bundles/angular2.dev.js',
        'angular2/bundles/http.dev.js',
        'angular2/bundles/router.dev.js',

        'angular2/core.js',
        'angular2/http.js',
        'angular2/router.js',
        'angular2/common.js',
        'angular2/compiler.js',

        'angular2/src/platform/**/*.js',
        'angular2/src/compiler/**/*.js',
        'angular2/src/facade/**/*.js',
        'angular2/src/http/**/*.js',
        'angular2/src/core/**/*.js',
        'angular2/src/router/**/*.js',
        'angular2/src/common/**/*.js',
        'angular2/src/animate/**/*.js',

        'angular2/platform/common.js',
        'angular2/platform/common_dom.js',
        'angular2/platform/browser.js',

        'rxjs/**/*.js',
    ], {cwd: "node_modules/**"})
        .pipe(gulp.dest("../webapp/lib"));
});

gulp.task("build", ['compile', 'resources', 'libs'], () => {
    console.log("Building the project ...")
});