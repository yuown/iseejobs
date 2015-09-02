iseejobsApp.factory('AlertsService', [ '$rootScope', '$modal', function($rootScope, $modal) {
    'use strict';

    return {
        confirm : function(message, callback) {
            $rootScope.title = "ISEE Jobs";
            $rootScope.confirmMessage = message;
            $rootScope.confirmCallback = callback;
            $rootScope.confirmDialog = $modal.open({
                templateUrl : 'app/alerts/confirm.html',
                scope : $rootScope
            });
        }
    };

} ]);

iseejobsApp.controller('AlertsController', [ '$scope', '$modal', function($scope, $modal) {
    'use strict';
    
    $scope.submitOption = function(option, confirmCallback) {
        $scope.confirmDialog.dismiss('cancel')
        if(option == 'yes') {
            confirmCallback();
        }
    };
    
} ]);
