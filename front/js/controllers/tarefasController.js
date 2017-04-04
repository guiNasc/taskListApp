angular.module("taskList").controller("tarefasController", function($scope, $http, tarefasAPI){
	$scope.tarefas = [];
	

	var carregarTarefas = function(){
		tarefasAPI.getTarefas().success(function(data){
			$scope.tarefas = data;
		}).error(function(data){
			$scope.message = "Aconteceu um problema: " + data;
		});

	};

	$scope.adicionarTarefa = function (tarefa) {
		tarefa.id = "null";
		tarefasAPI.saveTarefa(tarefa).success(function (data) {
			delete $scope.tarefa;
			$scope.tarefaForm.$setPristine();
			carregarTarefas();
		});
	};

	$scope.atualizarTarefa = function (tarefa) {
		tarefasAPI.updateTarefa(tarefa).success(function (data) {
				delete $scope.tarefa;
				$scope.tarefaForm.$setPristine();
				carregarTarefas();
			});
	};

	$scope.apagarTarefa = function (tarefa) {
		tarefasAPI.deleteTarefa(tarefa).success(function (data) {
				delete $scope.tarefa;
				$scope.tarefaForm.$setPristine();
				carregarTarefas();
			});
	};

	

	carregarTarefas();
});

/*
var get = function (url, callback){
 var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState === 4){
			callback(xhr.responseText, xhr.status);
		}
	};
	xhr.open('GET', url);
	xhr.send(null);
};

*/
