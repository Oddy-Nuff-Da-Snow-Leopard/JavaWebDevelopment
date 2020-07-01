package by.epam.appetizer.controller.command.provider.exception;

import by.epam.appetizer.controller.command.exception.CommandException;

public class CommandProviderException extends CommandException {

    public CommandProviderException() {
        super();
    }

    public CommandProviderException(String message) {
        super(message);
    }

    public CommandProviderException(String message, Throwable cause) {
        super(message, cause);
    }

    public CommandProviderException(Throwable cause) {
        super(cause);
    }
}
