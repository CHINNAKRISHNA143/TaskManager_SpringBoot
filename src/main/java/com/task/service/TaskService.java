package com.task.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.model.Task;
import com.task.repository.TaskRepository;

@Service
public class TaskService {
	
	@Autowired
	private TaskRepository taskRepository;
	
	public Task createTask(Task task){
		return taskRepository.save(task);
	}
	
	public List<Task> getAllTasks(){
		return taskRepository.findAll();
	}
	
	public Task getTaskById(Long id){
		return  taskRepository.findById(id).orElse(null);
		  /*Optional<Task> optionalTask = taskRepository.findById(id);
		  
		  if(optionalTask.isPresent()) {
			  Task task = optionalTask.get();
			  return task;
		  }
		  return null;*/
	}
	
	public Task updateTask(Long id , Task updatedTask) {
		
		Optional<Task>  optionalTask = taskRepository.findById(id);
		if(optionalTask.isPresent()) {
			Task prevTask = optionalTask.get();
			prevTask.setTitle(updatedTask.getTitle());
			prevTask.setDescription(updatedTask.getDescription());
			prevTask.setStatus(updatedTask.getStatus());
			
			return taskRepository.save(prevTask);
		}
		
		return null;
	}
	
	public void deleteTask(Long id) {
		taskRepository.deleteById(id);
	}
	
}
























