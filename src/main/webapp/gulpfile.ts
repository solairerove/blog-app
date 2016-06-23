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
    return del(["build"], cb);
});

gulp.task("compile", () => {
    var tsResult = gulp.src("src/**/*.ts")
        .pipe(sourcemaps.init())
        .pipe(tsc(tsProject));
    return tsResult.js
        .pipe(sourcemaps.write("."))
        .pipe(gulp.dest("build"));
});

gulp.task("resources", () => {
    return gulp.src(["src/**/*", "!**/*.ts"])
        .pipe(gulp.dest("build"))
});

gulp.task("libs", () => {
    return gulp.src([
        'systemjs/dist/system-polyfills.js',
        'angular2/bundles/angular2-polyfills.js',
        'systemjs/dist/system.src.js',
        'rxjs/bundles/Rx.js',
        'angular2/bundles/angular2.dev.js',
        'angular2/bundles/http.dev.js',
        'angular2/bundles/router.dev.js',
        'bootstrap/dist/css/bootstrap.min.css',
        'jquery/dist/jquery.min.js',
        'bootstrap/dist/js/bootstrap.min.js',
        'angular2/core.js',
        'angular2/http.js',
        'angular2/router.js',
        'angular2/**',
        'rxjs/**'
    ], {cwd: "node_modules/**"})
        .pipe(gulp.dest("build/lib"));
});

gulp.task("build", ['compile', 'resources', 'libs'], () => {
    console.log("Building the project ...")
});