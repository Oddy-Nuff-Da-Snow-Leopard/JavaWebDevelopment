package by.trjava.task04.service;

import by.trjava.task04.service.exception.ServiceException;

public interface MatrixService {

    int getSquareMatrixSizeFromFile(String filePath) throws ServiceException;
}
