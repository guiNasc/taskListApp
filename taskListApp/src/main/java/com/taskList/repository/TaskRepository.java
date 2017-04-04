package com.taskList.repository;

import org.springframework.data.repository.CrudRepository;

import com.taskList.model.Task;

public interface TaskRepository extends CrudRepository<Task, Integer>{
	
	
}
