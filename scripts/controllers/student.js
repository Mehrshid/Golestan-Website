'use strict';

/**
 * @ngdoc function
 * @name golestanApp.controller:StudentCtrl
 * @description
 * # StudentCtrl
 * Controller of the golestanApp
 */
angular.module('golestanApp')
  .controller('StudentCtrl', function (Auth,$location) {
    var user = Auth.getUser();
    if(!Auth.authorize("STUDENT")){
    	window.alert("شما اجازه دسترسی به این صفحه را ندارید");
    	$location.url("/");
    }
    var el =angular.element('#css');
 	el.attr('href', '../css/student.css');
  });
