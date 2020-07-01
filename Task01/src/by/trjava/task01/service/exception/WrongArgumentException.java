package by.trjava.task01.service.exception;

/**
 *
 * @author James Spleen
 */
public class WrongArgumentException extends Throwable {

    public WrongArgumentException() {
    }

    public WrongArgumentException(String message) {
        super(message);
    }
}
