package by.trjava.task04.dao.impl;

import by.trjava.task04.dao.MatrixDAO;
import by.trjava.task04.dao.exception.DAOException;
import by.trjava.task04.dao.validation.FileValidator;
import by.trjava.task04.dao.validation.exception.FileValidationException;
import java.io.File;
import java.util.Scanner;

public class FileMatrixDAOImpl implements MatrixDAO {

    public int readSquareMatrixSizeFromFile(File file) throws DAOException {
        try {
            FileValidator.getInstance().validateFile(file);
        } catch (FileValidationException ex) {
            throw new DAOException(ex);
        }

        int size = 0;
        try (Scanner scanner = new Scanner(file)) {
            String line = scanner.nextLine();
            size = Integer.parseInt(line.substring(line.lastIndexOf("=") + 1));
        } catch (Exception e) {
        }

        return size;
    }
}
