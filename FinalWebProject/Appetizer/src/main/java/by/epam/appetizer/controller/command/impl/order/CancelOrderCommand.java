package by.epam.appetizer.controller.command.impl.order;

import by.epam.appetizer.controller.command.Command;
import static by.epam.appetizer.controller.command.configuration.ParameterName.COMMENT;
import static by.epam.appetizer.controller.command.configuration.ParameterName.ORDER_ID;
import static by.epam.appetizer.controller.command.configuration.PathToJSP.SHOW_ORDERS_LIST_PAGE_COMMAND;
import by.epam.appetizer.controller.command.exception.CommandException;
import by.epam.appetizer.service.OrderService;
import by.epam.appetizer.service.ServiceFactory;
import by.epam.appetizer.service.exception.ServiceException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CancelOrderCommand implements Command {

    private final OrderService orderService = ServiceFactory.getInstance().getOrderService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws CommandException {

        String orderId = request.getParameter(ORDER_ID);
        String comment = request.getParameter(COMMENT);
        try {
            orderService.cancelOrder(orderId, comment);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return SHOW_ORDERS_LIST_PAGE_COMMAND;
    }
}
