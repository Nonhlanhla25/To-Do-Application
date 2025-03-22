package com.listapplication.To.Do.Application.service;

import com.listapplication.To.Do.Application.models.Task;
import com.listapplication.To.Do.Application.repository.TaskRepository;
import org.springframework.stereotype.Service;

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
}
