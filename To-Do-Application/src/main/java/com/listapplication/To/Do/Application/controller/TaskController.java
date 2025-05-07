package com.listapplication.To.Do.Application.controller;

import com.listapplication.To.Do.Application.models.Task;
import com.listapplication.To.Do.Application.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


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

//    post method to post tasks
    @PostMapping("/")
    public String createTask(@RequestParam String title){
        taskService.createTask(title);
        return "redirect:/tasks";
    }

    //Delete the tasks by id
    @GetMapping("/task/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "redirect:/tasks";
    }



    //handles the status of the task by id if it's completed or not completed
    @GetMapping("/task/status/{id}")
    public String statusTask(@PathVariable Long id){
        taskService.statusTask(id);
        return "redirect:/tasks";
    }







}
