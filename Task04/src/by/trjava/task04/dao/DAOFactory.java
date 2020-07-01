package by.trjava.task04.dao;

import by.trjava.task04.dao.impl.FileMatrixDAOImpl;

public final class DAOFactory {

    private static final DAOFactory INSTANCE = new DAOFactory();

    private final MatrixDAO matrixDAO = new FileMatrixDAOImpl();

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return INSTANCE;
    }

    public MatrixDAO getMatrixDAO() {
        return matrixDAO;
    }
}
