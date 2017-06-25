'use strict';

/**
 * @ngdoc function
 * @name golestanApp.controller:ProfessorCtrl
 * @description
 * # ProfessorCtrl
 * Controller of the golestanApp
 */
angular.module('golestanApp')
  .controller('ProfessorCtrl', function ($scope,$location,Auth) {
    var user = Auth.getUser();
    if(!Auth.authorize("PROFESSOR")){
    	window.alert("شما اجازه دسترسی به این صفحه را ندارید");
    	$location.url("/");
    }
    var el =angular.element('#css');
 	el.attr('href', '../css/role.css');
  });
