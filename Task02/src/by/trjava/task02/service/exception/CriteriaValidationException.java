package by.trjava.task02.service.exception;

public class CriteriaValidationException extends Exception {

    public CriteriaValidationException(String message) {
        super(message);
    }

    public CriteriaValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
