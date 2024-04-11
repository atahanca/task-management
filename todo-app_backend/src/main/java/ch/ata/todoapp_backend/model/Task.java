package ch.ata.todoapp_backend.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class for storing objects of this type.
public class Task {
    
    @Id // This tells Hibernate that this is the primary key
    private Integer taskId;  // this the primary key
    private String taskName;
    private String taskDescription;
    private String taskStatus;
    private Date taskDate;

}
