iseejobsApp.controller('ProfilesController', [ '$scope', 'AjaxService', '$modal', 'AlertsService', function($scope, AjaxService, $modal, AlertsService) {
    'use strict';

    $scope.load = function() {
        AjaxService.call('profiles', 'GET').success(function(data, status, headers, config) {
            $scope.profiles = data;
        });
    };
    
    $scope.add = function(request) {
        $scope.request = angular.copy(request) || {
            firstname : "",
            id : null,
        };
        $scope.title = $scope.request.id == null ? "Add Profile" : "Edit Profile";
        $scope.addDialog = $modal.open({
            templateUrl : 'app/profiles/add.html',
            scope : $scope
        });
    };
    
    $scope.deleteRecord = function(request) {
        AlertsService.confirm('Are you sure to delete this?', function() {
            AjaxService.call('profiles/' + request.id, 'DELETE').success(function(data, status, headers, config) {
                $scope.load();
            });
        });
    };
    
} ]);
