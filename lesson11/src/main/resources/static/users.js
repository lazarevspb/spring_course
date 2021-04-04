angular.module('app', []).controller('usersController', function ($scope, $http) {
    const contextPath = 'http://localhost:8190/market';

    // http://localhost:8190/market/api/v2/users

    $scope.fillTableUsers = function () {
        $http.get(contextPath + '/api/v2/users')
            .then(function (response) {
                console.log(response);
            $scope.UsersList = response.data;
        });
    };

    $scope.fillTableUsers();
});
