iseejobsApp.controller('ProfilesController', [ '$scope', 'AjaxService', '$modal', 'AlertsService', function($scope, AjaxService, $modal, AlertsService) {
    'use strict';

    $scope.currentPage = 1;

    $scope.load = function(pageNumber) {
        AjaxService.call('profiles?page=' + (pageNumber - 1), 'GET').success(function(data, status, headers, config) {
        	$scope.totalItems = headers("totalItems");
        	$scope.pages = headers("pages");
        	$scope.currentPage = pageNumber;
            $scope.profiles = data;
        });
    };
    
    $scope.getNumber = function(num) {
    	var array = [];
    	for (var int = 0; int < num;) {
			array[int] = ++int;
		}
    	return array;
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
            	$scope.load($scope.currentPage);
            });
        });
    };
    
} ]);

iseejobsApp.controller('AddProfileController', [ '$scope', 'AjaxService', function($scope, AjaxService) {
    'use strict';
    
    $scope.save = function(request) {
        AjaxService.call('profiles', 'POST', request).success(function(data, status, headers, config) {
            $scope.request = data;
            $scope.addDialog.dismiss('cancel');
            $scope.load($scope.currentPage);
        });
    };
    
} ]);