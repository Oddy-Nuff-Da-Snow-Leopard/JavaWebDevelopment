package by.epam.appetizer.dao;

import by.epam.appetizer.dao.exception.DAOException;
import by.epam.appetizer.entity.CartItem;
import java.util.List;

public interface CartItemDAO {

    void addDishToCart(int userCartId, int dishId) throws DAOException;

    void deleteDishFromCart(int cartItemId) throws DAOException;

    void updateQuantity(int cartItemId, int quantity) throws DAOException;

    List<CartItem> getAllCartItemsByUserCartId(int userCartId) throws DAOException;

    List<CartItem> getAllCartItemsByUserId(int userId) throws DAOException;

    CartItem getCartItemById(int cartItemId) throws DAOException;
}
