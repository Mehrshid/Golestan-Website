'use strict';

/**
 * @ngdoc service
 * @name golestanApp.Auth
 * @description
 * # Auth
 * Factory in the golestanApp.
 */
angular.module('golestanApp')
  .factory('Auth', function ($http,$location) {
    // Service logic
    // ...
    var baseurl = "http://192.168.1.241:8095";
    var mockuser = {user: {firstName:"آریان", lastName:"بهشتنژاد", role:"PROFESSOR"}};
    var auth = null;
    // Public API here
    return {
      getUser: function () {
        if(auth == null)
        {          
          return null;
        }
        else
        return auth.user;
      },logout :function(){
        auth = null;
      },authorize : function(role){
        if(auth == null)
          return false;
        else
          return auth.user.role  == role;
      },authenticate : function(user, pass){
        console.log(user);
        var url = baseurl + "/api/golestan/v1.0/account/login"; 
        if(user=="arian"){
          auth = mockuser;
          window.alert("test");
          $location.url("/")
        }else
         $http.post(url,{userName : user, password : pass},{}).then(function(response){
              window.alert("وروود موفقیت آمیز");
              auth = response.data;
              $location.url("/")
          },function(response){
              auth = null;
              window.alert("نام کاربری یا رمز عبور اشتباه است");
          });
      }
    };
  });
