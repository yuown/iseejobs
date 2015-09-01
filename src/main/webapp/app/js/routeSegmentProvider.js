iseejobsApp.config(function($routeSegmentProvider, $routeProvider) {

    $routeSegmentProvider.options.autoLoadTemplates = true;

    $routeSegmentProvider.
        when('/login', 'login').
        when('/home', 'home').
        segment('login', {
            templateUrl : 'app/templates/login.html',
        }).
        segment('home', {
            templateUrl : 'app/templates/home.html',
        });

    $routeProvider.otherwise({redirectTo: '/login'}); 
});