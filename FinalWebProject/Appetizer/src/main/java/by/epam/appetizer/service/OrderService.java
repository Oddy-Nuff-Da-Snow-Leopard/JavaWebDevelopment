package by.epam.appetizer.service;

import by.epam.appetizer.entity.CartItem;
import by.epam.appetizer.entity.Order;
import by.epam.appetizer.entity.User;
import by.epam.appetizer.service.exception.ServiceException;
import java.util.List;

public interface OrderService {

    void addOrder(int userCartId) throws ServiceException;

    List<Order> getAllOrdersByUserId(int userId) throws ServiceException;

    List<Order> getAllOrdersByStatusId(int statusId) throws ServiceException;

    Order getOrderById(String orderId) throws ServiceException;

    User getUserByOrderId(String orderId) throws ServiceException;

    List<CartItem> getAllCartItemsByOrderId(String orderId) throws ServiceException;

    void confirmOrder(String orderId, String comment) throws ServiceException;

    void cancelOrder(String orderId, String comment) throws ServiceException;

    String getCommentByOrderId(String orderId) throws ServiceException;
}
