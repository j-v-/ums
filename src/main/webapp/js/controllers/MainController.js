app.controller('MainController', ['$scope', '$http', function($scope, $http) {

    $http.get("/users")
        .success(function(data) {
            $scope.users = data;
        });

    $scope.createUser = function(){
        //$scope.dob = new Date();
        $http({
            method : 'POST',
            url : '/users/create',
            data : {
                title: $scope.title,
                firstname : $scope.firstname,
                lastname : $scope.lastname,
                dob : $scope.dob,
                isactive : $scope.isactive
            }
        }).success(function (data) {
            $scope.newUser = data;
        });
    }

    $scope.getUsersByLastName = function () {
        $http.get("/users/lastname/" + $scope.lastname)
            .success(function(data) {
                $scope.usersByLastName = data;
            });
    }

    $scope.deleteUser = function (id) {
        $http.get("/users/delete/" + id)
            .success(function(data) {
                $scope.deleteUser = data;
            });
    }

    $scope.getActiveUsers = function () {
        $http.get("/users/active/" + $scope.isactive)
            .success(function(data) {
                $scope.activeusers = data;
            });
    }

    $scope.deleteItem = function (user) {
        $scope.usersByLastName.splice($scope.usersByLastName.indexOf(user), 1);
    }

}]);