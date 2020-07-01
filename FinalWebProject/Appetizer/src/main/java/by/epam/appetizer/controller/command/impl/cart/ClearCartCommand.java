package by.epam.appetizer.controller.command.impl.cart;

import by.epam.appetizer.controller.command.Command;
import static by.epam.appetizer.controller.command.configuration.ParameterName.USER;
import static by.epam.appetizer.controller.command.configuration.ParameterName.USER_CART_ID;
import static by.epam.appetizer.controller.command.configuration.PathToJSP.SHOW_CART_PAGE_COMMAND;
import by.epam.appetizer.controller.command.exception.CommandException;
import by.epam.appetizer.entity.User;
import by.epam.appetizer.service.ServiceFactory;
import by.epam.appetizer.service.UserCartService;
import by.epam.appetizer.service.exception.ServiceException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ClearCartCommand implements Command {

    private final UserCartService userCartService = ServiceFactory.getInstance().getUserCartService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        HttpSession session = request.getSession();
        int idUser = ((User) session.getAttribute(USER)).getId();

        session.removeAttribute(USER_CART_ID);

        try {
            session.setAttribute(USER_CART_ID, userCartService.addUserCart(idUser));
        } catch (ServiceException e) {
            throw new CommandException(e);
        }

        return SHOW_CART_PAGE_COMMAND;
    }
}
