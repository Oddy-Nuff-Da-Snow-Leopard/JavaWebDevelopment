package by.trjava.task04.service.validation.impl;

import by.trjava.task04.service.validation.FilePathValidator;
import by.trjava.task04.service.validation.exception.FilePathValidationException;

public class TxtFilePathValidatorImpl implements FilePathValidator {

    private static final String DOT = ".";
    private static final String TXT_EXTENSION = "txt";

    public void validateFilePath(String filePath) throws FilePathValidationException {
        if (filePath == null) {
            throw new FilePathValidationException("File path refers to null!");
        }

        if (filePath.isEmpty()) {
            throw new FilePathValidationException("File path is empty!");
        }

        if (!filePath.substring(filePath.lastIndexOf(DOT) + 1).equals(TXT_EXTENSION)) {
            throw new FilePathValidationException("File path does not indicate txt extension!");
        } 
    }
}
