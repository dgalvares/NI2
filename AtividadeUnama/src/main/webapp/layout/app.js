var rootPath = "/AtividadeUnama/";

var AtividadeApp = angular.module('AtividadeApp', [
    'ngRoute'
]);

AtividadeApp.config(['$routeProvider',
    function ($routeProvider) {
        $routeProvider.
                when('/Inicio', {
                    templateUrl: 'views/inicio.html',
                    controller: 'InicioProduto'
                }).
                when('/CadastrarProduto', {
                    templateUrl: 'views/produto/cadastrarProduto.html',
                    controller: 'CadastrarProduto'
                }).
                when('/Usuario', {
                    templateUrl: 'views/usuario/cadastrarUsuario.html',
                    controller: 'CadastrarUsuario'
                }).
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


