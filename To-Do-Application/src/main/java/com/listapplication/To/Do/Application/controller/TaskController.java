package com.listapplication.To.Do.Application.controller;

import com.listapplication.To.Do.Application.models.Task;
import com.listapplication.To.Do.Application.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    //handler method to handle tasks
    @GetMapping("/tasks")
    public String getTasks(Model model){
        List<Task> tasks = taskService.getAllTasks();
        model.addAttribute("tasks",tasks);
        return "tasks";
    }

    //post method to post tasks
    @PostMapping("/")
    public String createTask(@RequestParam String title){
        taskService.createTask(title);
        return "redirect:/";
    }

    //delete the task by id
    @GetMapping("/{id}/delete")
    public String deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
        return "redirect:/";
    }

    //handles the status of the task by id if it's completed or not completed
    @GetMapping("/{id}/status")
    public String statusTask(@PathVariable Long id){
        taskService.statusTask(id);
        return "redirect:/";
    }







}
