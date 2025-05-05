package com.example.to_do_list.controller;

import com.example.to_do_list.model.Task;
import com.example.to_do_list.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService TaskService;
    
    public TaskController(TaskService TaskService){
        this.TaskService = TaskService;
    }

    @GetMapping
    public String listTasks(Model model){
        model.addAttribute("tasks", TaskService.findAll());
        model.addAttribute("newTask", new Task());
        return "tasks";
    }

    @PostMapping
    public String addTask(@ModelAttribute Task task){
        TaskService.save(task);
        return "redirect:/tasks";
    }

    @PostMapping("/ {id}/toggle")
    public String toggleTask(@PathVariable Long id){
        TaskService.toggleTaskCompletion(id);
        return "redirect:/tasks";
    }

    @PostMapping("/ {id}/delete")
    public String deleteTask(@PathVariable Long id){
        TaskService.deleteById(id);
        return "redirect:/tasks";
    }
}    

