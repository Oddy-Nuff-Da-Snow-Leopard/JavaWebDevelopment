package by.trjava.task04.service.validation.exception;

public class FilePathValidationException extends Exception {

    public FilePathValidationException(String message) {
        super(message);
    }

    public FilePathValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
