package ch.ata.todoapp_backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import ch.ata.todoapp_backend.model.Task;
import ch.ata.todoapp_backend.service.TaskService;

public class TaskController {
    

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @PostMapping
    public List<Task> createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    @GetMapping("/{id}")
    public Optional<Task> getTaskById(@PathVariable Integer id) {
        return taskService.getTaskById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteTaskById(@PathVariable Integer id) {
        taskService.deleteTaskById(id);
    }
}
