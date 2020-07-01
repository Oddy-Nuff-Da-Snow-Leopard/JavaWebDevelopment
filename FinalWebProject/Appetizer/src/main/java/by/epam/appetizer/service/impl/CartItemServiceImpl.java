package by.epam.appetizer.service.impl;

import by.epam.appetizer.dao.DAOFactory;
import by.epam.appetizer.dao.CartItemDAO;
import by.epam.appetizer.dao.exception.DAOException;
import by.epam.appetizer.entity.CartItem;

import by.epam.appetizer.service.CartItemService;
import by.epam.appetizer.service.exception.ServiceException;
import java.util.List;

public class CartItemServiceImpl implements CartItemService {

    private static final String PLUS_SIGN = "plus";
    private static final String MINUS_SIGN = "minus";

    private final CartItemDAO cartItemDAO = DAOFactory.getInstance().getCartItemDAO();

    public void addDishToCart(int userCartId, String dishId) throws ServiceException {
        try {
            cartItemDAO.addDishToCart(userCartId, Integer.parseInt(dishId));
        } catch (DAOException e) {
            throw new ServiceException("DAOException in CartItemServiceImpl,"
                    + " failed to add dish to cart " + e);
        }
    }

    public void deleteDishFromCart(String cartItemId) throws ServiceException {
        try {
            cartItemDAO.deleteDishFromCart(Integer.parseInt(cartItemId));
        } catch (DAOException e) {
            throw new ServiceException("DAOException in CartItemServiceImpl,"
                    + " failed to delete dish from cart " + e);
        }
    }

    public void updateQuantity(int cartItemId, String sign) throws ServiceException {
        try {
//            if (!CartValidator.getInstance().validate(portion)) {
//                throw new WrongPortionException("Wrong number of portions");
//            }
            CartItem cartItem = cartItemDAO.getCartItemById(cartItemId);

            int quantity = cartItem.getQuantity();
            if (sign.equals(PLUS_SIGN)) {
                quantity += 1;
            } else if (sign.equals(MINUS_SIGN)) {
                quantity -= 1;
            }
            System.out.println(quantity);
            cartItemDAO.updateQuantity(cartItemId, quantity);
        } catch (DAOException e) {
            throw new ServiceException("DAOException in CartItemServiceImpl,"
                    + " failed to update quantity " + e);
        }
    }

    public List<CartItem> getAllCartItemsByUserCartId(int userCartId) throws ServiceException {
        try {
            return cartItemDAO.getAllCartItemsByUserCartId(userCartId);
        } catch (DAOException e) {
            throw new ServiceException("DAOException in CartItemServiceImpl,"
                    + " failed to get all cart items by user cart id " + e);
        }
    }

    public List<CartItem> getAllCartItemsByUserId(int userId) throws ServiceException {
        try {
            return cartItemDAO.getAllCartItemsByUserId(userId);
        } catch (DAOException e) {
            throw new ServiceException("DAOException in CartItemServiceImpl,"
                    + " failed to get all cart items by user id " + e);
        }
    }

    public double calculateTotalPrice(int userCartId) throws ServiceException {
        double totalPrice = 0;
        List<CartItem> cartItems = getAllCartItemsByUserCartId(userCartId);
        for (CartItem cartItem : cartItems) {
            totalPrice += cartItem.getDish().getPrice() * cartItem.getQuantity();
        }
        return totalPrice;
    }
}
