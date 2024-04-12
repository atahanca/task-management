package ch.ata.todoapp_backend.exception;

public class TaskNotFoundException extends RuntimeException {

    public TaskNotFoundException(String message) {
        super(message);
    }

    // You could also provide a constructor that accepts a cause.
    public TaskNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    // Optionally, if you plan to use it with logging or serialization, you might want to add a serialVersionUID.
    private static final long serialVersionUID = 1L;
}
