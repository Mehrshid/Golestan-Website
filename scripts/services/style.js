'use strict';

/**
 * @ngdoc service
 * @name golestanApp.style
 * @description
 * # style
 * Factory in the golestanApp.
 */
angular.module('golestanApp')
  .factory('style', function () {
    // Service logic
    // ...

    var meaningOfLife = 42;

    // Public API here
    return {
      setStyle: function () {
        return meaningOfLife;
      }
    };
  });
