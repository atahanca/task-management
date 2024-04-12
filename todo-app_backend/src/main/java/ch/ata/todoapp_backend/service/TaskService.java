package ch.ata.todoapp_backend.service;

import java.util.List;
import java.util.Optional;

import ch.ata.todoapp_backend.model.Task;
import ch.ata.todoapp_backend.repository.TaskRepository;

public class TaskService {
    private final TaskRepository taskRepository; // creates a variable of type TaskRepository. This means that
                                                 // taskRepository must be an instance of TaskRepository

    // 0Construction injection. This is the constructor of the TaskService class. It
    // takes an argument of type TaskRepository and assigns it to the taskRepository
    // variable.
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository; // creates an instance of the TaskRepository class and assigns it to the
                                              // taskRepository variable.
    }

    // Create operation. This method creates a new task and saves it to the
    // database.
    public Task createTask(Task task) {

        return taskRepository.save(task);
    }

    // Read operation. This method returns all tasks from the database.
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    // Update operation. This method updates an existing task in the database
    public List<Task> getTasksByStatus(String status) {
        return taskRepository.findByTaskStatus(status);
    }

    public Optional<Task> getTaskById(Integer id) {
        return taskRepository.findById(id);
    }

    public Task updateTask(Integer id, Task task) {
        Optional<Task> taskOptional = taskRepository.findById(id);
        if (taskOptional.isPresent()) {
            Task taskToUpdate = taskOptional.get();
            taskToUpdate.setTaskName(task.getTaskName());
            taskToUpdate.setTaskDescription(task.getTaskDescription());
            taskToUpdate.setTaskStatus(task.getTaskStatus());
            taskRepository.save(taskToUpdate);
            return taskToUpdate;
        } else {
            throw new RuntimeException("Task not found with id: " + id);
        }
    }

    public void deleteTaskById(Integer id) {
        taskRepository.deleteByTaskId(id);
    }

    public List<Task> getTasksByName(String name) {
        return taskRepository.findByTaskName(name);
    }

}
