package by.epam.appetizer.dao.impl.sql;

import by.epam.appetizer.entity.DishCategory;

import by.epam.appetizer.dao.DishCategoryDAO;
import by.epam.appetizer.dao.exception.DAOException;
import by.epam.appetizer.dao.pool.ConnectionPool;
import by.epam.appetizer.dao.util.Creator;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import static by.epam.appetizer.dao.configuration.SQLQuery.*;

public class SQLDishCategoryDAOImpl implements DishCategoryDAO {

    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();

    public List<DishCategory> getAllDishesCategories() throws DAOException {
        List<DishCategory> dishesCategories = new ArrayList<>();
        try {
            try (Connection connection = CONNECTION_POOL.takeConnection();
                    Statement statement = connection.createStatement();
                    ResultSet rs = statement.executeQuery(SELECT_ALL_FROM_DISHES_CATEGORIES)) {
                while (rs.next()) {
                    dishesCategories.add(Creator.getInstance().createDishCategory(rs));
                }
            }
            return dishesCategories;
        } catch (SQLException e) {
            throw new DAOException("SQLException in SQLDishCategoryDAOImpl,"
                    + " failed to get all dishes categories" + e);
        }
    }
}
