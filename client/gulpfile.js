
var gulp = require('gulp'),
  //clean = require('gulp-clean'),
  inject = require('gulp-inject')
  bowerfiles = require('main-bower-files'),
  browsersync = require('browser-sync').create();
var config = {
  paths: {
    src: './src',
    build: './build',
    bower: './bower_components'
  }
};




gulp.task('inject', function(){
  var cssfiles = gulp.src([
    config.paths.src + '/**/*.css'
  ], {read:false});

  var jsfiles = gulp.src([
    config.paths.src + '/**/*.js'
  ], {read:false});

  return gulp.src(config.paths.src + '/index.html')
    .pipe(inject(gulp.src(bowerfiles(),{read:false }),{name:'bower'}))
    .pipe(inject(cssfiles, {ignorePath: 'src', addRootSlash: false}))
    .pipe(inject(jsfiles, {ignorePath: 'src', addRootSlash: false}))
    .pipe(gulp.dest(config.paths.build));

  });

gulp.task('serve',[inject], function(){
  browsersync.init({
    server: {
      baseDir: [config.paths.build,config.paths.bower,config.paths.src],
      routes: {
        '/bower_components' : 'bower_components'
      }
    },
    files: [
      config.paths.src + '/**'
    ]

  })
});
