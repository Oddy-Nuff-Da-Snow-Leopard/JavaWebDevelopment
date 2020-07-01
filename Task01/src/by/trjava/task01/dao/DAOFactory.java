package by.trjava.task01.dao;

import by.trjava.task01.dao.impl.FileApplianceDAOImpl;

/**
 *
 * @author Alekseev Maksim
 */
public final class DAOFactory {

    private static final DAOFactory instance = new DAOFactory();

    private final ApplianceDAO applianceDAO
            = new FileApplianceDAOImpl();

    private DAOFactory() {
    }

    public ApplianceDAO getApplianceDAO() {
        return applianceDAO;
    }

    public static DAOFactory getInstance() {
        return instance;
    }
}
