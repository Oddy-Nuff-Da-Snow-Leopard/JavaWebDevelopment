package by.epam.appetizer.service.validation.exception;

import by.epam.appetizer.service.exception.ServiceException;

public class EmptyInputDataException extends ServiceException {

    public EmptyInputDataException() {
        super();
    }

    public EmptyInputDataException(String message) {
        super(message);
    }

    public EmptyInputDataException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmptyInputDataException(Throwable cause) {
        super(cause);
    }
}
