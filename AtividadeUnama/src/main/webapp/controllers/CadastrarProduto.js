var AtividadeControllers = angular.module('AtividadeApp');
AtividadeControllers.controller('CadastrarProduto',['$scope','$http',
    function ($scope, $http) {
        $scope.produto = {};
        
        function prepararDados(dados) {
            var fd = new FormData();
            for (var key in dados) {
                fd.append(key, dados[key]);
            }
            return fd;
        }
        
        $scope.cadastrar = function () {
            fd = prepararDados($scope.produto);
            $http.post("http://localhost:8080/AtividadeUnama/Produto/salvar",fd,{headers: {'Content-Type':undefined}})
                    .success(function(data){
                        if(data.code !== 0){
                            
                        }else if (data.code === 11){
                            
                        }
            });
        };
    }]);

