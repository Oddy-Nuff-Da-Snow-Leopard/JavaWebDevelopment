package by.epam.appetizer.dao.impl.sql;

import by.epam.appetizer.entity.Dish;

import by.epam.appetizer.dao.DishDAO;
import by.epam.appetizer.dao.exception.DAOException;
import by.epam.appetizer.dao.pool.ConnectionPool;
import by.epam.appetizer.dao.util.Creator;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static by.epam.appetizer.dao.configuration.SQLQuery.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class SQLDishDAOImpl implements DishDAO {

    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();

    @Override
    public List<Dish> getAllDishes() throws DAOException {
        List<Dish> dishes = new ArrayList<>();
        try (Connection connection = CONNECTION_POOL.takeConnection();
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery(SELECT_ALL_FROM_DISHES)) {
            while (rs.next()) {
                dishes.add(Creator.getInstance().createDish(rs));
            }
            return dishes;
        } catch (SQLException e) {
            throw new DAOException("SQLException in SQLDishDAOImpl, failed to get all dishes" + e);
        }
    }

    @Override
    public Dish getDishById(int dishId) throws DAOException {
        try (Connection connection = CONNECTION_POOL.takeConnection();
                PreparedStatement ps = connection.prepareStatement(SELECT_DISH_BY_DISH_ID)) {
            ps.setInt(1, dishId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return Creator.getInstance().createDish(rs);
                } else {
                    throw new DAOException("Failed to get dish by dishId, result set is empty");
                }
            }
        } catch (SQLException e) {
            throw new DAOException("SQLException in SQLDishDAOImpl, failed to get dish by dishId " + e);
        }
    }
}
