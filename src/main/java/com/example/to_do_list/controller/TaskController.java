package com.example.to_do_list.controller;

import com.example.to_do_list.model.Task;
import com.example.to_do_list.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

@Controller
@RequestMapping("/tasks")
public class TaskController {
   
    private final TaskService taskService;
    
    public TaskController(TaskService taskService){
        this.taskService = taskService; 
    }

    @GetMapping
    public String listTasks(Model model){
        model.addAttribute("tasks", taskService.findAll()); 
        model.addAttribute("newTask", new Task());
        return "tasks";
    }

    @PostMapping
    public String addTask(@ModelAttribute Task task){
        taskService.save(task);
        return "redirect:/tasks";
    }


    @PostMapping("/{id}/toggle")
    public String toggleTask(@PathVariable Long id){
        taskService.toggleTaskCompletion(id); 
        return "redirect:/tasks";
    }

    
    @PostMapping("/{id}/delete")
    public String deleteTask(@PathVariable Long id){
        taskService.deleteById(id); 
        return "redirect:/tasks";
    }
     @GetMapping("/{id}/detail") 
    public String viewTask(@PathVariable Long id, Model model){ 
        Task task = taskService.findById(id) 
                               .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Task not found"));
        model.addAttribute("task", task);
        return "task-detail";
    }
}