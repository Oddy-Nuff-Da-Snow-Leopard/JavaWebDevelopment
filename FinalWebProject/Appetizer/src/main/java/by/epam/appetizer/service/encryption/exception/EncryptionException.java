package by.epam.appetizer.service.encryption.exception;

public class EncryptionException extends Exception {

    public EncryptionException() {
        super();
    }

    public EncryptionException(String message) {
        super(message);
    }

    public EncryptionException(String message, Throwable e) {
        super(message, e);
    }

    public EncryptionException(Throwable e) {
        super(e);
    }
}
