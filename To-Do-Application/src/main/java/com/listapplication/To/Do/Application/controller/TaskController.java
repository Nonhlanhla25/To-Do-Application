package com.listapplication.To.Do.Application.controller;

import com.listapplication.To.Do.Application.models.Task;
import com.listapplication.To.Do.Application.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @GetMapping
    public String getTask(Model model){
        List<Task> tasks = taskService.getAllTasks();
        model.addAttribute("task",tasks);
        return "tasks.html";
    }



}
