package by.trjava.task02.service.factory.exception;

public class PlaneCreationException extends Exception {

    public PlaneCreationException(String message) {
        super(message);
    }

    public PlaneCreationException(String message, Throwable cause) {
        super(message, cause);
    }
}
