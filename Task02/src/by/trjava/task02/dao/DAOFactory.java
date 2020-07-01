package by.trjava.task02.dao;

import by.trjava.task02.dao.impl.FilePlaneDAOImpl;

public final class DAOFactory {

    private static final DAOFactory INSTANCE = new DAOFactory();

    private final PlaneDAO planeDAO = new FilePlaneDAOImpl();

    private DAOFactory() {

    }

    public static DAOFactory getInstance() {
        return INSTANCE;
    }

    public PlaneDAO getPlaneDAO() {
        return planeDAO;
    }
}
