package com.task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.model.Task;
import com.task.service.TaskService;

@RestController
@RequestMapping("/task")
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	@PostMapping("/create")
	public Task create(@RequestBody Task task) {
		return taskService.createTask(task);
	}
	
	@GetMapping("/getAllTasks")
	public List<Task> allTasks(){
		return taskService.getAllTasks();
	}
	
	@GetMapping("/{id}")
	public Task getById(@PathVariable Long id){
		return taskService.getTaskById(id);
	}
	
	@PutMapping("/update/{id}")
	public Task updateingTask(@PathVariable Long id,@RequestBody Task task) {
		return taskService.updateTask(id, task);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteingTask(@PathVariable Long id) {
		taskService.deleteTask(id);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
