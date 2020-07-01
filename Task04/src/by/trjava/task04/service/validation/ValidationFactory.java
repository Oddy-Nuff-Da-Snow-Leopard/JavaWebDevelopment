package by.trjava.task04.service.validation;

import by.trjava.task04.service.validation.impl.TxtFilePathValidatorImpl;

public final class ValidationFactory {

    private static final ValidationFactory INSTANCE = new ValidationFactory();

    private final FilePathValidator filePathValidator
            = new TxtFilePathValidatorImpl();

    private ValidationFactory() {
    }

    public static ValidationFactory getInstance() {
        return INSTANCE;
    }

    public FilePathValidator getFilePathValidator() {
        return filePathValidator;
    }

}
