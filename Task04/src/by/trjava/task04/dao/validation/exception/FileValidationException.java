package by.trjava.task04.dao.validation.exception;

public class FileValidationException extends Exception {

    public FileValidationException(String message) {
        super(message);
    }

    public FileValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileValidationException(Throwable cause) {
        super(cause);
    }
}
