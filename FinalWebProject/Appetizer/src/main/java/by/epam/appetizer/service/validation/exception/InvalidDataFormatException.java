package by.epam.appetizer.service.validation.exception;

import by.epam.appetizer.service.exception.ServiceException;

public class InvalidDataFormatException extends ServiceException {

    public InvalidDataFormatException() {
        super();
    }

    public InvalidDataFormatException(String message) {
        super(message);
    }

    public InvalidDataFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidDataFormatException(Throwable cause) {
        super(cause);
    }
}
