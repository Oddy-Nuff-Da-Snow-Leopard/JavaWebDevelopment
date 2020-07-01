package by.trjava.task04.service.impl;

import by.trjava.task04.dao.DAOFactory;
import by.trjava.task04.dao.MatrixDAO;
import by.trjava.task04.dao.exception.DAOException;
import by.trjava.task04.service.MatrixService;
import by.trjava.task04.service.exception.ServiceException;
import by.trjava.task04.service.validation.FilePathValidator;
import by.trjava.task04.service.validation.ValidationFactory;
import by.trjava.task04.service.validation.exception.FilePathValidationException;
import java.io.File;

public class MatrixServiceImpl implements MatrixService {

    public int getSquareMatrixSizeFromFile(String filePath) throws ServiceException {

        ValidationFactory validationFactory = ValidationFactory.getInstance();
        FilePathValidator filePathValidator = validationFactory.getFilePathValidator();

        try {
            filePathValidator.validateFilePath(filePath);
        } catch (FilePathValidationException ex) {
            throw new ServiceException(ex);
        }

        File file = new File(filePath);

        DAOFactory factory = DAOFactory.getInstance();
        MatrixDAO matrixDAO = factory.getMatrixDAO();

        int size = 0;
        try {
            size = matrixDAO.readSquareMatrixSizeFromFile(file);
        } catch (DAOException ex) {
            throw new ServiceException(ex);
        }

        return size;
    }
}
