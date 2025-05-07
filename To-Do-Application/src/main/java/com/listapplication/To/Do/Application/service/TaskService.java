package com.listapplication.To.Do.Application.service;

import com.listapplication.To.Do.Application.models.Task;
import com.listapplication.To.Do.Application.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public void createTask(String title){
        Task task = new Task();
        task.setTitle(title);
        task.setTime(LocalDateTime.now());
        task.setCompleted(false);
        taskRepository.save(task);
    }


    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public void statusTask(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Invalid task id"));
                task.setCompleted(!task.isCompleted());
                taskRepository.save(task);
    }
}
