package by.epam.appetizer.controller.command.impl.cart;

import by.epam.appetizer.controller.command.Command;
import static by.epam.appetizer.controller.command.configuration.ParameterName.DISH_ID;
import static by.epam.appetizer.controller.command.configuration.ParameterName.REFERER;
import static by.epam.appetizer.controller.command.configuration.ParameterName.USER_CART_ID;
import by.epam.appetizer.controller.command.exception.CommandException;
import by.epam.appetizer.service.CartItemService;
import by.epam.appetizer.service.ServiceFactory;
import by.epam.appetizer.service.exception.ServiceException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddToCartCommand implements Command {

    private final CartItemService cartItemService = ServiceFactory.getInstance().getCartItemService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws CommandException {
        HttpSession session = request.getSession();
        int userCardId = (int) session.getAttribute(USER_CART_ID);
        try {
            for (String dishId : request.getParameterValues(DISH_ID)) {
                cartItemService.addDishToCart(userCardId, dishId);
            }
        } catch (ServiceException e) {
            throw new CommandException(e);
        }

        return request.getHeader(REFERER);
    }
}
