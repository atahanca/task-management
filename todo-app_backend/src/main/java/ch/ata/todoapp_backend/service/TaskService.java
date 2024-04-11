package ch.ata.todoapp_backend.service;

import ch.ata.todoapp_backend.repository.TaskRepository;

public class TaskService {
    private final TaskRepository taskRepository; // creates a variable of type TaskRepository. This means that taskRepository must be an instance of TaskRepository

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


}
