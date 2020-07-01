package by.trjava.task02.service.exception;

public class WrongParameterException extends Exception {

    public WrongParameterException(String message) {
        super(message);
    }

    public WrongParameterException(String message, Throwable cause) {
        super(message, cause);
    }
}
