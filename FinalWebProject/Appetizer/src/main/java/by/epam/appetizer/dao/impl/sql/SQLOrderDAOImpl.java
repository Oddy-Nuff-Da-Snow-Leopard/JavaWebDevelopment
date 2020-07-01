package by.epam.appetizer.dao.impl.sql;

import by.epam.appetizer.dao.OrderDAO;
import by.epam.appetizer.dao.configuration.SQLQuery;

import by.epam.appetizer.dao.exception.DAOException;
import by.epam.appetizer.dao.pool.ConnectionPool;
import by.epam.appetizer.dao.util.Creator;
import by.epam.appetizer.entity.CartItem;
import by.epam.appetizer.entity.Order;
import by.epam.appetizer.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static by.epam.appetizer.dao.configuration.SQLQuery.*;

public class SQLOrderDAOImpl implements OrderDAO {

    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();

    @Override
    public void addOrder(int userCartId, double totalPrice) throws DAOException {
        try (Connection connection = CONNECTION_POOL.takeConnection();
             CallableStatement cs = connection.prepareCall(INSERT_ORDER)) {
            cs.setInt(1, userCartId);
            cs.setDouble(2, totalPrice);
            Date date = new Date(new java.util.Date().getTime());
            cs.setDate(3, date);
            cs.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("SQLException in SQLOrderDAOImpl, failed to add order " + e);
        }
    }

    @Override
    public List<Order> getAllOrdersByUserId(int userId) throws DAOException {
        List<Order> orders = new ArrayList<>();
        try (Connection connection = CONNECTION_POOL.takeConnection();
             PreparedStatement ps = connection.prepareStatement(SELECT_ORDER_BY_USER_ID)) {
            ps.setInt(1, userId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    orders.add(Creator.getInstance().createOrder(rs));
                }
                return orders;
            }
        } catch (SQLException e) {
            throw new DAOException("SQLException in SQLOrderDAOImpl, failed to get all orders by userId " + e);
        }
    }

    @Override
    public List<Order> getAllOrdersByStatusId(int statusId) throws DAOException {
        List<Order> orders = new ArrayList<>();
        try (Connection connection = CONNECTION_POOL.takeConnection();
             PreparedStatement ps = connection.prepareStatement(SELECT_ORDER_BY_STATUS_ID)) {
            ps.setInt(1, statusId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    orders.add(Creator.getInstance().createOrder(rs));
                }
                return orders;
            }
        } catch (SQLException e) {
            throw new DAOException("SQLException in SQLOrderDAOImpl, failed to get all orders by statusId " + e);
        }
    }

    @Override
    public Order getOrderById(int orderId) throws DAOException {
        try (Connection connection = CONNECTION_POOL.takeConnection();
             PreparedStatement ps = connection.prepareStatement(SELECT_ORDER_BY_ORDER_ID)) {
            ps.setInt(1, orderId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return Creator.getInstance().createOrder(rs);
                } else {
                    throw new DAOException("Failed to get order by orderId, result set is empty");
                }
            }
        } catch (SQLException e) {
            throw new DAOException("SQLException in SQLOrderDAOImpl, failed to get order by orderId " + e);
        }
    }

    @Override
    public User getUserByOrderId(int orderId) throws DAOException {
        try (Connection connection = CONNECTION_POOL.takeConnection();
             PreparedStatement ps = connection.prepareStatement(SELECT_USER_BY_ORDER_ID)) {
            ps.setInt(1, orderId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return Creator.getInstance().createUser(rs);
                } else {
                    throw new DAOException("Failed to get user by orderId, result set is empty");
                }
            }
        } catch (SQLException e) {
            throw new DAOException("SQLException in SQLOrderDAOImpl, failed to get user by orderId " + e);
        }
    }

    @Override
    public List<CartItem> getAllCartItemsByOrderId(int orderId) throws DAOException {
        List<CartItem> cartItems = new ArrayList<>();
        try (Connection connection = CONNECTION_POOL.takeConnection();
             PreparedStatement ps = connection.prepareStatement(SELECT_CART_ITEM_BY_ORDER_ID)) {
            ps.setInt(1, orderId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    cartItems.add(Creator.getInstance().createCartItem(rs));
                }
                return cartItems;
            }
        } catch (SQLException e) {
            throw new DAOException("SQLException in SQLOrderDAOImpl, failed to get all cart items by orderId " + e);
        }
    }

    @Override
    public void confirmOrder(int orderId, String comment) throws DAOException {
        try (Connection connection = CONNECTION_POOL.takeConnection();
             PreparedStatement cs = connection.prepareCall(UPDATE_ORDER_SET_STATUS_AWAITING_PAYMENT)) {
            cs.setInt(1, orderId);
            cs.setString(2, comment);
            cs.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("SQLException in SQLOrderDAOImpl, failed to confirm order " + e);
        }
    }

    @Override
    public void cancelOrder(int orderId, String comment) throws DAOException {
        try (Connection connection = CONNECTION_POOL.takeConnection();
             CallableStatement cs = connection.prepareCall(UPDATE_ORDER_SET_STATUS_CANCELLED)) {
            cs.setInt(1, orderId);
            cs.setString(2, comment);
            cs.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("SQLException in SQLOrderDAOImpl, failed to cancel order " + e);
        }
    }

    @Override
    public String getCommentByOrderId(int orderId) throws DAOException {
        try (Connection connection = CONNECTION_POOL.takeConnection();
             PreparedStatement ps = connection.prepareStatement(SELECT_COMMENT_BY_ORDER_ID)) {
            ps.setInt(1, orderId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getString(1);
                } else {
                    throw new DAOException("Failed to get comment by orderId, result set is empty");
                }
            }
        } catch (SQLException e) {
            throw new DAOException("SQLException in SQLOrderDAOImpl, failed to get comment by orderId " + e);
        }
    }
}
