'use strict';

/**
 * @ngdoc function
 * @name golestanApp.controller:ManagecoursesCtrl
 * @description
 * # ManagecoursesCtrl
 * Controller of the golestanApp
 */
angular.module('golestanApp')
  .controller('ManagecoursesCtrl', function (Auth,$location) {
    var user = Auth.getUser();
    if(!Auth.authorize("PROFESSOR")){
    	window.alert("شما اجازه دسترسی به این صفحه را ندارید");
    	$location.url("/");
    }
    var el =angular.element('#css');
 	el.attr('href', '../css/managecourses.css');
  });
