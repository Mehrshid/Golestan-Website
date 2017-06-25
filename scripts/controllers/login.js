'use strict';

/**
 * @ngdoc function
 * @name golestanApp.controller:LoginCtrl
 * @description
 * # LoginCtrl
 * Controller of the golestanApp
 */
angular.module('golestanApp')
  .controller('LoginCtrl', function ($scope,$location,Auth) {
    $scope.result = "not done";
    console.debug("hi");
    $scope.doLogin = function(){
    	Auth.authenticate($scope.username,$scope.password);
    };
    var el =angular.element('#css');
 	el.attr('href', '../css/main.css');
  });
