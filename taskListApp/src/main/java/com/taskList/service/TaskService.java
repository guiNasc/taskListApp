package com.taskList.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.taskList.model.Task;
import com.taskList.repository.TaskRepository;

@RestController
@RequestMapping("/tarefas")
@CrossOrigin(origins = "*")
public class TaskService {

	@Autowired
	private TaskRepository repository;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Task>> listar() {
		ArrayList<Task> tasks = (ArrayList<Task>) repository.findAll();

		return new ResponseEntity<List<Task>>(tasks, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Task> buscar(@PathVariable("id") Integer id) {
		
		Task tarefa = repository.findOne(id);
		if (tarefa == null) {
			return new ResponseEntity<Task>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Task>(tarefa, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Task> criar(@RequestBody Task task, UriComponentsBuilder ucBuilder) {

		if (!repository.exists(task.getId()) && task.getId() != 0) {
			return new ResponseEntity<Task>(HttpStatus.CONFLICT);
		} else {
			repository.save(task);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucBuilder.path("/tarefas/{id}").buildAndExpand(task.getId()).toUri());
			return new ResponseEntity<Task>(headers, HttpStatus.CREATED);
		}

	}
	
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Task> editar(@RequestBody Task task, UriComponentsBuilder ucBuilder) {
		Task tarefaAtual = repository.findOne(task.getId());
		if (tarefaAtual == null) {
			return new ResponseEntity<Task>(HttpStatus.NOT_FOUND);
		} else {
			
			tarefaAtual.setConcluido(task.isConcluido());
			tarefaAtual.setDescricao(task.getDescricao());
			tarefaAtual.setDtEdicao(new Date());
			tarefaAtual.setTitulo(task.getTitulo());
			
			repository.save(tarefaAtual);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucBuilder.path("/tarefas/{id}").buildAndExpand(task.getId()).toUri());
			return new ResponseEntity<Task>(headers, HttpStatus.OK);
		}

	}
	
	 @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<Task> deletar(@PathVariable("id") Integer id) {
	 
	        Task tarefa = repository.findOne(id);
	        if (tarefa == null) {
	            return new ResponseEntity<Task>(HttpStatus.NOT_FOUND);
	        }
	        repository.delete(id);
	        return new ResponseEntity<Task>(HttpStatus.OK);
	    }
}
