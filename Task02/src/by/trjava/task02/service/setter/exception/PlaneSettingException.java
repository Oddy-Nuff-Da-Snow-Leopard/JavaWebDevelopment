package by.trjava.task02.service.setter.exception;

public class PlaneSettingException extends Exception {

    public PlaneSettingException(String message) {
        super(message);
    }

    public PlaneSettingException(String message, Throwable cause) {
        super(message, cause);
    }
}
