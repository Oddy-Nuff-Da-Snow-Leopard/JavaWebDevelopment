package by.epam.appetizer.controller.command.impl.cart;

import by.epam.appetizer.controller.command.Command;
import by.epam.appetizer.controller.command.exception.CommandException;

import by.epam.appetizer.service.CartItemService;
import by.epam.appetizer.service.ServiceFactory;

import by.epam.appetizer.entity.CartItem;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.List;

import static by.epam.appetizer.controller.command.configuration.ParameterName.*;
import static by.epam.appetizer.controller.command.configuration.PathToJSP.CART_PAGE_PATH;
import by.epam.appetizer.service.exception.ServiceException;

public class ShowCartPageCommand implements Command {

    private final CartItemService cartItemService = ServiceFactory.getInstance().getCartItemService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws CommandException {
        HttpSession session = request.getSession();

        int userCardId = (int) session.getAttribute(USER_CART_ID);
        List<CartItem> cartItems;
        double totalPrice;
        try {
            cartItems = cartItemService.getAllCartItemsByUserCartId(userCardId);
            totalPrice = cartItemService.calculateTotalPrice(userCardId);
            request.setAttribute(CART_ITEMS, cartItems);
            request.setAttribute(TOTAL_PRICE, totalPrice);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }

        return CART_PAGE_PATH;
    }
}
