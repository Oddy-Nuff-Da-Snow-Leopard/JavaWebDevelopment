package by.trjava.task02.service.repository.exception;

public class PlaneRepositoryException extends Exception {

    public PlaneRepositoryException(String message) {
        super(message);
    }

    public PlaneRepositoryException(String message, Throwable cause) {
        super(message, cause);
    }
}
