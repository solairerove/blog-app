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
    return del(["../webapp"], cb);
});

gulp.task("compile", () => {
    var tsResult = gulp.src("src/**/*.ts")
        .pipe(sourcemaps.init())
        .pipe(tsc(tsProject));
    return tsResult.js
        .pipe(sourcemaps.write("."))
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
        'bootstrap/dist/css/bootstrap.min.css',
        'jquery/dist/jquery.min.js',
        'bootstrap/dist/js/bootstrap.min.js',
        'angular2/**',
        'rxjs/**'
    ], {cwd: "node_modules/**"})
        .pipe(gulp.dest("../webapp/lib"));
});

gulp.task("build", ['compile', 'resources', 'libs'], () => {
    console.log("Building the project ...")
});