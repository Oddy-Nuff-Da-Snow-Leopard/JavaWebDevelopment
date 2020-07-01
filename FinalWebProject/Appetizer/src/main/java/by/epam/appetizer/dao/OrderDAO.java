package by.epam.appetizer.dao;

import by.epam.appetizer.dao.exception.DAOException;
import by.epam.appetizer.entity.CartItem;
import by.epam.appetizer.entity.Order;
import by.epam.appetizer.entity.User;
import java.util.List;

public interface OrderDAO {

    void addOrder(int userCartId, double totalPrice) throws DAOException;

    List<Order> getAllOrdersByUserId(int idUser) throws DAOException;

    List<Order> getAllOrdersByStatusId(int statusId) throws DAOException;

    Order getOrderById(int orderId) throws DAOException;

    User getUserByOrderId(int orderId) throws DAOException;

    List<CartItem> getAllCartItemsByOrderId(int orderId) throws DAOException;

    void confirmOrder(int orderId, String comment) throws DAOException;

    void cancelOrder(int orderId, String comment) throws DAOException;

    String getCommentByOrderId(int orderId) throws DAOException;
}
