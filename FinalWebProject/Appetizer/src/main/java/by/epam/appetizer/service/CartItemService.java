package by.epam.appetizer.service;

import by.epam.appetizer.entity.CartItem;
import by.epam.appetizer.service.exception.ServiceException;
import java.util.List;

public interface CartItemService {

    void addDishToCart(int userCartId, String dishId) throws ServiceException;

    void deleteDishFromCart(String cartItemId) throws ServiceException;

    void updateQuantity(int cartItemId, String sign) throws ServiceException;

    List<CartItem> getAllCartItemsByUserCartId(int userCartId) throws ServiceException;

    List<CartItem> getAllCartItemsByUserId(int userId) throws ServiceException;

    double calculateTotalPrice(int userCartId) throws ServiceException;
}
