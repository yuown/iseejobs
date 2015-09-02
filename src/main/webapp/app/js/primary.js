iseejobsApp.controller('YuownLoginController', [ '$scope', '$location', 'AuthenticationService', function($scope, $location, AuthenticationService) {
	'use strict';

	AuthenticationService.ClearCredentials();

	$scope.login = function() {
		$scope.errorMessage = '';
		AuthenticationService.Login($scope.user, function(response, headers) {
			if (response == 200) {
				AuthenticationService.SetCredentials($scope.user.username, headers("YUOWN-KEY"), headers("USER_ROLES"));
				$location.path('/home');
			} else {
				var err = '';
				try {
					err = $($(response).get(3)).html();
					err = err.split('-')[1].trim();
				} catch (e) {
					err = 'Failed to Login, please contact administrator!';
				}
				$scope.errorMessage = err;
			}
		});
	};
	
	$scope.showLogin = function() {
	    $("#login-form").delay(100).fadeIn(100);
        $("#register-form").fadeOut(100);
        $('#register-form-link').removeClass('active');
        $("#login-form-link").addClass('active');
	};
	
	$scope.showRegister = function() {
	    $("#register-form").delay(100).fadeIn(100);
        $("#login-form").fadeOut(100);
        $('#login-form-link').removeClass('active');
        $("#register-form-link").addClass('active');
    };

} ]);

iseejobsApp.controller('HomeController', [ '$scope', '$routeSegment', '$location', 'AuthenticationService', function($scope, $routeSegment, $location, AuthenticationService) {
    'use strict';
    
    $scope.isSegment = function(segment) {
        return $routeSegment.name.endsWith(segment);
    };
    
    $scope.logout = function() {
    	AuthenticationService.ClearCredentials();
    	$location.path('/login');
    };
    
} ]);
