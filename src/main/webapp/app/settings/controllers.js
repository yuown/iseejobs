iseejobsApp.controller('SettingsController', [ '$scope', 'AjaxService', '$modal', 'AlertsService', function($scope, AjaxService, $modal, AlertsService) {
    'use strict';

    $scope.settings = {};
    
    $scope.refreshSettings = function() {
        $scope.settings.barcodeDimensions = {};
        
        AjaxService.call("profiles/pageSize", 'GET').success(function(data, status, headers, config) {
        	$scope.settings.pageSize = data;
        });
    };
    
    $scope.popPageSize = function() {
        $scope.pageSizeDialog = $modal.open({
            templateUrl : 'app/settings/pageSize.html',
            scope : $scope
        });
    };
    
    $scope.pageSizeCallback = function() {
        AjaxService.call("profiles/pageSize", 'POST', $scope.settings.pageSize).success(function(data, status, headers, config) {
            $scope.refreshSettings();
        });
    };
    
} ]);

iseejobsApp.controller('PagesizeController', [ '$scope', 'AjaxService', '$modal', 'AlertsService', function($scope, AjaxService, $modal, AlertsService) {
    
    $scope.submitOption = function(option, callback) {
        $scope.pageSizeDialog.dismiss('cancel')
        if(option == 'yes') {
            callback();
        }
    };
    
} ]);
