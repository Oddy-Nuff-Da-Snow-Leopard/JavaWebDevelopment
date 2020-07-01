package by.epam.appetizer.dao.impl.sql;

import by.epam.appetizer.entity.CartItem;

import by.epam.appetizer.dao.CartItemDAO;
import by.epam.appetizer.dao.exception.DAOException;

import java.sql.*;

import static by.epam.appetizer.dao.configuration.SQLQuery.*;

import by.epam.appetizer.dao.pool.ConnectionPool;
import by.epam.appetizer.dao.util.Creator;

import java.util.ArrayList;
import java.util.List;

public class SQLCartItemDAOImpl implements CartItemDAO {

    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();

    @Override
    public void addDishToCart(int userCartId, int dishId) throws DAOException {
        try (Connection connection = CONNECTION_POOL.takeConnection();
             CallableStatement cs = connection.prepareCall(INSERT_CART_ITEM)) {
            cs.setInt(1, userCartId);
            cs.setInt(2, dishId);
            cs.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("SQLException in SQLCartItemDAOImpl, failed to add dish to cart " + e);
        }
    }

    @Override
    public void deleteDishFromCart(int cartItemId) throws DAOException {
        try (Connection connection = CONNECTION_POOL.takeConnection();
             CallableStatement cs = connection.prepareCall(DELETE_CART_ITEM_BY_CART_ITEM_ID)) {
            cs.setInt(1, cartItemId);
            cs.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("SQLException in SQLCartItemDAOImpl, failed to delete dish from cart " + e);
        }
    }

    @Override
    public void updateQuantity(int cartItemId, int quantity) throws DAOException {
        try (Connection connection = CONNECTION_POOL.takeConnection();
             PreparedStatement ps = connection.prepareStatement(UPDATE_CART_ITEM_QUANTITY)) {
            ps.setInt(1, quantity);
            ps.setInt(2, cartItemId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("SQLException in SQLCartItemDAOImpl, failed to update quantity " + e);
        }
    }

    @Override
    public List<CartItem> getAllCartItemsByUserCartId(int userCartId) throws DAOException {
        List<CartItem> cartItems = new ArrayList<>();
        try (Connection connection = CONNECTION_POOL.takeConnection();
             PreparedStatement ps = connection.prepareStatement(SELECT_CART_ITEM_BY_USER_CART_ID)) {
            ps.setInt(1, userCartId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    cartItems.add(Creator.getInstance().createCartItem(rs));
                }
                return cartItems;
            }
        } catch (SQLException e) {
            throw new DAOException("SQLException in SQLUserDAOImpl, failed to get all cart items by user cart id " + e);
        }
    }

    @Override
    public List<CartItem> getAllCartItemsByUserId(int userId) throws DAOException {
        List<CartItem> cartItems = new ArrayList<>();
        try (Connection connection = CONNECTION_POOL.takeConnection();
             PreparedStatement ps = connection.prepareStatement(SELECT_CART_ITEM_BY_USER_ID)) {
            ps.setInt(1, userId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    cartItems.add(Creator.getInstance().createCartItem(rs));
                }
                return cartItems;
            }
        } catch (SQLException e) {
            throw new DAOException("SQLException in SQLUserDAOImpl, failed to get all cart items by user id " + e);
        }
    }

    @Override
    public CartItem getCartItemById(int cartItemId) throws DAOException {
        try (Connection connection = CONNECTION_POOL.takeConnection();
             PreparedStatement ps = connection.prepareStatement(SELECT_CART_ITEM_BY_CART_ITEM_ID)) {
            ps.setInt(1, cartItemId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return Creator.getInstance().createCartItem(rs);
                } else {
                    throw new DAOException("Failed to get cart item by id, result set is empty");
                }
            }
        } catch (SQLException e) {
            throw new DAOException("SQLException in SQLUserDAOImpl, failed to get cart item by id " + e);
        }
    }
}
