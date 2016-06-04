var AtividadeControllers = angular.module('AtividadeApp');
AtividadeControllers.controller('InicioProduto', ['$scope', '$http',
    function ($scope, $http) {
        $scope.produtos = [];

        $scope.listarDisponiveis = function () {
            $http.post("http://localhost:8080/AtividadeUnama/Produto/listarDisponiveis")
                    .success(function (data) {
                        if (data.code !== 0) {

                        } else {
                            $scope.produtos = data.produtos;
                            $scope.$applay();
                        }
                    });
        };
        $scope.listarDisponiveis();
    }]);