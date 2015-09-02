iseejobsApp.config(function($routeSegmentProvider, $routeProvider) {

    $routeSegmentProvider.options.autoLoadTemplates = true;

    $routeSegmentProvider.
        when('/login', 'login').
        when('/home', 'home').
        when('/home/profiles', 'home.profiles').
        when('/home/upload', 'home.upload').
        when('/home/download', 'home.download').
        when('/home/search', 'home.search').
        when('/home/settings', 'home.settings').
        when('/home/users', 'home.users').
        when('/home/groups', 'home.groups').
        segment('login', {
            templateUrl : 'app/templates/login.html',
        }).
        segment('home', {
            templateUrl : 'app/templates/home.html',
        }).
        within().
            segment('profiles', {
                templateUrl : 'app/profiles/list.html',
            }).
            segment('upload', {
                templateUrl : 'app/templates/upload.html',
            }).
            segment('download', {
                templateUrl : 'app/templates/download.html',
            }).
            segment('search', {
                templateUrl : 'app/templates/search.html',
            }).
            segment('settings', {
                templateUrl : 'app/settings/list.html',
            }).
            segment('users', {
                templateUrl : 'app/users/list.html',
            }).
            segment('groups', {
                templateUrl : 'app/users/groupsList.html',
            });

    $routeProvider.otherwise({redirectTo: '/login'}); 
});