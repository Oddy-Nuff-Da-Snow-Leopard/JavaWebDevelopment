package by.trjava.task03.service.xmlvalidator;

import by.trjava.task03.service.xmlvalidator.exception.XmlValidationException;

public interface XmlValidator {

    void validateByXSD(String XMLPath, String XSDPath)
            throws XmlValidationException;
}
