package com.listapplication.To.Do.Application.controller;

import com.listapplication.To.Do.Application.models.Task;
import com.listapplication.To.Do.Application.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import static jdk.javadoc.internal.doclets.formats.html.markup.HtmlStyle.title;


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

    @PostMapping("")
    public String createTask(RequestParam String title){
        taskService.createTask(java.lang.String.valueOf(title));
        return "redirect:/";
    }



}
