package ch.ata.todoapp_backend.controller;

import ch.ata.todoapp_backend.exception.TaskNotFoundException;
import ch.ata.todoapp_backend.model.Task;
import ch.ata.todoapp_backend.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Makes this class a REST controller, able to handle HTTP requests.
@RequestMapping("/tasks") // Sets the base path for all endpoints in this controller.
public class TaskController {

    private final TaskService taskService;

    @Autowired // Automatically injects an instance of TaskService.
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping // Responds to HTTP GET requests and returns all tasks.
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> tasks = taskService.getAllTasks();
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/{id}") // Responds to HTTP GET requests with a specific task ID.
    public ResponseEntity<Task> getTaskById(@PathVariable Integer id) {
        Task task = taskService.getTaskById(id)
            .orElseThrow(() -> new TaskNotFoundException("Task not found with id: " + id));
        return ResponseEntity.ok(task);
    }

    @PostMapping // Responds to HTTP POST requests and creates a new task.
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        Task createdTask = taskService.createTask(task);
        return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
public ResponseEntity<Task> updateTask(@PathVariable Integer id, @RequestBody Task task) {
    Task updatedTask = taskService.updateTask(id, task);
    return ResponseEntity.ok(updatedTask);
}


    @DeleteMapping("/{id}") // Responds to HTTP DELETE requests and deletes a task.
    public ResponseEntity<Void> deleteTaskById(@PathVariable Integer id) {
        taskService.deleteTaskById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // You can include other endpoints as necessary...

    @ExceptionHandler(TaskNotFoundException.class) // Handles TaskNotFoundExceptions.
    public ResponseEntity<String> handleTaskNotFound(TaskNotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class) // Handles other exceptions.
    public ResponseEntity<String> handleException(Exception e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
