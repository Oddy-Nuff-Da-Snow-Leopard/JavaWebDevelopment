package by.epam.appetizer.dao;

import by.epam.appetizer.dao.impl.sql.*;

public final class DAOFactory {

    private static final DAOFactory INSTANCE = new DAOFactory();

    private final UserDAO userDAO = new SQLUserDAOImpl();
    private final TokenDAO tokenDAO = new SQLTokenDAOImpl();
    private final DishDAO dishDAO = new SQLDishDAOImpl();
    private final DishCategoryDAO dishCategoryDAO = new SQLDishCategoryDAOImpl();
    private final UserCartDAO userCartDAO = new SQLUserCartDAOImpl();
    private final CartItemDAO cartItemDAO = new SQLCartItemDAOImpl();
    private final OrderDAO orderDAO = new SQLOrderDAOImpl();

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return INSTANCE;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public TokenDAO getTokenDAO() {
        return tokenDAO;
    }

    public DishDAO getDishDAO() {
        return dishDAO;
    }

    public DishCategoryDAO getDishCategoryDAO() {
        return dishCategoryDAO;
    }

    public UserCartDAO getUserCartDAO() {
        return userCartDAO;
    }

    public CartItemDAO getCartItemDAO() {
        return cartItemDAO;
    }

    public OrderDAO getOrderDAO() {
        return orderDAO;
    }
}
