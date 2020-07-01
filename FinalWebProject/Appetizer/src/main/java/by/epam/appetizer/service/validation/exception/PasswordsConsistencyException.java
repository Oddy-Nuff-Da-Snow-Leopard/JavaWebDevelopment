package by.epam.appetizer.service.validation.exception;

import by.epam.appetizer.service.exception.ServiceException;

public class PasswordsConsistencyException extends ServiceException {

    public PasswordsConsistencyException() {
        super();
    }

    public PasswordsConsistencyException(String message) {
        super(message);
    }

    public PasswordsConsistencyException(String message, Throwable cause) {
        super(message, cause);
    }

    public PasswordsConsistencyException(Throwable cause) {
        super(cause);
    }
}
