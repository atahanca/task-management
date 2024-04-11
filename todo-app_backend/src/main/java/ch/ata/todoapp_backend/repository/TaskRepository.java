package ch.ata.todoapp_backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.ata.todoapp_backend.model.Task;

public interface TaskRepository extends JpaRepository <Task, Integer> {
    void deleteTaskById(Integer id);

    Optional<Task> findTaskById(Integer id);
    List<Task> findAll();
    List<Task> findByName(String name);
    List<Task> findByStatus(String status);
    List<Task> findByDate(String date);
} 
