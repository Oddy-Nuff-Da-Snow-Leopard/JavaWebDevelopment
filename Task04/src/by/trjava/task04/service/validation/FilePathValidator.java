package by.trjava.task04.service.validation;

import by.trjava.task04.service.validation.exception.FilePathValidationException;

public interface FilePathValidator {

    void validateFilePath(String filePath) throws FilePathValidationException;
}
