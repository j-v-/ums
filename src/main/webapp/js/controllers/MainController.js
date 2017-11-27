app.controller('MainController', ['$scope', '$http', function($scope, $http) {

    $http.get("/users")
        .success(function(data) {
            $scope.users = data;
        });

    $scope.createUser = function(){
        console.log($scope.title);
        console.log($scope.firstname);
        console.log($scope.lastname);
        console.log($scope.dob);
        console.log($scope.isactive);
        $scope.dob = new Date();
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

    $scope.deleteUser = function () {
        $http.get("/users/delete/" + $scope.id)
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

}]);