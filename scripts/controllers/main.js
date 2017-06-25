'use strict';

/**
 * @ngdoc function
 * @name golestanApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the golestanApp
 */
angular.module('golestanApp')
  .controller('MainCtrl', function ($scope,$location,Auth) {
    var user = Auth.getUser();
    if(user == null)
    {
    	$location.url("/login");
    }
    else{
    	if(user.role == "STUDENT")
    		$location.url("/student");
    	else if(user.role == "PROFESSOR")
    		$location.url("/professor");
    	else if(user.role == "HEADPROFESSOR"){
    		$location.url("/headprofessor");
    	}else{
    		window.alert("نوع کاربر نامعلوم است");
    		$location.url("/login");
    	}
    }
  });
