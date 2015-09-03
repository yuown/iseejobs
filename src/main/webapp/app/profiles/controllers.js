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
            scope : $scope,
            size: 'lg'
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

iseejobsApp.controller('AddProfileController', [ '$scope', 'AjaxService', 'AlertsService', function($scope, AjaxService, AlertsService) {
    'use strict';
    
    $scope.init = function(request) {
    	$scope.months = ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'];
    	if(request && request.id != null) {
    		AjaxService.call('skills/profile/' + request.id, 'GET').success(function(data, status, headers, config) {
                $scope.skills = data;
            });
    		AjaxService.call('educations/profile/' + request.id, 'GET').success(function(data, status, headers, config) {
                $scope.educations = data;
            });
    	}
    };
    
    $scope.addSkill = function(skills) {
    	skills.push({'title': '', 'comments': ''});
    };
    
    $scope.addEducation = function(educations) {
    	educations.push({'title': '', 'comments': ''});
    };
    
    $scope.save = function(profile, skills, educations) {
        AjaxService.call('profiles', 'POST', profile).success(function(data, status, headers, config) {
            $scope.request = data;
            AjaxService.call('skills/profile/' + profile.id, 'POST', skills);
            AjaxService.call('educations/profile/' + profile.id, 'POST', educations);
            $scope.addDialog.dismiss('cancel');
            $scope.load($scope.currentPage);
        });
    };
    
    $scope.confirmRemoveEducation = function(profile, education) {
    	if(education.id != null) {
    		AlertsService.confirm('Are you sure to delete this group ?', function() {
                AjaxService.call('educations/' + education.id + '/' + profile.id, 'DELETE').success(function(data, status, headers, config) {
                	$scope.educations.splice($scope.educations.indexOf(education), 1);
                });
            });
    	} else {
    		$scope.educations.splice($scope.educations.indexOf(education), 1);
    	}
    }
    
    $scope.confirmRemoveSkill = function(profile, skill) {
    	if(skill.id != null) {
    		AlertsService.confirm('Are you sure to delete this group ?', function() {
                AjaxService.call('skills/' + skill.id + '/' + profile.id, 'DELETE').success(function(data, status, headers, config) {
                	$scope.skills.splice($scope.skills.indexOf(skill), 1);
                });
            });
    	} else {
    		$scope.skills.splice($scope.skills.indexOf(skill), 1);
    	}
    }
    
} ]);