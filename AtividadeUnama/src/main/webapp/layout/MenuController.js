var AtividadeControllers = angular.module('AtividadeApp');

AtividadeControllers.controller('MenuController', ['$scope', '$location',
    function ($scope, $location) {

//        $scope.usuario = {};
//
//        $scope.init = function () {
//            if (sessionStorage.usuario) {
//                $scope.usuario = JSON.parse(sessionStorage.usuario);
//            } else {
//                location.href = "autenticacao.html";
//            }
//        };
//        $scope.init();

        $scope.isActive = function (viewLocation) {
            return viewLocation === $location.path();
        };

//        $scope.logoff = function () {
//            sessionStorage.removeItem("usuario");
//            location.href = "autenticacao.html";
//        };

    }]);

