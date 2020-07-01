package by.trjava.task03.service.xmlvalidator.exception;

public class XmlValidationException extends Throwable{

    public XmlValidationException(String message) {
        super(message);
    }

    public XmlValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
