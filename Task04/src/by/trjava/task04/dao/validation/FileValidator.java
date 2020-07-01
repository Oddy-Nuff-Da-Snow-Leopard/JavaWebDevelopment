package by.trjava.task04.dao.validation;

import by.trjava.task04.dao.validation.exception.FileValidationException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public final class FileValidator {

    private static final FileValidator INSTANCE = new FileValidator();

    private FileValidator() {
    }

    public static FileValidator getInstance() {
        return INSTANCE;
    }

    public void validateFile(File file) throws FileValidationException {
        if (file == null) {
            throw new FileValidationException("File refers to null!");
        }
        if (!file.exists()) {
            throw new FileValidationException("File does not exist!");
        }

        try (Scanner scanner = new Scanner(file)) {
            if (!scanner.hasNextLine()) {
                throw new FileValidationException("File is not valid!");
            }
            if (!scanner.nextLine().matches("(\\D+)=(\\d+)")) {
                throw new FileValidationException("File is not valid! Key-Value do not match pattern!");
            }
        } catch (FileNotFoundException ex) {
            throw new FileValidationException(ex);
        }
    }
}
