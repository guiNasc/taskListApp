angular.module("taskList").config(function ($routeProvider){
	$routeProvider.when("/",{
		templateUrl: "view/tarefas.html"
	})
});