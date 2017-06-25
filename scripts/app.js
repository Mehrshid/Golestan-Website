'use strict';

/**
 * @ngdoc overview
 * @name golestanApp
 * @description
 * # golestanApp
 *
 * Main module of the application.
 */
angular
  .module('golestanApp', [
    'ngAnimate',
    'ngAria',
    'ngCookies',
    'ngMessages',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch'
  ])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/main.html',
        controller: 'MainCtrl',
        controllerAs: 'main'
      })
      .when('/about', {
        templateUrl: 'views/about.html',
        controller: 'AboutCtrl',
        controllerAs: 'about'
      })
      .when('/login', {
        templateUrl: 'views/login.html',
        controller: 'LoginCtrl',
        controllerAs: 'login'
      })
      .when('/student', {
        templateUrl: 'views/student.html',
        controller: 'StudentCtrl',
        controllerAs: 'student'
      })
      .when('/professor', {
        templateUrl: 'views/professor.html',
        controller: 'ProfessorCtrl',
        controllerAs: 'professor'
      })
      .when('/managecourses', {
        templateUrl: 'views/managecourses.html',
        controller: 'ManagecoursesCtrl',
        controllerAs: 'managecourses'
      })
      .when('/editinfo', {
        templateUrl: 'views/editinfo.html',
        controller: 'EditinfoCtrl',
        controllerAs: 'editinfo'
      })
      .when('/enroll', {
        templateUrl: 'views/enroll.html',
        controller: 'EnrollCtrl',
        controllerAs: 'enroll'
      })
      .when('/headprofessor', {
        templateUrl: 'views/headprofessor.html',
        controller: 'HeadprofessorCtrl',
        controllerAs: 'headprofessor'
      })
      .when('/newterm', {
        templateUrl: 'views/newterm.html',
        controller: 'NewtermCtrl',
        controllerAs: 'newterm'
      })
      .when('/report', {
        templateUrl: 'views/report.html',
        controller: 'ReportCtrl',
        controllerAs: 'report'
      })
      .when('/submitgrade', {
        templateUrl: 'views/submitgrade.html',
        controller: 'SubmitgradeCtrl',
        controllerAs: 'submitgrade'
      })
      .when('/viewstudentlist', {
        templateUrl: 'views/viewstudentlist.html',
        controller: 'ViewstudentlistCtrl',
        controllerAs: 'viewstudentlist'
      })
      .otherwise({
        redirectTo: '/err'
      });
  });
