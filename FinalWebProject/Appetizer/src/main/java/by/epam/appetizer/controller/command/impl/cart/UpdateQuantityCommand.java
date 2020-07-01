package by.epam.appetizer.controller.command.impl.cart;

import by.epam.appetizer.controller.command.Command;
import static by.epam.appetizer.controller.command.configuration.ParameterName.CART_ITEM_ID;
import by.epam.appetizer.controller.command.exception.CommandException;
import static by.epam.appetizer.controller.command.configuration.ParameterName.SIGN;
import static by.epam.appetizer.controller.command.configuration.PathToJSP.SHOW_CART_PAGE_COMMAND;
import by.epam.appetizer.service.CartItemService;
import by.epam.appetizer.service.ServiceFactory;
import by.epam.appetizer.service.exception.ServiceException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UpdateQuantityCommand implements Command {

    private final CartItemService cartItemService = ServiceFactory.getInstance().getCartItemService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        HttpSession session = request.getSession();
        String sign = request.getParameter(SIGN);
        int cartItemId = Integer.parseInt(request.getParameter(CART_ITEM_ID));
        try {
            cartItemService.updateQuantity(cartItemId, sign);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return SHOW_CART_PAGE_COMMAND;
    }
}
