package ch.ata.todoapp_backend.repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import ch.ata.todoapp_backend.model.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    @Transactional
    void deleteByTaskId(Integer taskId);  // Change this from deleteTaskById to deleteByTaskId

    Optional<Task> findByTaskId(Integer taskId); // Make sure this matches your entity's primary key name if using custom find.

    List<Task> findAll();

    List<Task> findByTaskName(String name);

    List<Task> findByTaskStatus(String taskStatus);

    List<Task> findByTaskDate(Date taskDate);
}
