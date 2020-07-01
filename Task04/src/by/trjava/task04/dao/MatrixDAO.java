package by.trjava.task04.dao;

import by.trjava.task04.dao.exception.DAOException;
import java.io.File;

public interface MatrixDAO {

    int readSquareMatrixSizeFromFile(File file) throws DAOException;
}
