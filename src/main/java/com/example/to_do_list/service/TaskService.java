package com.example.to_do_list.service;

import com.example.to_do_list.model.Task;
import com.example.to_do_list.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Optional;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public Task save(Task task) {
        return taskRepository.save(task);
    }

    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }

    public Optional<Task> findById(Long id){ // Changed method name to findById for clarity
        return taskRepository.findById(id);
    }

    public Task toggleTaskCompletion(Long id) {
        return taskRepository.findById(id).map(task -> {
            boolean currentStatus = task.isCompleted();
            task.setCompleted(!currentStatus);
            task.setUpdatedAt(LocalDateTime.now());
            return taskRepository.save(task);
        }).orElseThrow(() -> new RuntimeException("Task not found"));
    }
}
