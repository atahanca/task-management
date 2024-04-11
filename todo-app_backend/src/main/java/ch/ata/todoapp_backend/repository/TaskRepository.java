package ch.ata.todoapp_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.ata.todoapp_backend.model.Task;

public interface TaskRepository extends JpaRepository <Task, Integer> {
    
    
} 
