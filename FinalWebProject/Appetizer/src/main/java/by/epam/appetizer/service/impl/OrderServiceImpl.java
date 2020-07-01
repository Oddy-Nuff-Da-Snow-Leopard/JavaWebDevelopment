package by.epam.appetizer.service.impl;

import by.epam.appetizer.dao.DAOFactory;
import by.epam.appetizer.dao.OrderDAO;
import by.epam.appetizer.dao.exception.DAOException;
import by.epam.appetizer.entity.CartItem;
import by.epam.appetizer.entity.Order;
import by.epam.appetizer.entity.User;
import by.epam.appetizer.service.CartItemService;
import by.epam.appetizer.service.OrderService;
import by.epam.appetizer.service.ServiceFactory;
import by.epam.appetizer.service.exception.ServiceException;
import java.util.List;

public class OrderServiceImpl implements OrderService {

    private final OrderDAO orderDAO = DAOFactory.getInstance().getOrderDAO();

    @Override //вынести
    public void addOrder(int userCartId) throws ServiceException {
        CartItemService cartItemService = ServiceFactory.getInstance().getCartItemService();
        try {
            double totalPrice = cartItemService.calculateTotalPrice(userCartId);
            orderDAO.addOrder(userCartId, totalPrice);
        } catch (DAOException e) {
            throw new ServiceException("DAOException in OrderServiceImpl,"
                    + " failed to add order " + e);
        }
    }

    public List<Order> getAllOrdersByUserId(int userId) throws ServiceException {
        try {
            return orderDAO.getAllOrdersByUserId(userId);
        } catch (DAOException e) {
            throw new ServiceException("DAOException in OrderServiceImpl,"
                    + " failed to get all orders by userId " + e);
        }
    }

    public List<Order> getAllOrdersByStatusId(int statusId) throws ServiceException {
        try {
            return orderDAO.getAllOrdersByStatusId(statusId);
        } catch (DAOException e) {
            throw new ServiceException("DAOException in OrderServiceImpl,"
                    + " failed to get all orders by statusId " + e);
        }
    }

    public Order getOrderById(String orderId) throws ServiceException {
        try {
            return orderDAO.getOrderById(Integer.parseInt(orderId));
        } catch (DAOException e) {
            throw new ServiceException("DAOException in OrderServiceImpl,"
                    + " failed to get order by orderId " + e);
        }
    }

    public User getUserByOrderId(String orderId) throws ServiceException {
        try {
            return orderDAO.getUserByOrderId(Integer.parseInt(orderId));
        } catch (DAOException e) {
            throw new ServiceException("DAOException in OrderServiceImpl,"
                    + " failed to get user by orderId " + e);
        }
    }

    public List<CartItem> getAllCartItemsByOrderId(String orderId) throws ServiceException {
        try {
            return orderDAO.getAllCartItemsByOrderId(Integer.parseInt(orderId));
        } catch (DAOException e) {
            throw new ServiceException("DAOException in OrderServiceImpl,"
                    + " failed to get all cart items by orderId " + e);
        }
    }

    public void confirmOrder(String orderId, String comment) throws ServiceException {
        try {
            orderDAO.confirmOrder(Integer.parseInt(orderId), comment);
        } catch (DAOException e) {
            throw new ServiceException("DAOException in OrderServiceImpl,"
                    + " failed to confirm order " + e);
        }
    }

    public void cancelOrder(String orderId, String comment) throws ServiceException {
        try {
            orderDAO.cancelOrder(Integer.parseInt(orderId), comment);
        } catch (DAOException e) {
            throw new ServiceException("DAOException in OrderServiceImpl,"
                    + " failed to cancel order " + e);
        }
    }

    public String getCommentByOrderId(String orderId) throws ServiceException {
        try {
            return orderDAO.getCommentByOrderId(Integer.parseInt(orderId));
        } catch (DAOException e) {
            throw new ServiceException("DAOException in OrderServiceImpl,"
                    + " failed to get comment by orderId " + e);
        }
    }
}
