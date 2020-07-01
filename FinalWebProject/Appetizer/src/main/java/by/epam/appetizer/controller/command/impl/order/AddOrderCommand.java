package by.epam.appetizer.controller.command.impl.order;

import by.epam.appetizer.controller.command.Command;
import static by.epam.appetizer.controller.command.configuration.ParameterName.USER;
import static by.epam.appetizer.controller.command.configuration.ParameterName.USER_CART_ID;
import by.epam.appetizer.controller.command.configuration.PathToJSP;
import by.epam.appetizer.controller.command.exception.CommandException;
import by.epam.appetizer.entity.User;
import by.epam.appetizer.service.OrderService;
import by.epam.appetizer.service.ServiceFactory;
import by.epam.appetizer.service.UserCartService;
import by.epam.appetizer.service.exception.ServiceException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddOrderCommand implements Command {

    private final OrderService orderService = ServiceFactory.getInstance().getOrderService();
    private final UserCartService userCartService = ServiceFactory.getInstance().getUserCartService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        HttpSession session = request.getSession();
        int userId = ((User) session.getAttribute(USER)).getId();
        int userCartId = (int) session.getAttribute(USER_CART_ID);
        session.removeAttribute(USER_CART_ID);

        try {
            orderService.addOrder(userCartId);
            session.setAttribute(USER_CART_ID, userCartService.addUserCart(userId));
//            request.setAttribute(PARAMETER_MESSAGE_ORDER, MESSAGE_SUCCESSFUL_ADD_ORDER);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }

        return PathToJSP.HOME_PAGE_PATH;
    }
}
