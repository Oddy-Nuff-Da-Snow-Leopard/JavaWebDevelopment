package by.epam.appetizer.service.exception;

public class EmailIsAlreadyUsedException extends ServiceException {

    public EmailIsAlreadyUsedException() {
        super();
    }

    public EmailIsAlreadyUsedException(String message) {
        super(message);
    }

    public EmailIsAlreadyUsedException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmailIsAlreadyUsedException(Throwable cause) {
        super(cause);
    }
}
