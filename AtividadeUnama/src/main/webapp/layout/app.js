var rootPath = "/AtividadeUnama/";

var AtividadeApp = angular.module('AtividadeApp', [
    'ngRoute'
]);

AtividadeApp.config(['$routeProvider',
    function ($routeProvider) {
        $routeProvider.
                when('/Inicio', {
                    templateUrl: 'views/inicio.html',
                    controller: 'Inicio'
                }).
                when('/CadastrarProduto', {
                    templateUrl: 'views/cadastrarProduto.html',
                    controller: 'CadastrarProduto'
                }).
//                when('/Consultar', {
//                    templateUrl: 'views/consultar.html',
//                    controller: 'Consultar'
//                }).
//                when('/Excluir', {
//                    templateUrl: 'views/excluir.html',
//                    controller: 'Excluir'
//                }).
//                when('/Perfil', {
//                    templateUrl: 'views/Autenticar/perfil.html',
//                    controller: 'AutenticacaoPerfil'
//                }).
        otherwise({
            redirectTo: '/Inicio'
        });
    }]);


