package by.epam.appetizer.service.exception;

public class IncorrectEmailException extends ServiceException {

    public IncorrectEmailException() {
        super();
    }

    public IncorrectEmailException(String message) {
        super(message);
    }

    public IncorrectEmailException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectEmailException(Throwable cause) {
        super(cause);

    }
}
