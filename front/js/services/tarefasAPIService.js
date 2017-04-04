angular.module("taskList").factory("tarefasAPI", function($http, config){
	var _getTarefas = function(){
		return $http.get(config.baseUrl + "/tarefas");
	};

	var _saveTarefa = function(tarefa){
		return $http.post(config.baseUrl + "/tarefas", tarefa);
	};

	var _updateTarefa = function(tarefa){
		return $http.put(config.baseUrl + "/tarefas", tarefa);
	};

	var _deleteTarefa = function(tarefa){
		return $http.delete(config.baseUrl + "/tarefas/"+tarefa.id);
	};

	return{
		getTarefas: 	_getTarefas,
		saveTarefa: 	_saveTarefa,
		updateTarefa: 	_updateTarefa,
		deleteTarefa: 	_deleteTarefa
	};

 });