package by.epam.appetizer.controller.command.impl.user;

import by.epam.appetizer.controller.command.Command;
import static by.epam.appetizer.controller.command.configuration.ParameterName.ORDERS;
import static by.epam.appetizer.controller.command.configuration.PathToJSP.ORDERS_LIST_PAGE_PATH;
import by.epam.appetizer.controller.command.exception.CommandException;
import by.epam.appetizer.entity.Order;
import by.epam.appetizer.service.OrderService;
import by.epam.appetizer.service.ServiceFactory;
import by.epam.appetizer.service.exception.ServiceException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowOrdersListPageCommand implements Command {

    private final OrderService orderService = ServiceFactory.getInstance().getOrderService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws CommandException {

        try {
            List<Order> orders = orderService.getAllOrdersByStatusId(1);
            request.setAttribute(ORDERS, orders);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return ORDERS_LIST_PAGE_PATH;
    }
}
